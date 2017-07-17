package adiel.rectrain;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by recntrek7 on 09/05/17.
 */

@ReportsCrashes(formUri = "http://www.backendofyourchoice.com/reportpath")
//@ReportsCrashes(formUri = "http://127.0.0.1")
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "app:onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }
}
