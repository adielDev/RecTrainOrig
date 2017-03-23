package adiel.rectrain.shapes;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import adiel.rectrain.R;

public class ShapeActivity extends AppCompatActivity {

    ImageView ivArrow1;
    Drawable arrow1Drawable;
    float angle=0;
    RotateDrawable rotated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        ivArrow1 = (ImageView) findViewById(R.id.ivArrow1);
       arrow1Drawable = getResources().getDrawable(R.drawable.ar1);
       setImage(arrow1Drawable ,angle);

//       rotated= (RotateDrawable) getResources().getDrawable(R.drawable.arrow3);
//        rotated.setFromDegrees(angle);
//        ivArrow1.setImageDrawable(rotated);

    }

    private void setImage(Drawable d, final float angle){

        Drawable drawable = rotateDrawable(d, angle);
        ivArrow1.setImageDrawable(drawable);
    }

    Drawable rotateDrawable(Drawable d, final float angle) {
        // Use LayerDrawable, because it's simpler than RotateDrawable.
        Drawable[] arD = {
                d
        };
        return new LayerDrawable(arD) {
            @Override
            public void draw(Canvas canvas) {
                canvas.save();
                float v = convertDpToPixel(50, getBaseContext());
                canvas.rotate(angle,v/2,v/2);
                super.draw(canvas);
                canvas.restore();
            }
        };
    }
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public void rotate(View view) {
        angle+=10;
        setImage(arrow1Drawable ,angle);
//        rotated.setFromDegrees(angle);
//        ivArrow1.setImageDrawable(rotated);
    }



    public void rotateCenter(View view) {
        Bitmap srcBitmap = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.arrow3
        );

        // Initialize a new Bitmap
        Bitmap bitmap = Bitmap.createBitmap(
                700, // Width
                500, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(bitmap);

        // Draw a solid color on the canvas as background
        canvas.drawColor(Color.YELLOW);

        // Initialize a new Paint instance to draw on canvas
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);

                /*
                    Matrix
                        The Matrix class holds a 3x3 matrix for transforming coordinates.
                */
                /*
                     Matrix()
                        Create an identity matrix
                */

        // Initialize a new Matrix instance
        Matrix matrix = new Matrix();

                /*
                    public void setRotate (float degrees, float px, float py)
                        Set the matrix to rotate by the specified number of degrees, with a pivot
                        point at (px, py). The pivot point is the coordinate that should remain
                        unchanged by the specified transformation.
                */

        // Set rotation on matrix
        matrix.setRotate(
                45, // degrees
                srcBitmap.getWidth() / 2, // px
                srcBitmap.getHeight() / 2 // py
        );

                /*
                      postTranslate(float dx, float dy)
                            Postconcats the matrix with the specified translation.
                */

        // Draw the bitmap at the center position of the canvas both vertically and horizontally
        matrix.postTranslate(
                canvas.getWidth() / 2 - srcBitmap.getWidth() / 2,
                canvas.getHeight() / 2 - srcBitmap.getHeight() / 2
        );

                /*
                    public void drawBitmap (Bitmap bitmap, Matrix matrix, Paint paint)
                        Draw the bitmap using the specified matrix.

                    Parameters
                        bitmap : The bitmap to draw
                        matrix : The matrix used to transform the bitmap when it is drawn
                        paint : May be null. The paint used to draw the bitmap
                */

        // Finally, draw the bitmap on canvas as a rotated bitmap
        canvas.drawBitmap(
                srcBitmap, // Bitmap
                matrix, // Matrix
                paint // Paint
        );

        // Display the newly created bitmap on app interface
        //mImageView.setImageBitmap(bitmap);
        ivArrow1.setImageBitmap(bitmap);
    }
}
