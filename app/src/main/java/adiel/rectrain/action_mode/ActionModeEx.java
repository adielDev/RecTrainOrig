package adiel.rectrain.action_mode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import adiel.rectrain.R;

public class ActionModeEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode_ex);
        Toolbar toolbar = (Toolbar) findViewById(R.id.addpoint_toolbar);
        setSupportActionBar(toolbar);
    }

    public void startActionMode(View view) {
        MyCallBAckSupport myCallBAckSupport = new MyCallBAckSupport();
        startSupportActionMode(new MyCallBAckSupport());
    }

    private class MyCallBack implements ActionMode.Callback{

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Toast.makeText(ActionModeEx.this, "onCreateActionMode", Toast.LENGTH_SHORT).show();
            mode.getMenuInflater().inflate(R.menu.contextual_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Toast.makeText(ActionModeEx.this, "onPrepareActionMode", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Toast.makeText(ActionModeEx.this, "onActionItemClicked", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            Toast.makeText(ActionModeEx.this, "onDestroyActionMode", Toast.LENGTH_SHORT).show();

        }
    }

    private class MyCallBAckSupport implements android.support.v7.view.ActionMode.Callback{

        @Override
        public boolean onCreateActionMode(android.support.v7.view.ActionMode mode, Menu menu) {
            Toast.makeText(ActionModeEx.this, "onCreateActionMode", Toast.LENGTH_SHORT).show();
            mode.getMenuInflater().inflate(R.menu.contextual_menu_support, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(android.support.v7.view.ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(android.support.v7.view.ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(android.support.v7.view.ActionMode mode) {

        }
    }
}
