package co.ivanebernal.memegenerator;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MemeSaver {

    private Context mContext;

    public MemeSaver(final Context context) {
        mContext = context;
    }

    public void saveMemeToGallery(Bitmap meme) {
        if (meme == null) return;

        try {
            String folderName = "meme_generator";
            if (VERSION.SDK_INT >= VERSION_CODES.Q) {
                final ContentValues values = getContentValues();
                values.put(Images.Media.RELATIVE_PATH, "Pictures/" + folderName);
                values.put(Images.Media.IS_PENDING, true);

                Uri uri = mContext.getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
                if (uri != null) {
                    storeBitmapToStream(meme, mContext.getContentResolver().openOutputStream(uri));
                    values.put(Images.Media.IS_PENDING, false);
                    mContext.getContentResolver().update(uri, values, null, null);
                }
            } else {
                File directory = new File(Environment.getExternalStorageDirectory().toString() + File.separator + folderName);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                String fileName = System.currentTimeMillis() + ".jpg";
                File file = new File(directory, fileName);
                storeBitmapToStream(meme, new FileOutputStream(file));
                ContentValues values = getContentValues();
                values.put(Images.Media.DATA, file.getAbsolutePath());
                mContext.getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
            }
            Toast.makeText(mContext, "Meme saved to gallery!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(Media.DATE_TAKEN, System.currentTimeMillis());
        values.put(Media.DATE_ADDED, System.currentTimeMillis());
        values.put(Media.MIME_TYPE, "image/jpeg");
        return values;
    }

    private void storeBitmapToStream(Bitmap bitmap, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                bitmap.compress(CompressFormat.JPEG, 100, outputStream);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
