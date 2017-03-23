package adiel.rectrain.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by recntrek7 on 08/12/16.
 */

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public MyIntentService(){
        super("myIntentService");

    }

    public MyIntentService(String name) {
        super(name);
        Log.d("adiel","myIntenet Service constracor");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("adiel","myIntenet Service on handle INtent");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("adiel","myIntenet Service onDestroy");
    }
}
