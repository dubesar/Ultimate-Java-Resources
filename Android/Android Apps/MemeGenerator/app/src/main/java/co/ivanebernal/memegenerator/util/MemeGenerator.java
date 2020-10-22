package co.ivanebernal.memegenerator.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import androidx.annotation.IntDef;
import androidx.core.content.res.ResourcesCompat;
import co.ivanebernal.memegenerator.R;
import co.ivanebernal.memegenerator.model.Meme;
import co.ivanebernal.memegenerator.model.TextProperties;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MemeGenerator {

    private Context mContext;

    private static final int TOP = 0;

    private static final int BOTTOM = 1;

    public MemeGenerator(Context context) {
        this.mContext = context;
    }

    public Bitmap generateMeme(Meme meme) {
        Bitmap bm = meme.getBaseImage();
        //Get base image config
        Bitmap.Config bmConfig = bm.getConfig();
        //Set ARGB_888 as default config
        if (bmConfig == null) {
            bmConfig = Config.ARGB_8888;
        }
        //Copy bitmap and make it mutable so we can draw text
        bm = bm.copy(bmConfig, true);
        //Create canvas in which we will join images and text
        Canvas canvas = new Canvas(bm);
        //Extract properties for each text
        TextProperties topProperties = meme.getTopTextProperties();
        TextProperties bottomProperties = meme.getBottomTextProperties();
        //Draw texts
        drawText(canvas, topProperties, TOP);
        drawText(canvas, bottomProperties, BOTTOM);
        //Return new bitmap
        return bm;
    }

    private void drawText(final Canvas canvas, final TextProperties textProperties, @Position int position) {
        //Get text paint
        TextPaint textPaint = getTextPaint(textProperties);
        //Build Static layout, this will allow text to be the same width as the image no matter how long it is
        String text = textProperties.getText();
        int textWidth = (int) (canvas.getWidth() * 0.9f);
        int padding = (canvas.getWidth() - textWidth) / 2;
        StaticLayout textLayout = StaticLayout.Builder
                .obtain(text, 0, text.length(), textPaint, textWidth)
                .setAlignment(Alignment.ALIGN_CENTER)
                .setLineSpacing(0.0f, 1.0f)
                .setIncludePad(false)
                .setMaxLines(2)
                .setEllipsize(TruncateAt.END)
                .build();

        int yPosition;
        //Decide if drawing text on top or bottom
        if (position == TOP) {
            yPosition = 100;
        } else {
            yPosition = canvas.getHeight() - textLayout.getHeight() - 100;
        }
        //Draw text in canvas
        canvas.save();
        canvas.translate(padding, yPosition);
        textLayout.draw(canvas);
        canvas.restore();
    }

    private TextPaint getTextPaint(final TextProperties topProperties) {
        float fontScale = mContext.getResources().getDisplayMetrics().density;
        //Initialize paint
        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        //Set text color
        textPaint.setColor(topProperties.getColor());
        //Set text size
        textPaint.setTextSize((int) (topProperties.getSize() * fontScale));
        //Change font to Impact (the most common meme font)
        Typeface impact = ResourcesCompat.getFont(mContext, R.font.impact);
        textPaint.setTypeface(impact);
        //Return text paint
        return textPaint;
    }

    @IntDef({TOP, BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position { }

}
