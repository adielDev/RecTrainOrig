package adiel.rectrain.myosm;


/**
 * Created by recntrek7 on 23/05/17.
 */


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.osmdroid.ResourceProxy;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.views.util.constants.MapViewConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyDefaultResourceProxyImpl implements ResourceProxy, MapViewConstants {
    private static final Logger logger = LoggerFactory.getLogger(MyDefaultResourceProxyImpl.class);
    private Resources mResources;
    private DisplayMetrics mDisplayMetrics;
    static Map<bitmap, WeakReference<Bitmap>> resourcesMap = Collections.synchronizedMap(new HashMap());

    public MyDefaultResourceProxyImpl(Context pContext) {
        if(pContext != null) {
            this.mResources = pContext.getResources();
            this.mDisplayMetrics = this.mResources.getDisplayMetrics();
        }

    }

    public String getString(string pResId) {
        switch(null.$SwitchMap$org$osmdroid$ResourceProxy$string[pResId.ordinal()]) {
            case 1:
                return "Mapnik";
            case 2:
                return "Cycle Map";
            case 3:
                return "Public transport";
            case 4:
                return "CloudMade (Standard tiles)";
            case 5:
                return "CloudMade (small tiles)";
            case 6:
                return "Mapquest";
            case 7:
                return "Mapquest Aerial";
            case 8:
                return "Bing";
            case 9:
                return "MapBox";
            case 10:
                return "OpenFietsKaart overlay";
            case 11:
                return "Netherlands base overlay";
            case 12:
                return "Netherlands roads overlay";
            case 13:
                return "Unknown";
            case 14:
                return "%s m";
            case 15:
                return "%s km";
            case 16:
                return "%s mi";
            case 17:
                return "%s nm";
            case 18:
                return "%s ft";
            case 19:
                return "Online mode";
            case 20:
                return "Offline mode";
            case 21:
                return "My location";
            case 22:
                return "Compass";
            case 23:
                return "Map mode";
            default:
                throw new IllegalArgumentException();
        }
    }

    public String getString(string pResId, Object... formatArgs) {
        return String.format(this.getString(pResId), formatArgs);
    }

    public Bitmap getBitmap(bitmap pResId) {
        WeakReference bitmapWeakReference = (WeakReference)resourcesMap.get(pResId);
        if(bitmapWeakReference != null) {
            if(bitmapWeakReference.get() != null) {
                return (Bitmap)bitmapWeakReference.get();
            }

            resourcesMap.remove(pResId);
        }

        InputStream is = null;

        Bitmap var7;
        try {
            String e = "/org/osmdroid/" + pResId.name() + ".png";
            is = ResourceProxy.class.getResourceAsStream(e);
            if(is == null) {
                throw new IllegalArgumentException("Resource not found: " + e);
            }

            Options options = null;
            if(this.mDisplayMetrics != null) {
                options = this.getBitmapOptions();
            }

            Bitmap bitmap = BitmapFactory.decodeStream(is, (Rect)null, options);
            resourcesMap.put(pResId, new WeakReference(bitmap));
            var7 = bitmap;
        } catch (OutOfMemoryError var16) {
            logger.error("OutOfMemoryError getting bitmap resource: " + pResId);
            System.gc();
            throw var16;
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException var15) {
                    ;
                }
            }

        }

        return var7;
    }

    private Options getBitmapOptions() {
        try {
            Field density = DisplayMetrics.class.getDeclaredField("DENSITY_DEFAULT");
            Field inDensity = Options.class.getDeclaredField("inDensity");
            Field inTargetDensity = Options.class.getDeclaredField("inTargetDensity");
            Field targetDensity = DisplayMetrics.class.getDeclaredField("densityDpi");
            Options options = new Options();
            inDensity.setInt(options, density.getInt((Object)null));
            inTargetDensity.setInt(options, targetDensity.getInt(this.mDisplayMetrics));
            return options;
        } catch (IllegalAccessException var6) {
            ;
        } catch (NoSuchFieldException var7) {
            ;
        }

        return null;
    }

    public Drawable getDrawable(bitmap pResId) {
        return this.mResources != null
                ?new BitmapDrawable(this.mResources, this.getBitmap(pResId))
                :new BitmapDrawable(this.getBitmap(pResId));
    }

    public float getDisplayMetricsDensity() {
        return this.mDisplayMetrics.density;
    }
}
