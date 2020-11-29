package co.ivanebernal.memegenerator.util;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * A class that simplifies TextWatcher by providing default implementations of beforeTextChanged and afterTextChanged
 */

public abstract class SimpleTextWatcher implements TextWatcher {

    @Override
    public void beforeTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {

    }

    @Override
    public void afterTextChanged(final Editable editable) {

    }
}
