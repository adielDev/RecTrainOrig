package adiel.rectrain.toolbar;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adiel.rectrain.R;
import adiel.rectrain.listviews.ComplexArrayAdapter;

public class AutoCompleteSearchEx extends AppCompatActivity  {

    SearchView searchView;
    ArrayList<String> arrayList;
    int counter=0;

    public Toolbar toolBar;

    ArrayAdapter<String> adapter;
    AutoCompleteTextView textView;
    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
    private SearchView tbSearchView;
    private SearchView.SearchAutoComplete tbSearchAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_search_ex);
        toolBar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);





        adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"aaaaa"));
        persons.add(new Person(2,"bbbbb"));

        MyArrayAdapter myArrayAdapter = new MyArrayAdapter(this,-1,persons);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this,persons);

        ComplexArrayAdapter complexArrayAdapter = new ComplexArrayAdapter(this,persons);

        textView = (AutoCompleteTextView) findViewById(R.id.countries_list);
        //textView.setAdapter(adapter);
        //textView.setAdapter(myBaseAdapter);
        //textView.setAdapter(myArrayAdapter);
        textView.setAdapter(complexArrayAdapter);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("adiel",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.auto_complete_with_list, menu);

        tbSearchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        tbSearchView.setMinimumWidth(tbSearchView.getMaxWidth());
        ArrayAdapter<String> tbAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"aaaaa"));
        persons.add(new Person(2,"bbbbb"));
        MyArrayAdapter myArrayAdapter = new MyArrayAdapter(this,-1,persons);
        //DelimiterAdapter delimiterAdapter = new DelimiterAdapter(this,)

        tbSearchAutoComplete = (SearchView.SearchAutoComplete) tbSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        //tbSearchAutoComplete.setAdapter(tbAdapter);

        ComplexArrayAdapter complexArrayAdapter = new ComplexArrayAdapter(this,persons);
        tbSearchAutoComplete.setAdapter(complexArrayAdapter);

        tbSearchAutoComplete.setDropDownWidth(ViewGroup.LayoutParams.WRAP_CONTENT);

        //tbSearchAutoComplete.setDropDownHorizontalOffset(0);
        //tbSearchAutoComplete.setDropDownVerticalOffset(0);

        //tbSearchAutoComplete.

        tbSearchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AutoCompleteSearchEx.this, "item", Toast.LENGTH_SHORT).show();
            }
        });
        tbSearchAutoComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        return true;
    }

    public void invoke(View view) {
        textView.showDropDown();
    }

    public void invokeTbAc(View view) {
         tbSearchAutoComplete.showDropDown();

    }

    public void closeTbAc(View view) {
        tbSearchAutoComplete.dismissDropDown();
    }
}
