package adiel.rectrain.toolbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adiel.rectrain.R;

/**
 * Created by recntrek7 on 01/06/17.
 */

public class MyBaseAdapter extends BaseAdapter implements Filterable {

    private static LayoutInflater inflater = null;

    ArrayList<Person> persons;

    public MyBaseAdapter(@NonNull Context context, @NonNull ArrayList<Person> personList) {
        persons = personList;
        init(context);
    }

    private void init(Context context){
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {
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

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Filter getFilter() {

        return new MyFilter();
    }



    public class MyFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

        }
    }


}
