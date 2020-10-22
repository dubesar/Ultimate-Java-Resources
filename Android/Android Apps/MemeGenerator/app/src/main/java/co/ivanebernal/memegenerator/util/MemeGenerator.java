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

        Bitmap.Config bmConfig = bm.getConfig();

        if (bmConfig == null) {
            bmConfig = Config.ARGB_8888;
        }

        bm = bm.copy(bmConfig, true);

        Canvas canvas = new Canvas(bm);

        TextProperties topProperties = meme.getTopTextProperties();
        TextProperties bottomProperties = meme.getBottomTextProperties();

        drawText(canvas, topProperties, TOP);
        drawText(canvas, bottomProperties, BOTTOM);

        return bm;
    }

    private void drawText(final Canvas canvas, final TextProperties textProperties, @Position int position) {

        TextPaint textPaint = getTextPaint(textProperties);

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
        if (position == TOP) {
            yPosition = 100;
        } else {
            yPosition = canvas.getHeight() - textLayout.getHeight() - 100;
        }

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

        Typeface impact = ResourcesCompat.getFont(mContext, R.font.impact);

        textPaint.setTypeface(impact);

        return textPaint;
    }

    @IntDef({TOP, BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {

    }

}
