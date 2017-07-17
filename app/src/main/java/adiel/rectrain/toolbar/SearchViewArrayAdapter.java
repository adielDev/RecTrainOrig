package adiel.rectrain.toolbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import adiel.rectrain.utils.UnitConverter;


public class SearchViewArrayAdapter extends SearchView {

	private SearchView.SearchAutoComplete mSearchAutoComplete;

	public SearchViewArrayAdapter(Context context) {
		super(context);
		initialize(context);
	}

	public SearchViewArrayAdapter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}

	public void initialize(Context context) {
		mSearchAutoComplete = (SearchAutoComplete) findViewById(android.support.v7.appcompat.R.id.search_src_text);
		Point pointScreenSize = new Point();

		((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(pointScreenSize);

		mSearchAutoComplete.setDropDownWidth(pointScreenSize.x);
		mSearchAutoComplete.setWidth(pointScreenSize.x);

	    final View dropDownAnchor = findViewById(mSearchAutoComplete.getDropDownAnchor());
		    if (dropDownAnchor != null) {
		        dropDownAnchor.addOnLayoutChangeListener(new OnLayoutChangeListener() {
		            @Override
		            public void onLayoutChange(View v, int left, int top, int right, int bottom,
		                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {

		                // calculate width of DropdownView


		                int point[] = new int[2];
		                dropDownAnchor.getLocationOnScreen(point);
		                // x coordinate of DropDownView
		                int dropDownPadding = point[0] + mSearchAutoComplete.getDropDownHorizontalOffset();

		                Rect screenSize = new Rect();
		                ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRectSize(screenSize);
		                // screen width
		                int screenWidth = screenSize.width();

		                // set DropDownView width
		                mSearchAutoComplete.setDropDownWidth(screenWidth);
		                mSearchAutoComplete.setDropDownVerticalOffset((int) UnitConverter.dpToPx(9.5f));

		            }
		        });
		    }
		
		this.setAdapter(null);
		this.setOnItemClickListener(null);
	}

	@Override
	public void setSuggestionsAdapter(CursorAdapter adapter) {
		// don't let anyone touch this
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		mSearchAutoComplete.setOnItemClickListener(listener);
	}

	public void setAdapter(AdapterSearchAutoComplete itemsAdapter) {
		mSearchAutoComplete.setAdapter(itemsAdapter);
	}
	
	public void setArrayAdapter(ArrayAdapter<String> itemsAdapterARR) {
		mSearchAutoComplete.setAdapter(itemsAdapterARR);
    }

    public ListAdapter getArrayAdapter()
    {
        return mSearchAutoComplete.getAdapter();
    }

	public void setText(String text) {
		mSearchAutoComplete.setText(text);
	}

}