package com.example.android.emojify;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

class Emojifier {

    private static final String LOG_TAG = Emojifier.class.getSimpleName();
    private static final double EYE_OPEN_THRESHOLD = 0.4;
    private static final double SMILING_THRESHOLD = 0.25;
    private static final float EMOJI_SCALE_FACTOR = .8f;

    public static Bitmap detectFacesAndOverlayEmoji(Context context, Bitmap picture) {

        // Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(picture).build();

        // Detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        // Log the number of faces
        Log.d(LOG_TAG, "detectFaces: number of faces = " + faces.size());
        Bitmap emojiBitmap = picture;
        Resources resources = context.getResources();
        Emoji emoji;

        // If there are no faces detected, show a Toast message
        if (faces.size() == 0) {
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < faces.size(); ++i) {
                Face face = faces.valueAt(i);
                emoji = whichEmoji(face);
                switch (emoji) {
                    case SMILE:
                        int id = R.drawable.smile;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    case LEFT_WINK:
                        id = R.drawable.rightwink;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    case RIGHT_WINK:
                        id = R.drawable.leftwink;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    case CLOSED_EYE_SMILE:
                        id = R.drawable.closed_smile;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    case FROWN:
                        id = R.drawable.frown;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    case LEFT_WINK_FROWN:
                        id = R.drawable.rightwinkfrown;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    case RIGHT_WINK_FROWN:
                        id = R.drawable.leftwinkfrown;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    case CLOSED_EYE_FROWN:
                        id = R.drawable.closed_frown;
                        emojiBitmap = BitmapFactory.decodeResource(resources,id);
                        break;
                    default:
                        break;
                }
                picture = addBitmapToFace(picture,emojiBitmap,face);
            }

        }


        // Release the detector
        detector.release();
        return picture;
    }

    private static Emoji whichEmoji(Face face) {
        // Log all the probabilities
        boolean left_eye_open = false;
        boolean right_eye_open = false;
        boolean is_smiling = false;

        if (face.getIsLeftEyeOpenProbability() > EYE_OPEN_THRESHOLD) left_eye_open = true;
        if (face.getIsRightEyeOpenProbability() > EYE_OPEN_THRESHOLD) right_eye_open = true;
        if (face.getIsSmilingProbability() > SMILING_THRESHOLD) is_smiling = true;

        Emoji emoji;
        if (is_smiling) {
            if (left_eye_open && right_eye_open) emoji = Emoji.SMILE;
            else if (left_eye_open) emoji = Emoji.RIGHT_WINK;
            else if (right_eye_open) emoji = Emoji.LEFT_WINK;
            else emoji = Emoji.CLOSED_EYE_SMILE;
        } else {
            if (left_eye_open && right_eye_open) emoji = Emoji.FROWN;
            else if (left_eye_open) emoji = Emoji.RIGHT_WINK_FROWN;
            else if (right_eye_open) emoji = Emoji.LEFT_WINK_FROWN;
            else emoji = Emoji.CLOSED_EYE_FROWN;
        }

        Log.v(LOG_TAG, "emoji is " + emoji);
        return emoji;
    }

    private static Bitmap addBitmapToFace(Bitmap backgroundBitmap, Bitmap emojiBitmap, Face face) {

        // Initialize the results bitmap to be a mutable copy of the original image
        Bitmap resultBitmap = Bitmap.createBitmap(backgroundBitmap.getWidth(),
                backgroundBitmap.getHeight(), backgroundBitmap.getConfig());

        // Scale the emoji so it looks better on the face
        float scaleFactor = EMOJI_SCALE_FACTOR;

        // Determine the size of the emoji to match the width of the face and preserve aspect ratio
        int newEmojiWidth = (int) (face.getWidth() * scaleFactor);
        int newEmojiHeight = (int) (emojiBitmap.getHeight() *
                newEmojiWidth / emojiBitmap.getWidth() * scaleFactor);


        // Scale the emoji
        emojiBitmap = Bitmap.createScaledBitmap(emojiBitmap, newEmojiWidth, newEmojiHeight, false);

        // Determine the emoji position so it best lines up with the face
        float emojiPositionX =
                (face.getPosition().x + face.getWidth() / 2) - (emojiBitmap.getWidth() / (float)2);
        float emojiPositionY =
                (face.getPosition().y + face.getHeight() / 2) - emojiBitmap.getHeight() / (float)3;

        // Create the canvas and draw the bitmaps to it
        Canvas canvas = new Canvas(resultBitmap);
        canvas.drawBitmap(backgroundBitmap, 0, 0, null);
        canvas.drawBitmap(emojiBitmap, emojiPositionX, emojiPositionY, null);

        return resultBitmap;
    }


    private enum Emoji {
        SMILE,
        FROWN,
        LEFT_WINK,
        RIGHT_WINK,
        LEFT_WINK_FROWN,
        RIGHT_WINK_FROWN,
        CLOSED_EYE_SMILE,
        CLOSED_EYE_FROWN
    }
}