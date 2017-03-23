package adiel.rectrain.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import adiel.rectrain.R;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("adiel","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("adiel","onPause");
    }

    @Override
    protected void onDestroy() {
        Log.d("adiel","onDestroy");
        super.onDestroy();
    }

    public void crashActivity(View view) {
        String crash = null;
        crash.isEmpty();
    }
}
