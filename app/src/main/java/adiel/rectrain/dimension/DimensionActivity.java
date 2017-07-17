package adiel.rectrain.dimension;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.LinearLayout;

import adiel.rectrain.R;
import adiel.rectrain.utils.UnitConvert;
import adiel.rectrain.utils.UnitConverter;

public class DimensionActivity extends AppCompatActivity {

    LinearLayout changeHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dimension);
        changeHeight = (LinearLayout) findViewById(R.id.changeHeight);

        final Window mRootWindow = getWindow();
        View mRootView = mRootWindow.getDecorView().findViewById(android.R.id.content);
        mRootView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        Rect r = new Rect();
                        View view = mRootWindow.getDecorView();
                        view.getWindowVisibleDisplayFrame(r);
                        Log.d("adiel", "left " + r.left);
                        Log.d("adiel", "top " + r.top);
                        Log.d("adiel", "right " + r.right);
                        Log.d("adiel", "bottom " + r.bottom);
                        Log.d("adiel", "*************************");
                        // r.left, r.top, r.right, r.bottom
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) changeHeight.getLayoutParams();
                        int heightPixels = Resources.getSystem().getDisplayMetrics().heightPixels;
                        Log.d("adiel","heightPixels:"+heightPixels);
                        float pxToDp = UnitConverter.pxToDp(r.height());
                        //float pxToDp = UnitConverter.pxToDp(heightPixels-r.height());
                        //layoutParams.height = (int) (pxToDp/2);
                        layoutParams.height = (int)( pxToDp);
                    }
                });
    }
}
