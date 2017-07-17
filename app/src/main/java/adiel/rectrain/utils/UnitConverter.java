package adiel.rectrain.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;



/**
 * Created by dov on 28/05/15.
 */


import adiel.rectrain.R;
import adiel.rectrain.config.SPreferences;

public class UnitConverter {

    public final static String FILE_MAME_SETTINGS="filrNameSettings";

    static boolean isMetric;
    static String mi="mi", ft="ft", m="m", km="km";

    public static void init(Context context) {
        mi = context.getResources().getString(R.string.mi);
        ft = context.getResources().getString(R.string.ft);
        m = context.getResources().getString(R.string.m);
        km = context.getResources().getString(R.string.km);

//        SharedPreferences sp = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
//        if (sp.contains("unit"))
//            isMetric = sp.getBoolean("unit", true);

        isMetric = context.getSharedPreferences(SPreferences.FILENAME_SETTINGS, 0).getBoolean(SPreferences.PREF_UNITS_IS_METRIC, getIsLocalMetric(context));


    }

    /** this method isn't 100% accurate because some countries mix the metric and the imperial systems (England for example) */
    private static boolean getIsLocalMetric(Context ctx) {
        String countryCode = ctx.getResources().getConfiguration().locale.getCountry();
        if (countryCode.equals("US") || countryCode.equals("LR") || countryCode.equals("MM")) { // USA, Liberia, Burma (Myanmar)
            return false;
        } else {
            return true;
        }
    }

    static public String convert(Double num) {
        if (num < 1000) {
            if (isMetric)
                return String.format("%.2f " + m, num); // METER
            else
                return String.format("%.2f " + ft, UnitConvert.meterToFeet(num)); //FOOT
        } else {
            num /= 1000;
            if (isMetric)
                return String.format("%.2f " + km, num); // KILOMETER
            else
                return String.format("%.2f " + mi, UnitConvert.kmToMile(num)); // MILE
        }

    }

    static public String convertWithShortFloatingPoint(Double num) {
        if (num < 1000) {
            if (isMetric)
                return String.format("%d " + m, num.longValue()); // METER
            else
                return String.format("%d " + ft, ((Double) UnitConvert.meterToFeet(num)).longValue()); //FOOT
        } else {
            num /= 1000;
            if (isMetric)
                return String.format("%.1f " + km, num.floatValue()); // KILOMETER
            else
                return String.format("%.1f " + mi, UnitConvert.kmToMile(num.floatValue())); // MILE
        }

    }


    static public Pair<Long, String> convertToHashMap(Double num) {
        Pair<Long, String> map;
        if (num < 1000) {
            if (isMetric)
                map = new Pair<>(num.longValue(), m);
            else
                map = new Pair<>(((Double) UnitConvert.meterToFeet(num)).longValue(), ft);
        } else {
            num /= 1000;
            if (isMetric)
                map = new Pair<>(num.longValue(), km);
            else
                map = new Pair<>((long) UnitConvert.kmToMile(num.floatValue()), mi);
        }
        return map;
    }

    public static float dpToPx(float f) {
        return (float) (f * Resources.getSystem().getDisplayMetrics().density);
    }

    public static float pxToDp(float px) {
        return px / Resources.getSystem().getDisplayMetrics().density;
    }

    public static boolean isMetric() {
        return isMetric;
    }
}
