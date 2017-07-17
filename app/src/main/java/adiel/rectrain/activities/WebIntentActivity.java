package adiel.rectrain.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import adiel.rectrain.R;

public class WebIntentActivity extends Activity implements Button.OnClickListener {
    private static final String         WEB_PS_CATEGORY = "pluralsight.intent.category.WEB";

    private static final String         LAUNCH_SCHEME = "http";
    private static final String         LAUNCH_AUTHORITY = "www.pluralsight.com";
    private static final String         LAUNCH_PATH = "/";

    private Uri                         mLaunchUri;


    public WebIntentActivity() {
        Uri.Builder             bldr = new Uri.Builder();

        //  Create the URI we will launch when the user touches the button
        bldr.scheme(LAUNCH_SCHEME);
        bldr.authority(LAUNCH_AUTHORITY);
        bldr.path(LAUNCH_PATH);
        mLaunchUri = bldr.build();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Set the main layout and assign ourselves the click listener
        //  for the button
        setContentView(R.layout.web_intent_activity);
        Button launchButton = (Button)findViewById(R.id.launch_button);
        launchButton.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        //  Create an Intent and fire it off
        Intent launchIntent = new Intent(Intent.ACTION_MAIN, mLaunchUri);
        launchIntent.addCategory(Intent.CATEGORY_DEFAULT);
        launchIntent.addCategory(WEB_PS_CATEGORY);
        startActivity(launchIntent);
    }
}