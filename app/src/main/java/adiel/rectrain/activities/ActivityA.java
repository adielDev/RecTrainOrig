package adiel.rectrain.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import adiel.rectrain.R;

public class ActivityA extends AppCompatActivity {

    public final static int REQUEST_OPEN_B = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        Log.d("adiel","A onCreate");
    }

    public void startActivityB(View view) {
        Intent intent = new Intent(ActivityA.this,ActivityB.class);
        startActivityForResult(intent,REQUEST_OPEN_B);
    }

    public void startActivityBSecondly(View view) {
        startActivityB(view);
        Intent intent = getIntent();
        String fromB = intent.getStringExtra(ActivityB.DATA_FROM_B);
        if(fromB!=null){
            Log.d("adiel","fromB:"+fromB);
        }else {
            Log.d("adiel","fromB is null");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("adiel","A onActivityResult");
        switch (requestCode){

            case REQUEST_OPEN_B:

                String fromB = data.getStringExtra(ActivityB.DATA_FROM_B);
                if(fromB!=null){
                    Log.d("adiel","REQUEST_OPEN_B fromB="+fromB);
                    Toast.makeText(this, "REQUEST_OPEN_B fromB="+fromB, Toast.LENGTH_SHORT).show();
                }else {
                    Log.d("adiel","REQUEST_OPEN_B fromB= null");
                    Toast.makeText(this, "REQUEST_OPEN_B fromB= null", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("adiel","A onResume");
        Intent intent = getIntent();
        String fromB = intent.getStringExtra(ActivityB.DATA_FROM_B);
        if(fromB!=null){
            Log.d("adiel","fromB:"+fromB);
        }else {
            Log.d("adiel","fromB is null");
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("adiel","A onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("adiel","A onDestroy");


    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("adiel","A onNewIntent");
    }
}
