package adiel.rectrain.concurency;

        import android.app.Activity;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Looper;
        import android.os.Message;
        import android.os.SystemClock;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import java.security.SecureRandom;

        import adiel.rectrain.R;

public class LooperHanderEx2 extends Activity implements OnClickListener,Handler.Callback {
    private static final int    SIZE_KB = 1024;
    private static final int    SIZE_MB = (SIZE_KB * 1024);
    private static final int    TOTAL_DATA_POINTS = (4 * SIZE_MB);
    private static final String CUSTOM_BCAST_ACTION = "pluralsight.example.action.GENERATE";

    private static final int    MSG_DO_GEN = 0;
    private static final int    MSG_PROG_UPDATE = 1;
    private static final int    MSG_GEN_DONE = 2;
    private static final int    MSG_SHUTDOWN = 3;
    private static final int    MSG_GEN_STARTING = 5;

    private Button              mStartBtn;
    private Button              mStartBtnBR;
    private TextView            mProgressTxt;
    private ProgressBar         mProgress;
    private GenerateReceiver    mGenRec;
    private byte[]              dataBuf = new byte[TOTAL_DATA_POINTS];
    private DataGenThread       mDGThread;
    protected Handler           mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        mStartBtn = (Button)findViewById(R.id.startButton);
        mStartBtnBR = (Button)findViewById(R.id.startButtonBR);
        mProgressTxt = (TextView)findViewById(R.id.prog_txt);
        mProgress = (ProgressBar)findViewById(R.id.gen_progress);

        mStartBtn.setOnClickListener(this);
        mStartBtnBR.setOnClickListener(this);
        mGenRec = new GenerateReceiver();

        mHandler = new Handler(this);
        mDGThread = new DataGenThread();
        mDGThread.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        registerReceiver(mGenRec, new IntentFilter(CUSTOM_BCAST_ACTION));
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(mGenRec);
    }

    @Override
    public void onDestroy() {
        mDGThread.mWorkerHandler.obtainMessage(MSG_SHUTDOWN);
        try {
            mDGThread.join();
        } catch (InterruptedException e) {
            //  ignore
        }

        super.onDestroy();
    }

    private void doGenerate() {
        SecureRandom            randGen = new SecureRandom();
        int                     progScale;
        long                    startTime;
        long                    endTime;

        mHandler.obtainMessage(MSG_GEN_STARTING).sendToTarget();

        startTime = SystemClock.elapsedRealtime();

        progScale = dataBuf.length / 100;

        for (int i = 0; i < dataBuf.length; i++) {
            dataBuf[i] = (byte)randGen.nextInt();

            if ((i % progScale) == 0) {
                mHandler.obtainMessage(MSG_PROG_UPDATE,(i / progScale),0).sendToTarget();
            }
        }

        endTime = SystemClock.elapsedRealtime();
        mHandler.obtainMessage(MSG_GEN_DONE,
                (int)(endTime - startTime),
                0).sendToTarget();
    }


    @Override
    public void onClick(View v) {
        if (v == mStartBtn) {
            //  Send the worker thread a message to start
            //  generation.
            Message startMsg =
                    mDGThread.mWorkerHandler.obtainMessage(MSG_DO_GEN);
            startMsg.sendToTarget();
        } else {
            //  Kick off the BR to do generation
            sendBroadcast(new Intent(CUSTOM_BCAST_ACTION));
        }
    }

    private class GenerateReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            Message startMsg = mDGThread.mWorkerHandler.obtainMessage(MSG_DO_GEN);
            startMsg.sendToTarget();
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_GEN_STARTING:
                mProgress.setVisibility(View.VISIBLE);
                mProgress.setProgress(0);
                mProgressTxt.setVisibility(View.VISIBLE);
                mProgressTxt.setText(R.string.filling_buf);
                break;

            case MSG_PROG_UPDATE:
                mProgress.setProgress(msg.arg1);
                break;

            case MSG_GEN_DONE:
                String doneStr = getString(R.string.done_fill);
                doneStr += Long.toString(msg.arg1) + " ms";
                mProgressTxt.setText(doneStr);
                break;
        }

        return true;
    }

    private class DataGenThread extends Thread implements Handler.Callback {
        private Looper              mWorkerLooper;
        protected Handler           mWorkerHandler;

        @Override
        public void run() {
            Looper.prepare();
            mWorkerLooper = Looper.myLooper();
            mWorkerHandler = new Handler(mWorkerLooper, this);
            Looper.loop();
        }

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_DO_GEN:
                    doGenerate();
                    break;

                case MSG_SHUTDOWN:
                    mWorkerLooper.quit();
                    break;
            }

            return true;
        }
    }
}
