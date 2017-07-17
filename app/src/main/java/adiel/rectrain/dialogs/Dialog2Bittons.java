package adiel.rectrain.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import adiel.rectrain.R;

/**
 * Created by recntrek7 on 17/11/16.
 */

public class Dialog2Bittons extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View rootView = layoutInflater.inflate(R.layout.dialog_2_buttons, null);
        TextView positiveTv = (TextView) rootView.findViewById(R.id.positiveTv);
        positiveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "AAAA", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(rootView);

        return builder.create();
    }
}
