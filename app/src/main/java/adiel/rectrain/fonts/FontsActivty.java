package adiel.rectrain.fonts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import adiel.rectrain.R;

public class FontsActivty extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tvTermOfService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fonts_activty);
        String plusSign = "\u002B";
        findViews();
        getTextSize();
        String start ="start ";
        String end=" end";

        SpannableStringBuilder text = new SpannableStringBuilder();
        text.append(start);
        text.append(color(Color.BLUE, "\u002B"));
        text.append(end);
        CharSequence textChar = text;

        tv1.setText(textChar);

        tvTermOfService = (TextView) findViewById(R.id.tvTermOfService);
        tvTermOfService .setText(Html.fromHtml(getString(R.string.i_agree_to_trem_of_service)));

        TextView tvVideoHint = (TextView) findViewById(R.id.tvVideoHint);
        Spanned spanned = Html.fromHtml(getString(R.string.video_hint));
        tvVideoHint.setText(spanned.toString());
        customFont();

    }

    private void customFont() {
        TextView customFont = (TextView) findViewById(R.id.customFont);
        TextView customFontHeb = (TextView) findViewById(R.id.customFontHeb);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"Alef-Bold.ttf");

        customFont.setTypeface(typeface);
        customFontHeb.setTypeface(typeface);
    }

    private void getTextSize() {
        float textSize = tv2.getTextSize();
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, textSize, r.getDisplayMetrics());

        float v = convertPixelsToDp(textSize, getApplicationContext());
        tv2.setText("text size is :"+String.valueOf(v));

    }
    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    private void findViews() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

    /**
     * Returns a CharSequence that concatenates the specified array of CharSequence
     * objects and then applies a list of zero or more tags to the entire range.
     *
     * @param content an array of character sequences to apply a style to
     * @param tags the styled span objects to apply to the content
     *        such as android.text.style.StyleSpan
     *
     */
    private static CharSequence apply(CharSequence[] content, Object... tags) {
        SpannableStringBuilder text = new SpannableStringBuilder();
        openTags(text, tags);
        for (CharSequence item : content) {
            text.append(item);
        }
        closeTags(text, tags);
        return text;
    }

    /**
     * Iterates over an array of tags and applies them to the beginning of the specified
     * Spannable object so that future text appended to the text will have the styling
     * applied to it. Do not call this method directly.
     */
    private static void openTags(Spannable text, Object[] tags) {
        for (Object tag : tags) {
            text.setSpan(tag, 0, 0, Spannable.SPAN_MARK_MARK);
        }
    }

    /**
     * "Closes" the specified tags on a Spannable by updating the spans to be
     * endpoint-exclusive so that future text appended to the end will not take
     * on the same styling. Do not call this method directly.
     */
    private static void closeTags(Spannable text, Object[] tags) {
        int len = text.length();
        for (Object tag : tags) {
            if (len > 0) {
                text.setSpan(tag, 0, len, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                text.removeSpan(tag);
            }
        }
    }
    /**
     * Returns a CharSequence that applies boldface to the concatenation
     * of the specified CharSequence objects.
     */
    public static CharSequence bold(CharSequence... content) {
        return apply(content, new StyleSpan(Typeface.BOLD));
    }

    /**
     * Returns a CharSequence that applies italics to the concatenation
     * of the specified CharSequence objects.
     */
    public static CharSequence italic(CharSequence... content) {
        return apply(content, new StyleSpan(Typeface.ITALIC));
    }

    /**
     * Returns a CharSequence that applies a foreground color to the
     * concatenation of the specified CharSequence objects.
     */
    public static CharSequence color(int color, CharSequence... content) {
        return apply(content, new ForegroundColorSpan(color));
    }
}
