package adiel.rectrain.listviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import adiel.rectrain.R;
import adiel.rectrain.toolbar.Person;

/**
 * Created by recntrek7 on 01/06/17.
 */

public class ComplexAdapter extends BaseAdapter {

    Context context;
    ArrayList<Person> data;
    private static LayoutInflater inflater = null;

    public ComplexAdapter(Context context, ArrayList<Person> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = (Person) getItem(position);
        int personType =person.getPersonType() ;
        switch (personType){

            case 1:
                convertView= inflater.inflate(R.layout.person_one, null);
                break;
            case 2:
                convertView= inflater.inflate(R.layout.person_two, null);
                break;

        }

        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        tv.setText(person.getName());

        return convertView;
    }
}
