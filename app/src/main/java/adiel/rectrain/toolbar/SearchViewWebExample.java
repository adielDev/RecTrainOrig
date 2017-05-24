package adiel.rectrain.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import adiel.rectrain.R;

public class SearchViewWebExample extends AppCompatActivity {

    ListView lv;
    ListAdapter adapter;
    SearchView searchView;
    ArrayList<String> arrayList;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_web_example);
        lv = (ListView) findViewById(R.id.lv);
        searchView = (SearchView) findViewById(R.id.search);


        arrayList = new ArrayList<>();
//        arrayList.add("April");
//        arrayList.add("May");
//        arrayList.add("June");
//        arrayList.add("July");
//        arrayList.add("August");
//        arrayList.add("September");
//        arrayList.add("October");
//        arrayList.add("November");
//        arrayList.add("December");

        adapter= new ListAdapter(arrayList);
        lv.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("adiel","onQueryTextSubmit");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               // adapter.getFilter().filter(newText);
                Log.d("adiel","onQueryTextChange");
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                arrayList.clear();
                adapter.notifyDataSetChanged();
                Log.d("adiel","onClose");
                return false;
            }
        });
    }

    public void addRow(View view) {
        arrayList.add(""+counter);
        adapter.notifyDataSetChanged();
    }

    public void removeRow(View view) {
        arrayList.remove(0);
        adapter.notifyDataSetChanged();

    }
}
