package adiel.rectrain.toolbar;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import adiel.rectrain.R;


public class AdapterSearchAutoComplete extends BaseAdapter implements Filterable{
   
	Context ctx;
	ArrayList<ModelListitemSearchAutoComplete> modelRow;
	private ArrayList<ModelListitemSearchAutoComplete> filteredModelRow;
	private FixingFilter mFilter = new FixingFilter();
	String query = "";
	
	public AdapterSearchAutoComplete(Context context, ArrayList<ModelListitemSearchAutoComplete> rowData, String query) {
		ctx = context;
		modelRow = rowData;
		filteredModelRow = rowData;
		this.query = query;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
    	ModelListitemSearchAutoComplete rowData = new ModelListitemSearchAutoComplete(filteredModelRow.get(position).name, filteredModelRow.get(position).location);    
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(ctx).inflate(R.layout.listitem_search_autocomplete, parent, false);
       }
       // Lookup view for data population
       TextView tvName = (TextView) convertView.findViewById(R.id.listitem_search_autocomplete_name_tv);
       TextView tvLocation = (TextView) convertView.findViewById(R.id.listitem_search_autocomplete_location_tv);
       //Typeface osSemibold = Typeface.createFromAsset(ctx.getAssets(), "OpenSans-Semibold.ttf");
       //Typeface osRegular = Typeface.createFromAsset(ctx.getAssets(), "OpenSans-Regular.ttf");
       //tvName.setTypeface(osSemibold);
       //tvLocation.setTypeface(osRegular);
       // Populate the data into the template view using the data object
       //tvName.setText(rowData.name);
       tvLocation.setText(rowData.location);
       
       if(rowData.name.indexOf(query) == 0) {
    	  // rowData.namestr.substring(0, 1).toUpperCase() + str.substring(1);
       }
       String lowerCaseName = rowData.name.toLowerCase(Locale.getDefault());
       String lowerCaseQuery = query.toLowerCase(Locale.getDefault());
       if(!query.equalsIgnoreCase("") && lowerCaseName.indexOf(lowerCaseQuery) != -1){
			tvName.setText(Html.fromHtml(rowData.name.substring(0,
					lowerCaseName.indexOf(lowerCaseQuery))
					+ "<font color='#333639'>"
					+ rowData.name.substring(
							lowerCaseName.indexOf(lowerCaseQuery),
							lowerCaseName.indexOf(lowerCaseQuery)
									+ query.length())
					+ "</font>"
					+ rowData.name.substring(lowerCaseName
							.indexOf(lowerCaseQuery) + query.length())));
       } else {
       tvName.setText(rowData.name); 
       }
       Log.wtf(query, "MYQUERY"+query);
       
       // Return the completed view to render on screen
       return convertView;
   }
    
    @Override
    public String getItem(int position) {
    	// TODO Auto-generated method stub
        if(filteredModelRow.size() > position)
    	    return filteredModelRow.get(position).name;
        return "";
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return filteredModelRow.size();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return new FixingFilter();
	}
   
    
	
	private class FixingFilter extends Filter {

		  @Override
	        protected FilterResults performFiltering(CharSequence constraint) {
	            String filterStringName = constraint.toString().toLowerCase(Locale.getDefault());
	            String filterStringLocation = constraint.toString().toLowerCase(Locale.getDefault());

	            FilterResults results = new FilterResults();

	            int count = modelRow.size();
	            final List<ModelListitemSearchAutoComplete> tempItems = new ArrayList<ModelListitemSearchAutoComplete>(count);

	            for (int i = 0; i < count; i++) {
	                if (modelRow.get(i).name.toLowerCase(Locale.getDefault()).contains(filterStringName)) {
	                    tempItems.add(modelRow.get(i));
	                }
	            }

	            results.values = tempItems;
	            results.count = tempItems.size();

	            return results;
	        }

		@SuppressWarnings("unchecked")
		@Override
	        protected void publishResults(CharSequence constraint, FilterResults results) {
	            filteredModelRow = (ArrayList<ModelListitemSearchAutoComplete>) results.values;
	            notifyDataSetChanged();
	        }

	}


	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}