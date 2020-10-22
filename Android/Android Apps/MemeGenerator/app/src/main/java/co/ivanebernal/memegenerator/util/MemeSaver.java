package co.ivanebernal.memegenerator.util;

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

    /**
     * Save generated images in a folder named "meme_generator"
     * @param meme the meme to save to gallery
     */
    public void saveMemeToGallery(Bitmap meme) {
        if (meme == null) return;
        try {
            String folderName = "meme_generator";
            //Some methods are deprecated after version Q, so let's check the current version
            if (VERSION.SDK_INT >= VERSION_CODES.Q) {
                //Set picture properties
                final ContentValues values = getContentValues();
                values.put(Images.Media.RELATIVE_PATH, "Pictures/" + folderName);
                values.put(Images.Media.IS_PENDING, true);
                //Gets uri for external image directory
                Uri uri = mContext.getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
                if (uri != null) {
                    //Write file
                    storeBitmapToStream(meme, mContext.getContentResolver().openOutputStream(uri));
                    //Publish new media
                    values.put(Images.Media.IS_PENDING, false);
                    mContext.getContentResolver().update(uri, values, null, null);
                }
            } else {
                //Get a reference to the "meme_generator directory"
                File directory = new File(Environment.getExternalStorageDirectory().toString() + File.separator + folderName);
                //Create the "meme_generator" folder if it doesn't exists
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                //Create a unique name for the new file
                String fileName = System.currentTimeMillis() + ".jpg";
                File file = new File(directory, fileName);
                //Write file
                storeBitmapToStream(meme, new FileOutputStream(file));
                ContentValues values = getContentValues();
                values.put(Images.Media.DATA, file.getAbsolutePath());
                //Publish new media
                mContext.getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
            }
            //Let the user know the meme was saved
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
