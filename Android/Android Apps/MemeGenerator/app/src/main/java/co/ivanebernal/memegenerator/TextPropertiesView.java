package co.ivanebernal.memegenerator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.textfield.TextInputLayout;
import yuku.ambilwarna.AmbilWarnaDialog;
import yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener;

public class TextPropertiesView extends ConstraintLayout {

    @BindView(R.id.memeText)
    TextInputLayout memeTextInput;

    @BindView(R.id.textSizeValue)
    EditText textSizeValueEditText;

    @BindView(R.id.textColorContainer)
    LinearLayout textColorContainer;

    @BindView(R.id.textColorSample)
    CardView textColorSampleCard;

    private Integer color = 0xFFFFFF;

    private String text;

    private Integer size;

    private OnPropertyChangeListener onPropertyChangeListener;

    private OnAmbilWarnaListener colorPickerListener = new OnAmbilWarnaListener() {
        @Override
        public void onCancel(final AmbilWarnaDialog dialog) {

        }

        @Override
        public void onOk(final AmbilWarnaDialog dialog, final int newColor) {
            if (newColor == color) {
                return;
            }
            color = newColor;
            textColorSampleCard.setCardBackgroundColor(newColor);
            if (onPropertyChangeListener != null) {
                onPropertyChangeListener.onColorChanged(newColor);
            }
        }
    };

    public TextPropertiesView(Context context) {
        super(context);
        init();
    }

    public TextPropertiesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextPropertiesView(Context context, AttributeSet attrs, int defStyleAttrs) {
        super(context, attrs, defStyleAttrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_text_properties, this);
        ButterKnife.bind(this);

        setupViews();

    }

    private void setupViews() {
        //Set text change listeners
        EditText memeEditText = memeTextInput.getEditText();
        if (memeEditText != null) {
            memeEditText.addTextChangedListener(new SimpleTextWatcher() {
                @Override
                public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {
                    String newText = charSequence.toString();
                    if (newText.equals(text)) {
                        return;
                    }
                    TextPropertiesView.this.text = newText;
                    if (onPropertyChangeListener == null) {
                        return;
                    }
                    onPropertyChangeListener.onTextChanged(newText);
                }
            });
        }

        //Set text size change listener
        textSizeValueEditText.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(final CharSequence charSequence, final int i, final int i1, final int i2) {
                if (charSequence.length() == 0) {
                    return;
                }
                Integer newSize = Integer.valueOf(charSequence.toString());
                if (newSize.equals(size)) {
                    return;
                }
                TextPropertiesView.this.size = newSize;
                if (onPropertyChangeListener == null) {
                    return;
                }
                onPropertyChangeListener.onSizeChanged(newSize);
            }
        });

        //Set color click listener
        textColorContainer.setOnClickListener(view -> {
            AmbilWarnaDialog colorPickerDialog = new AmbilWarnaDialog(getContext(), color, colorPickerListener);
            colorPickerDialog.show();
        });
    }

    public void setTextColor(Integer color) {
        if (color.equals(this.color)) {
            return;
        }
        this.color = color;
        textColorSampleCard.setCardBackgroundColor(color);
    }

    public void setText(String text) {
        if (text.equals(this.text)) {
            return;
        }
        this.text = text;
        EditText memeText = memeTextInput.getEditText();
        if (memeText == null) {
            return;
        }
        memeText.setText(text);
    }

    public void setTextSize(Integer size) {
        if (size.equals(this.size)) {
            return;
        }
        this.size = size;
        textSizeValueEditText.setText(size.toString());
    }

    public void setOnPropertyChangeListener(OnPropertyChangeListener listener) {
        this.onPropertyChangeListener = listener;
    }

    interface OnPropertyChangeListener {

        void onTextChanged(String text);

        void onColorChanged(Integer color);

        void onSizeChanged(Integer size);
    }

}
