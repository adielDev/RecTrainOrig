package adiel.rectrain.concurency;

        import android.app.Activity;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.os.SystemClock;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import java.security.SecureRandom;
        import java.util.concurrent.CancellationException;
        import java.util.concurrent.ExecutionException;

        import adiel.rectrain.R;

public class AsyncTaskEx extends Activity implements View.OnClickListener {
    private static final int    SIZE_KB = 1024;
    private static final int    SIZE_MB = (SIZE_KB * 1024);
    private static final int    TOTAL_DATA_POINTS = (4 * SIZE_MB);
    private static final String CUSTOM_BCAST_ACTION = "pluralsight.example.action.GENERATE";

    private Button              mStartBtn;
    private Button              mStartBtnBR;
    private TextView            mProgressTxt;
    private ProgressBar         mProgress;
    private GenerateReceiver    mGenRec;
    private byte[]              dataBuf = new byte[TOTAL_DATA_POINTS];
    private GenAsyncTask        mGenAT;

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
        if (mGenAT != null) {
            mGenAT.cancel(true);
            try {
                mGenAT.get();
            } catch (ExecutionException e) {
                //  ignore
            } catch (InterruptedException e) {
                //  ignore
            } catch (CancellationException e) {
                //  ignore
            }

            mGenAT = null;
        }

        super.onDestroy();
    }

    private void doGenerate() {
        mProgress.setVisibility(View.VISIBLE);
        mProgress.setProgress(0);
        mProgressTxt.setVisibility(View.VISIBLE);
        mProgressTxt.setText(R.string.filling_buf);

        if (mGenAT == null) {
            mGenAT = new GenAsyncTask();
            mGenAT.execute(dataBuf);
        }
    }


    @Override
    public void onClick(View v) {
        if (v == mStartBtn) {
            //  Start generating data, do it right here.
            doGenerate();
        } else {
            //  Kick off the BR to do generation
            sendBroadcast(new Intent(CUSTOM_BCAST_ACTION));
        }
    }

    private class GenerateReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            doGenerate();
        }
    }

    private class GenAsyncTask extends AsyncTask<byte[], Integer, Long> {

        @Override
        protected Long doInBackground(byte[]... arg0) {
            SecureRandom            randGen = new SecureRandom();
            int                     progScale;
            long                    startTime;
            long                    endTime;

            startTime = SystemClock.elapsedRealtime();

            progScale = dataBuf.length / 100;

            for (int i = 0; i < dataBuf.length; i++) {
                if (isCancelled()) {
                    //  We have been cancelled, exit.
                    break;
                }
                dataBuf[i] = (byte)randGen.nextInt();

                if ((i % progScale) == 0) {
                    publishProgress(i / progScale);
                }
            }

            endTime = SystemClock.elapsedRealtime();
            return (endTime - startTime);
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            mProgress.setProgress(progress[0]);
        }

        @Override
        protected void onPostExecute(Long result) {
            String doneStr = getString(R.string.done_fill);
            doneStr += result.toString() + " ms";
            mProgressTxt.setText(doneStr);
            mGenAT = null;
        }
    }
}
