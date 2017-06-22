package adiel.rectrain.animations;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import adiel.rectrain.R;

public class NIceAnimAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nice_anim);
        LinearLayout root = (LinearLayout) findViewById(R.id.root);
        TextView textView = new TextView(getApplicationContext());
        Drawable drawable1 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.my_ripple);

        textView.setText(getString(R.string.track_info));
        textView.setBackground(drawable1);
        textView.setGravity(Gravity.CENTER);


        textView.setTextColor(getColor(R.color.background_black));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NIceAnimAct.this, "bbbbbb", Toast.LENGTH_SHORT).show();
            }
        });
        root.addView(textView);
    }
}
