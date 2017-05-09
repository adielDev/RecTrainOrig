package adiel.rectrain;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by recntrek7 on 09/05/17.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "app:onCreate", Toast.LENGTH_SHORT).show();
    }
}
