package adiel.rectrain.nestedscroll;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import adiel.rectrain.R;

public class NestedScrollEx extends AppCompatActivity {


    ListView bootomLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_ex);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int height = size.y;


        final NestedScrollView nestedScroll = (NestedScrollView) findViewById(R.id.nestedScroll);
        final ViewGroup.LayoutParams nestedLayoutParams = nestedScroll.getLayoutParams();
        nestedLayoutParams.height = height;
        nestedScroll.setLayoutParams(nestedLayoutParams);
        nestedScroll.invalidate();

        bootomLv = (ListView) findViewById(R.id.bootomLv);
        final ViewGroup.LayoutParams lvLayoutParams = bootomLv.getLayoutParams();
        lvLayoutParams.height = height;
        bootomLv.setLayoutParams(lvLayoutParams);
        bootomLv.invalidate();


        bootomLv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Rect rect = measureView(v);
                boolean isViewFullAllScreen = rect.height()>height-100;
                return !isViewFullAllScreen;  //false enable touch
                //return false;  //false enable touch
            }
        });
    }

    public void measureVisible(View view) {
        measureView(view);
    }

    public void measureBotttomBtn(View view) {
        Button button = (Button) findViewById(R.id.measureVisible);
        measureView(button);
    }

    private Rect measureView (View view){
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Log.d("adiel","top:"+rect.top);
        Log.d("adiel","left:"+rect.left);
        Log.d("adiel","bottom:"+rect.bottom);
        Log.d("adiel","right:"+rect.right);
        Log.d("adiel","*****************************************************");

        return rect;
    }
}
