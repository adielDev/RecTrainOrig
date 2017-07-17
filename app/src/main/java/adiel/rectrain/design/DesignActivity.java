package adiel.rectrain.design;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import adiel.rectrain.R;

public class DesignActivity extends AppCompatActivity {


    Button wantFocus;
    EditText etWantFocus;
    LinearLayout addMeViews;
    int counter = 5;
    boolean isEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
       final TextView tvTrekNameNOtLInear= (TextView) this.findViewById(R.id.tvTrekNameNOtLInear);
        tvTrekNameNOtLInear.setSelected(true);
 final TextView tvTrekName= (TextView) this.findViewById(R.id.tvTrekName);
        tvTrekName.setSelected(true);

      /*  final TextView tv = (TextView) this.findViewById(R.id.mywidget);
        tv.setSelected(true);
*/


        addMeViews = (LinearLayout) findViewById(R.id.addMeViews);
        TextView textView = new TextView(getApplicationContext());
        TextView tv1 = (TextView) findViewById(R.id.tv1);


        etWantFocus = (EditText) findViewById(R.id.etWantFocus);
        etWantFocus.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                } else {
                    closeVirtualKeyboard();
                }
            }
        });

        wantFocus = (Button) findViewById(R.id.wantFocus);
        wantFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DesignActivity.this, "got focus !!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void closeKeybord(View view) {
        closeVirtualKeyboard();
    }

    private void closeVirtualKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void changeFocus(View view) {
        //changeFocus(wantFocus);
        //wantFocus.requestFocus();
        etWantFocus.requestFocus();

    }

    public void clearFocus(View view) {
        etWantFocus.clearFocus();
    }

    public void addViews(View view) {
        TextView textView = new TextView(getApplicationContext());
        textView.setText("" + counter);

        textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.background_black));
        //addMeViews.addView(textView);
        int childCount = addMeViews.getChildCount();
        addMeViews.addView(textView, childCount - 1);
        counter++;
    }
}
