package adiel.rectrain.config;

import android.os.Environment;

/**
 * Created by Yonatan Reiss on 03/01/2016.
 */
public class UiConfig {
    public static final int AREA_NATURE = 40001;
    public static final int AREA_URBAN = 40002;

    public static final int SEGMENT_WALK = 10001;
    public static final int SEGMENT_CAR = 10004;
    public static final float PARAM_LOAD_MORE_AT_SCROLL_AMOUNT = 0.75f;

    public static final int PROFILE_PIC_HEIGHT = 1000;
    public static final int PROFILE_PIC_WIDTH = 1000;

    public static final double MAP_DEFAULT_LATITUDE = 32.953368;
    public static final double MAP_DEFAULT_LONGITUDE = -85.605469;

    public static final String FONT_OS_BOLD = "OpenSans-Bold.ttf";
    public static final String FONT_OS_SEMIBOLD = "OpenSans-Semibold.ttf";
    public static final String FONT_OS_REGULAR = "OpenSans-Regular.ttf";
    public static final String FONT_OS_LIGHT = "OpenSans-Light.ttf";

    public static final int ADD_PIC_HEIGHT = 1920;
    public static final int ADD_PIC_WIDTH = 1080;

    public static final String PATH_DIRECTORY_MAIN = Environment.getExternalStorageDirectory()+"/"+"WishTrip";


    public enum MainFragments {
        EXPLORE, WISHLIST, PROFILE, CHAT, RECORD
    }

}
