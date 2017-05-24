package adiel.rectrain.toolbar;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import adiel.rectrain.R;

public class ToolBarActivity extends AppCompatActivity {
    AdapterSearchAutoComplete itemsAdapter=null;
    public Toolbar toolBar;
    //private SearchView searchView;
    private SearchViewArrayAdapter searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        toolBar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);


        ArrayList<ModelListitemSearchAutoComplete> arrSuggestions = new ArrayList<>();
        arrSuggestions.add(new ModelListitemSearchAutoComplete("A", "ADD LOCATION")); // "ADD LOCATION" will not be displayed currently
        arrSuggestions.add(new ModelListitemSearchAutoComplete("b", "ADD LOCATION")); // "ADD LOCATION" will not be displayed currently
        arrSuggestions.add(new ModelListitemSearchAutoComplete("c", "ADD LOCATION")); // "ADD LOCATION" will not be displayed currently
        arrSuggestions.add(new ModelListitemSearchAutoComplete("d", "ADD LOCATION")); // "ADD LOCATION" will not be displayed currently
        arrSuggestions.add(new ModelListitemSearchAutoComplete("e", "ADD LOCATION")); // "ADD LOCATION" will not be displayed currently

        if(arrSuggestions==null){
            throw new NullPointerException("aaaaaaaaaaaaaaaaaaaa");
        }
        itemsAdapter = new AdapterSearchAutoComplete(this, arrSuggestions, "vvvvvvvvvv");



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        searchView.setAdapter(itemsAdapter);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.auto_complete, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem item = menu.findItem(R.id.action_search);
        //searchView = (SearchViewArrayAdapter) MenuItemCompat.getActionView(item);
        searchView = (SearchViewArrayAdapter) MenuItemCompat.getActionView(item);
       final EditText searchQuery = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        if(searchView==null){
            throw new NullPointerException("bllllllllllllllllllla");
        }


       // int[] attrs = new int[]{R.attr.char_limit_search_field};
        //TypedArray typedArray = obtainStyledAttributes(R.style.InputStringRangeThemeGen, attrs);
        //int charLimitSearchField = typedArray.getInt(0, 200);
        //InputFilter[] charLimitInputFilter = new InputFilter[1];
        //charLimitInputFilter[0]= new InputFilter.LengthFilter(charLimitSearchField);
        //searchQuery.setFilters(charLimitInputFilter);


        searchView.setQueryHint(getResources().getString(R.string.where_do_you_want_to_travel));
        ImageView ivMag = (ImageView) searchView.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
        searchView.setIconifiedByDefault(false);
        ivMag.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        //searchQuery.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f);



        MenuItemCompat.setOnActionExpandListener(menu.findItem(R.id.action_search), new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Go back to fragExplore when searchView is collapsed
                searchView.setAdapter(itemsAdapter);
                return true; // Keep it true
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true; // Keep it true
            }
        });


        return true;
    }
}
