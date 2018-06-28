package adiel.rectrain.dialogs;

import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import adiel.rectrain.R;

public class CustomAlertDialog extends AppCompatActivity {

    private FireMissilesDialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert_dialog);
        Button btnDFialog = (Button) findViewById(R.id.btnDFialog);
        btnDFialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog.show(CustomAlertDialog.this, "A","b", true);
//                ProgressDialog progressDialog = new ProgressDialog(CustomAlertDialog.this,AlertDialog.THEME_HOLO_DARK);
//                progressDialog.setMessage("aaaaa");
//                progressDialog.show();
            }
        });
    }

    public void showDialog(View view) {
        dialogFragment = new FireMissilesDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"aaaa");
    }

    public void dismissFireDialog(View view) {
        dialogFragment.dismiss();
        boolean isNUll = dialogFragment==null;
        Toast.makeText(this, "is null ="+isNUll, Toast.LENGTH_SHORT).show();
    }

    public void checkIfFireIsNull(View view) {
        boolean isNUll = dialogFragment==null;
        Toast.makeText(this, "is null ="+isNUll, Toast.LENGTH_SHORT).show();
    }


    public void showDialg2(View view) {
        DialogFragment dialogFragment = new DialogWithLayout();
        dialogFragment.show(getSupportFragmentManager(),"dfsd");
    }


    public void dialog2Btns(View view) {
        Dialog2Bittons dialog2Bittons = new Dialog2Bittons();
        dialog2Bittons.show(getFragmentManager(),"tag");
    }

    public void showProgressDialog(View view) {
        MyProgressDialog.show(this,"111111111111","2222222222222",true,true);
     //   ProgressDialog progressDialog = new ProgressDialog(this);
     //   progressDialog.setMessage("message");
    //    progressDialog.setTitle("title");
    //    progressDialog.show();
      //  progressDialog=MyProgressDialog.show(this, "Explorer trek", getString(R.string.waiting_for_location), true, true);


//        ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("aaaaaaaaa");
//        progressDialog.show();
    }

    public void showSimplestDialog(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyDialogStyle);
//        AlertDialog alertDialog = builder.setTitle("title")
//
//                .setMessage("message ")
//                .create();
//        alertDialog.show();
    }

}
/*Right click on res folder, choose New --> Android resource file, set the same name for the new file "styles",
in Available qualifiers: choose the last item "Version" and finally set "Platform API level" 21. */