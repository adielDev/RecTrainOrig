package adiel.rectrain.links;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import adiel.rectrain.R;

public class LinkActivity extends AppCompatActivity {

    public static final String TAG = LinkActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "#####################  onCreate: #######################3 ");
        finish();
    }
}
