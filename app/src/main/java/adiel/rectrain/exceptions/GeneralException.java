package adiel.rectrain.exceptions;

import android.util.Log;

/**
 * Created by recntrek7 on 25/12/16.
 */

public class GeneralException {

    public static void LogException(Exception e){

        if(e instanceof NullPointerException){
            Log.e("adiel","NullPointerException");
        }else  if(e instanceof ClassNotFoundException){
            Log.e("adiel","activity not exist or not declare in manifest");
        }else {
            Log.e("adiel","not excpected eception");
        }

    }
}
