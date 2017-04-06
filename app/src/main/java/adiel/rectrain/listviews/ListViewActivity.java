package adiel.rectrain.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import adiel.rectrain.R;

public class ListViewActivity extends AppCompatActivity {


    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv = (ListView) findViewById(R.id.lv);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ListViewActivity.this, "position:"+position, Toast.LENGTH_SHORT).show();
//                lv.getChildAt(5).setBackgroundColor(getColor(R.color.background_orange));
//                lv.getChildAt(position).
//            }
//        });

        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
             "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
             "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter", "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };
        final yourAdapter yourAdapter = new yourAdapter(this, values);
        lv.setAdapter(yourAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lv.smoothScrollByOffset(20);
//                View childAt = lv.getChildAt(position);
//                TextView viewById = (TextView) childAt.findViewById(R.id.text);
//                viewById.setText("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
//                Toast.makeText(ListViewActivity.this, "tag:"+childAt.getTag().toString(), Toast.LENGTH_SHORT).show();
//                lv.getChildAt(5).setBackgroundColor(getColor(R.color.background_orange));
//                lv.getChildAt(position);
            }
        });
    }
}
