package co.ivanebernal.memegenerator.di;

import android.content.Context;
import co.ivanebernal.memegenerator.util.MemeGenerator;
import co.ivanebernal.memegenerator.util.MemeSaver;

public class DependencyInjection {

    public static MemeGenerator provideMemeGenerator(Context context) {
        return new MemeGenerator(context);
    }

    public static MemeSaver provideMemeSaver(Context context) {
        return new MemeSaver(context);
    }
}
