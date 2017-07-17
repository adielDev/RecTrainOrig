package adiel.rectrain.lifecycle;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import adiel.rectrain.R;

public class LifeCycleActivity extends AppCompatActivity {


    TextView tvData;
    int counter = 0;


    public interface LifeCycleEvents {
        void dataComeIn();
    }
    private class LifeCyclemanager implements LifeCycleEvents {

        LifeCycleEvents cycleEvents;
        Handler uiHandler;

        public LifeCyclemanager(LifeCycleEvents cycleEvents, Handler uiHandler) {
            this.cycleEvents = cycleEvents;
            this.uiHandler = uiHandler;
        }

        public void setCycleEvents(LifeCycleEvents cycleEvents) {
            this.cycleEvents = cycleEvents;
        }

        @Override
        public void dataComeIn() {
            uiHandler.post(new Runnable() {
                @Override
                public void run() {
                    lifeCyclemanager.dataComeIn();
                }
            });

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        tvData = (TextView) findViewById(R.id.tvData);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifeCyclemanager.setCycleEvents(onResumeMode);
        Log.d("adiel", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifeCyclemanager.setCycleEvents(onPauseMode);
        Log.d("adiel", "onPause");
    }

    @Override
    protected void onDestroy() {
        Log.d("adiel", "onDestroy");
        lifeCyclemanager.setCycleEvents(onDestroyMode);
        super.onDestroy();
    }

    public void crashActivity(View view) {
        String crash = null;
        crash.isEmpty();
    }

    public void dataIn(View view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lifeCyclemanager.dataComeIn();
            }
        });
        thread.start();


    }

    public void dataInDelay(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lifeCyclemanager.dataComeIn();
            }
        }, 3000);
    }

    public void finish(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lifeCyclemanager.dataComeIn();
            }
        };
        new Handler().postDelayed(runnable,1000);
        finish();
    }


    public LifeCycleEvents onResumeMode = new LifeCycleEvents() {

        @Override
        public void dataComeIn() {
            tvData.setText("on resume"+counter);
            Snackbar.make(tvData,"blaaaa",Snackbar.LENGTH_SHORT).show();
            counter++;
        }
    };
    public LifeCycleEvents onPauseMode = new LifeCycleEvents() {

        @Override
        public void dataComeIn() {
            tvData.setText("on pause"+counter);
            Snackbar.make(tvData,"blaaaa",Snackbar.LENGTH_SHORT).show();
        }
    };
    public LifeCycleEvents initMode = new LifeCycleEvents() {

        @Override
        public void dataComeIn() {
            Log.d("adiel","data come in  at init");
            tvData.setText("on pause"+counter);
            Snackbar.make(tvData,"blaaaa",Snackbar.LENGTH_SHORT).show();
        }
    };
     public LifeCycleEvents onDestroyMode = new LifeCycleEvents() {

        @Override
        public void dataComeIn() {
            Log.d("adiel","data come in  on destroy");
            tvData.setText("on destroy"+counter);
            Snackbar.make(tvData,"blaaaa",Snackbar.LENGTH_SHORT).show();
        }
    };

    Handler uiHandler = new Handler();
    LifeCyclemanager lifeCyclemanager = new LifeCyclemanager(initMode,uiHandler);
}
