package adiel.rectrain.annotations;

import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.annotation.Retention;

import adiel.rectrain.R;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class AnnotationActivity extends AppCompatActivity {

    @Retention(SOURCE)
    @IntDef({NAVIGATION_MODE_STANDARD, NAVIGATION_MODE_LIST, NAVIGATION_MODE_TABS})
    public @interface NavigationMode {}

    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_TABS = 2;
    @NavigationMode int  navigationMode = NAVIGATION_MODE_STANDARD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        String textForTv = getNiceText(navigationMode);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(textForTv);

    }

    private @NavigationMode  int getNav(boolean bla){
        if(bla){
            return NAVIGATION_MODE_LIST;
        }else {
            return NAVIGATION_MODE_STANDARD;
        }
    }

    private String getNiceText(@NavigationMode  int num){
        switch (num){

            case NAVIGATION_MODE_STANDARD:
                return "NAVIGATION_MODE_STANDARD";
            case NAVIGATION_MODE_LIST:
                return "NAVIGATION_MODE_LIST";
            case NAVIGATION_MODE_TABS:
                return "NAVIGATION_MODE_TABS";
            default:
                return "default";

        }
    }
}
