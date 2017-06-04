package adiel.rectrain.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import adiel.rectrain.R;
import adiel.rectrain.toolbar.Person;

public class LvDiffLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_diff_layout);


        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"aaaaa"));
        persons.add(new Person(2,"bbb"));
        ComplexAdapter complexAdapter = new ComplexAdapter(this,persons);

        ComplexArrayAdapter complexArrayAdapter = new ComplexArrayAdapter(this,persons);

        ListView lv = (ListView) findViewById(R.id.lv);

        //lv.setAdapter(complexAdapter);
        lv.setAdapter(complexArrayAdapter);



    }
}
