package adiel.rectrain.proguardex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import adiel.rectrain.R;

public class ProguardExAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proguard_ex);
    }

    public void log(View view) {
        MyLogger.LogD("log");
    }
}
