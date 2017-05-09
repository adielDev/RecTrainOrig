package adiel.rectrain.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import adiel.rectrain.R;

public class ActivityB extends AppCompatActivity {

    public final static int RESULT_NICE =11;
    public final static String DATA_FROM_B="dataFromB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("adiel","B onCreate");
        setContentView(R.layout.activity_b);
    }

    public void returnToA(View view) {
        Intent data = new Intent(ActivityB.this,ActivityA.class);
        data.putExtra(DATA_FROM_B,"data from b");
        setResult(RESULT_NICE,data);
        finish();
        //startActivity(data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("adiel","B onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("adiel","B onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("adiel","B onDestroy");
    }
}
