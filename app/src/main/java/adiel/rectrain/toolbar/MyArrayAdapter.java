package adiel.rectrain.toolbar;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import adiel.rectrain.R;

/**
 * Created by recntrek7 on 01/06/17.
 */



public class MyArrayAdapter extends ArrayAdapter<Person> {


    private static LayoutInflater inflater = null;


    public MyArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Person> objects) {
        super(context, resource, textViewResourceId, objects);
        init(context);
    }

    public MyArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person>  objects) {
        super(context, resource, objects);
        init(context);
    }

    private void init(Context context){
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Person person = getItem(position);
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
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        return getItem(position).getPersonType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
