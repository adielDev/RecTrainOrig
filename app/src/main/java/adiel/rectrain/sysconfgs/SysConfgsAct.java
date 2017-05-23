package adiel.rectrain.sysconfgs;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import adiel.rectrain.R;

public class SysConfgsAct extends AppCompatActivity {

    Handler uiHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_confgs);
        getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, new ContentObserver(uiHandler){
            @Override
            public void onChange(boolean selfChange, Uri uri){
                super.onChange(selfChange, uri);
                Toast.makeText(SysConfgsAct.this, "onChange", Toast.LENGTH_SHORT).show();
                Log.d("adiel","on change");
                String key = uri.getPath();
                key = key.substring(key.lastIndexOf("/") + 1, key.length());

                if (key.equals("user_powersaver_enable") || key.equals("psm_switch")){
                    boolean batterySaverEnabled = Settings.System.getString(getContentResolver(), key).equals("1");
                    // do something
                }
            }
        });
    }

    public void isOnSaveMode(View view) {
        final String result = Settings.System.getString(getContentResolver(), "psm_switch");
        //Log.v("Debug", "Powersaving active: " + TextUtils.equals(result, "1"));
        Log.v("Debug", "Powersaving active: " + result);

    }
}
