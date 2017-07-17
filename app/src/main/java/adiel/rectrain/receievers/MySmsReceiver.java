package adiel.rectrain.receievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "onRecieve", Toast.LENGTH_SHORT).show();
        Log.d("adiel","SMS RECEIVED");
    }
}
