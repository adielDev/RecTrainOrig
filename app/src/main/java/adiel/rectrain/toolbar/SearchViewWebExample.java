package adiel.rectrain.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
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

    public Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_web_example);
        toolBar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        lv = (ListView) findViewById(R.id.lv);
        searchView = (SearchView) findViewById(R.id.search);


        arrayList = new ArrayList<>();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.auto_complete_web, menu);
        return true;
    }

    public void addRow(View view) {
        arrayList.add(""+counter);
        adapter.notifyDataSetChanged();
    }

    public void removeRow(View view) {
        arrayList.remove(0);
        adapter.notifyDataSetChanged();

    }

    public void closeSearch(View view) {
        arrayList.clear();
        adapter.notifyDataSetChanged();
        searchView.setIconified(true);

    }
}
