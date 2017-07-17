package adiel.rectrain.services;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import adiel.rectrain.R;

public class ServiceExampleOne extends AppCompatActivity {

    private static final int MY_PERMISSION_ACCESS_COURSE_LOCATION = 1;
    private LocalBroadcastManager localBroadcastManager;
    boolean isBound=false;
    private MyServiceConnecion myServiceConnecion;
    private GpsBoundService.GpsBinder gpsBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("adiel","ServiceExampleOne:onCreate");
        setContentView(R.layout.activity_service_example_one);
        localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    MY_PERMISSION_ACCESS_COURSE_LOCATION );
        }

    }

    @Override
    protected void onDestroy() {
        Log.d("adiel","ServiceExampleOne:onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("adiel","ServiceExampleOne:onResume");
        IntentFilter intentFilter = new IntentFilter("nice");
        localBroadcastManager.registerReceiver(broadcastReceiver,intentFilter);
        //registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("adiel","ServiceExampleOne:onPause");
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
            unbindService(myServiceConnecion);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String val = intent.getStringExtra("val");
            Toast.makeText(context, "val="+val, Toast.LENGTH_SHORT).show();
        }
    };

    public void startService(View view) {
        startService(new Intent(ServiceExampleOne.this,GpsService.class));
    }

    public void startBoundService(View view) {
        Intent intent = new Intent(ServiceExampleOne.this,GpsBoundService.class);
         myServiceConnecion = new MyServiceConnecion();
        startService(new Intent(ServiceExampleOne.this,GpsBoundService.class));
        bindService(intent,myServiceConnecion,0);
    }

    public void comunucateWithBoundService(View view) {
        int add = gpsBinder.add(2, 2);
        Toast.makeText(this, "2+2="+add, Toast.LENGTH_SHORT).show();
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(ServiceExampleOne.this,MyIntentService.class);
        startService(intent);
    }

    public void checkIfBoundServiceIsAlive(View view) {
        int state = gpsBinder.getState();
        Log.d("adiel","state:"+state);
        Toast.makeText(this, "state:"+state, Toast.LENGTH_SHORT).show();
    }

    public void stopBoundService(View view) {
        gpsBinder.stopMyService();
    }

    class MyServiceConnecion implements ServiceConnection {



        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(getApplicationContext(), "onServiceConnected", Toast.LENGTH_SHORT).show();
             gpsBinder = (GpsBoundService.GpsBinder) service;
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(getApplicationContext(), "onServiceDisconnected", Toast.LENGTH_SHORT).show();
            isBound=false;
        }
    }
}
