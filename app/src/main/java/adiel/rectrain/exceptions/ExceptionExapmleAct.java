package adiel.rectrain.exceptions;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import adiel.rectrain.MainActivity;
import adiel.rectrain.R;

public class ExceptionExapmleAct extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception_exapmle);
        Context application= getBaseContext();
        boolean isNull = (application==null);
        Log.d("adiel","is null:"+isNull);
        Thread goodThread = Thread.currentThread();
        Log.d("adiel","thread name before crash :"+goodThread.getName());
        Log.d("adiel","is thread alive:"+goodThread.isAlive());
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                Log.d("adiel","blaaa");
                Context applicationContext = getParent();
                boolean isNull = applicationContext==null;
                Log.d("adiel","is null:"+isNull);
            }
        });

    }

    public void causeNullExceprion(View view) {
       throw new NullPointerException();
    }
}
