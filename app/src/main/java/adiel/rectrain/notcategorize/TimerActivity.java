package adiel.rectrain.notcategorize;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import adiel.rectrain.R;

public class TimerActivity extends AppCompatActivity {

    private TextView mTextField;
    private boolean cancelFirst;
    private Timer timer;
    private UpdateBallTask updateBall;
    private CancelBallTask cancelBallTask;


    class UpdateBallTask extends TimerTask {

        public void run() {
            //calculate the new position of myBall
            Log.d("adiel","run");
        }
    }
    class CancelBallTask extends TimerTask {
        public void run() {
            updateBall.cancel();
            cancel();
            Log.d("adiel","cancel");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        mTextField = (TextView) findViewById(R.id.mTextField);
        timer = new Timer();


    }
    @Override
    protected void onResume() {
        super.onResume();



    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }

    public void startTimerTask(View view) {

        updateBall = new UpdateBallTask();
        cancelBallTask = new CancelBallTask();
        timer.schedule(updateBall, 0, 200);
        timer.schedule(cancelBallTask, new Date(System.currentTimeMillis()+3000), 200);
    }

}
