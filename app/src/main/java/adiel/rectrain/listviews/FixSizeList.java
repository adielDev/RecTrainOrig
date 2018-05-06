package adiel.rectrain.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import adiel.rectrain.R;

public class FixSizeList extends AppCompatActivity {

    LinearLayout fixSizeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_size_list);

        fixSizeList = (LinearLayout) findViewById(R.id.fixSizeList);
    }

    public void addItem(View view) {
        //LinearLayout itemView = (LinearLayout) LayoutInflater.from(this)
        getItem(getLayoutInflater());
    }

    public View getItem(LayoutInflater layoutInflater){

        for (int i = 0; i < 10; i++) {
            LinearLayout itemView = (LinearLayout) layoutInflater.inflate(R.layout.fix_list_item, null);
            TextView  tvContent = (TextView) itemView.findViewById(R.id.tvContent);
            tvContent.setText(""+i);
            fixSizeList.addView(itemView);
        }

        return null;

    }
}
