package adiel.rectrain.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import adiel.rectrain.R;

public class NestedStateActivity extends AppCompatActivity {


    private LifeCycleManager lifeCycleManager;


    private interface IRecordingState {
        void locationChanged();
    }
    private interface LifeCycleEvents extends IRecordingState {
        void setRecordingState();
        void setNavigatingSTate();
    }


    private class LifeCycleManager implements LifeCycleEvents {

        LifeCycleEvents lifeCycleEvents;

        @Override
        public void locationChanged() {
            lifeCycleEvents.locationChanged();
        }

        @Override
        public void setRecordingState() {
            lifeCycleEvents.setRecordingState();
        }

        @Override
        public void setNavigatingSTate() {
            lifeCycleEvents.setNavigatingSTate();
        }


        public void setOnResumeMode(LifeCycleEvents mode) {
            lifeCycleEvents = mode;
        }

        public void setOnPauseMode(LifeCycleEvents mode) {
            lifeCycleEvents = mode;
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_state);
        lifeCycleManager = new LifeCycleManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifeCycleManager.setOnResumeMode(onResumeMode);
        Log.d("adiel", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifeCycleManager.setOnPauseMode(onPauseMode);
        Log.d("adiel", "onPause");
    }


    public void onClick(View view) {
        lifeCycleManager.locationChanged();
    }

    private LifeCycleEvents onResumeMode = new LifeCycleEvents() {



        private IRecordingState stateRecording= new IRecordingState() {

            @Override
            public void locationChanged() {
                Toast.makeText(NestedStateActivity.this, " stateOne onResumeMode : locationChanged", Toast.LENGTH_SHORT).show();
                Log.d("adiel", " stateOne onResumeMode : locationChanged");
            }

        };

       private IRecordingState stateNavigating = new IRecordingState() {

            @Override
            public void locationChanged() {
                Toast.makeText(NestedStateActivity.this, " stateOne onResumeMode : locationChanged", Toast.LENGTH_SHORT).show();
                Log.d("adiel", " stateOne onResumeMode : locationChanged");
            }

        };

        IRecordingState recordingState;

        @Override
        public void setRecordingState() {
            recordingState = stateRecording;
        }

        @Override
        public void setNavigatingSTate() {
            recordingState = stateNavigating;
        }


        @Override
        public void locationChanged() {
            recordingState.locationChanged();
        }
    };

    private  LifeCycleEvents onPauseMode = new LifeCycleEvents() {
        private IRecordingState stateRecording = new IRecordingState() {

            @Override
            public void locationChanged() {
                Toast.makeText(NestedStateActivity.this, " stateOne onPauseMode : locationChanged", Toast.LENGTH_SHORT).show();
                Log.d("adiel", " stateOne onPauseMode : locationChanged");
            }

        };

        private IRecordingState stateNavigating = new IRecordingState() {

            @Override
            public void locationChanged() {
                Toast.makeText(NestedStateActivity.this, " stateOne onPauseMode : locationChanged", Toast.LENGTH_SHORT).show();
                Log.d("adiel", " stateOne onPauseMode : locationChanged");
            }

        };

        IRecordingState recordingState;

        @Override
        public void setRecordingState() {
            recordingState= stateRecording;
        }

        @Override
        public void setNavigatingSTate() {
            recordingState= stateNavigating;
        }


        @Override
        public void locationChanged() {
            recordingState.locationChanged();
        }

    };
}
