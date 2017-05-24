package adiel.rectrain.config;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by recntrek2 on 2/17/15.
 */
public class SearchConfig
{
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            KEY_AREA,
            KEY_TOURING_AREA,
            KEY_COUNTRY,
            KEY_DIFFICULTY,
            KEY_DURATION,
            KEY_LENGTH,
            KEY_NAME,
            KEY_SEASON,
            KEY_TAGS,
            KEY_TREK_ID,
            KEY_SITE_ID,
            KEY_TYPE,
            KEY_USER_ID,
    })
    public @interface KEYS {}
    /**
     * trek_id or list of trek ids
     * need to change the {@link SearchOption#setSize(int)} to the size of the list
     * to get all the trek in one request
     */
    public static final String KEY_TREK_ID = "trek_id";

    /**
     * site_id or list of site ids
     * need to change the {@link SearchOption#setSize(int)} to the size of the list
     * to get all the trek in one request
     */
    public static final String KEY_SITE_ID = "site_id";

    /**
     * user_id or list of user ids
     */
    public static final String KEY_USER_ID = "user_id";

    /**
     * String that contained in the trek's name
     */
    public static final String KEY_NAME = "name";

    /**
     * get treks that are in a specific touring area
     * the area values get from {@link model.AreaHeader#area} as a string
     */
    public static final String KEY_TOURING_AREA = "touring_area";

    /**
     * get treks that are in a specific touring area country (string)
     *
     */
    public static final String KEY_COUNTRY = "country";


    /**
     * should be one or more of the following options:
     * {@link #VAL_URBAN}, {@link #VAL_NATURE}
     */
    public static final String KEY_AREA = "area";

    public static final String VAL_URBAN = "Urban";

    public static final String VAL_NATURE = "Nature";

    /**
     *should be one or more of the following values:
     * {@link #VAL_CAR}, {@link #VAL_BICYCLE} and {@link #VAL_WALKING}
     */
    public static final String KEY_TYPE = "type";

    public static final String VAL_WALKING = "Walking";

    public static final String VAL_CAR = "Car";

    public static final String VAL_BICYCLE = "Bicycle";


    /**
     * should be two values to get all the trek with difficulty between them
     * {@link SearchOption#addFilter(String key, Object start, Object end)}
     */
    public static final String KEY_DIFFICULTY = "difficulty";
    /**
     * should be two values to get all the trek with duration between them
     * {@link SearchOption#addFilter(String key, Object start, Object end)}
     */
    public static final String KEY_DURATION = "duration";

    /**
     * should be two values to get all the trek with length between them
     * {@link SearchOption#addFilter(String key, Object start, Object end)}
     */
    public static final String KEY_LENGTH = "length";

    /**
     * should be one or more of the following options:
     * {@link #VAL_FALL}, {@link #VAL_WINTER}, {@link #VAL_SPRING} and {@link #VAL_SUMMER}
     */
    public static final String KEY_SEASON = "season";

    public static final String VAL_FALL = "fall";

    public static final String VAL_WINTER = "winter";

    public static final String VAL_SPRING = "spring";

    public static final String VAL_SUMMER = "summer";

    /**
     * should be one or more of the following options:
     * {@link #TAG_WATERFALL}
     * {@link #TAG_SPRING}
     * {@link #TAG_RAPPELLING}
     * {@link #TAG_PICNIC}
     * {@link #TAG_DRINKING_WATER}
     * {@link #TAG_PLAYGROUND}
     * {@link #TAG_BBQ}
     * {@link #TAG_TOILET}
     * {@link #TAG_WASTE_DISPOSAL}
     * {@link #TAG_HOLY_SITE}
     * {@link #TAG_ARCHAEOLOGICAL}
     * {@link #TAG_TRADITION}
     * {@link #TAG_CAMP}
     * {@link #TAG_VIEW_POINT}
     * {@link #TAG_BIRD_OVERLOOK}
     * {@link #TAG_PARKING}
     * {@link #TAG_INFO}
     * {@link #TAG_MEDICAL}
     * {@link #TAG_BUS_END}
     * {@link #TAG_BUS_START}
     * {@link #TAG_DISABLE_ACCESS
     * {@link #TAG_ANIMALS_ACCESS}
     */
    public static final String KEY_TAGS = "tags";

    public static final String TAG_WATERFALL = "Waterfall";
    public static final String TAG_SPRING = "Spring";
    public static final String TAG_RAPPELLING = "Rappelling";
    public static final String TAG_PICNIC = "Picnic Site";
    public static final String TAG_DRINKING_WATER = "Drinking Water";
    public static final String TAG_PLAYGROUND = "Playground";
    public static final String TAG_BBQ = "BBQ";
    public static final String TAG_TOILET = "Toilet";
    public static final String TAG_WASTE_DISPOSAL = "Waste Disposal";
    public static final String TAG_HOLY_SITE = "Holy Site";
    public static final String TAG_ARCHAEOLOGICAL = "Archaeological Site";
    public static final String TAG_TRADITION = "Tradition Site";
    public static final String TAG_CAMP = "Camp Site";
    public static final String TAG_VIEW_POINT = "Viewpoint";
    public static final String TAG_BIRD_OVERLOOK = "Bird Overlook";
    public static final String TAG_PARKING = "Parking";
    public static final String TAG_INFO = "Information";
    public static final String TAG_MEDICAL = "Medical";
    public static final String TAG_BUS_END = "Bus end";
    public static final String TAG_BUS_START = "Bus start";
    public static final String TAG_DISABLE_ACCESS = "Disable access";
    public static final String TAG_ANIMALS_ACCESS = "Animals access";

}
