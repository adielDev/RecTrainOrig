package adiel.rectrain.services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by recntrek7 on 07/12/16.
 */

public class GpsService extends Service  {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent nice = new Intent("nice");
        nice.putExtra("val","nice");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(nice);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
