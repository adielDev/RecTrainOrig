package adiel.rectrain.dialogs;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import adiel.rectrain.R;


/**
 * Created by recntrek7 on 20/11/16.
 */

public class MyProgressDialog extends ProgressDialog {


    public MyProgressDialog(Context context) {
        super(context);
    }

    public MyProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public static ProgressDialog show(Context context, CharSequence title,
                                      CharSequence message, boolean indeterminate,
                                      boolean cancelable) {
        ProgressDialog dialog = new ProgressDialog(context,R.style.DialogProgressStyle);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setIndeterminate(indeterminate);
        dialog.setCancelable(cancelable);
        dialog.show();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.dialog_2_buttons, null);
        dialog.setView(view1);
        return dialog;
    }


}
