package co.ivanebernal.memegenerator;

import android.content.Context;

public class DependencyInjection {

    public static MemeGenerator provideMemeGenerator(Context context) {
        return new MemeGenerator(context);
    }

    public static MemeSaver provideMemeSaver(Context context) {
        return new MemeSaver(context);
    }
}
