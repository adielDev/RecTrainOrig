package adiel.rectrain.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by recntrek7 on 07/12/16.
 */

public class GpsBoundService extends Service {

    public final static int DEAD=0;
    public final static int LIVE=1;

    public  static int state=DEAD;

    private IBinder gpsBinder;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent nice = new Intent("nice");
        nice.putExtra("val","nice");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(nice);
        state=LIVE;

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        gpsBinder = new GpsBinder();
        return gpsBinder;
    }

    class GpsBinder extends Binder {
        public int add (int num1,int num2){
            return num1+num2;
        }

       public int getState(){
           return state;
       }
       public void stopMyService(){
           stopSelf();
       }

    }

    @Override
    public void onDestroy() {
        state=DEAD;
        super.onDestroy  ();
    }
}
