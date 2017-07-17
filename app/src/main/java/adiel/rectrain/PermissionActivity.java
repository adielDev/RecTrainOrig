package adiel.rectrain;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        permissions.add(Manifest.permission.RECEIVE_SMS);
        permissions.add(Manifest.permission.INTERNET);
        boolean permissionGranted=true;
        for(String permission : permissions){
            permissionGranted = (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED);
            if(!permissionGranted){
                break;
            }
        }
        if(permissionGranted) {
            startActivityMain();
            finish();
        }else {
            String[] permissionArray = new String[permissions.size()];
            for (int i = 0; i <permissions.size() ; i++) {
                permissionArray[i] = permissions.get(i);
            }
            ActivityCompat.requestPermissions(this,permissionArray,100);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                           // do something
                startActivityMain();
            }
            return;
        }
    }

    private void startActivityMain() {
        finish();
    }
}
