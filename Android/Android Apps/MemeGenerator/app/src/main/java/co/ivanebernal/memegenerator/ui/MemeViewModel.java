package co.ivanebernal.memegenerator.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import co.ivanebernal.memegenerator.di.DependencyInjection;
import co.ivanebernal.memegenerator.model.Meme;
import co.ivanebernal.memegenerator.util.MemeGenerator;
import co.ivanebernal.memegenerator.util.MemeSaver;

public class MemeViewModel extends ViewModel {

    private MemeGenerator mGenerator;

    private MemeSaver mSaver;

    protected MemeViewModel(MemeGenerator generator, MemeSaver saver) {
        mGenerator = generator;
        mSaver = saver;
        subscribeGeneratedMeme();
        initValues();
    }

    private void subscribeGeneratedMeme() {
        generatedMeme.addSource(image, (Observer<? super Bitmap>) o -> generatedMeme.postValue(getGenerateMeme()));
        generatedMeme.addSource(topText, (Observer<? super String>) o -> generatedMeme.postValue(getGenerateMeme()));
        generatedMeme
                .addSource(topTextSize, (Observer<? super Integer>) o -> generatedMeme.postValue(getGenerateMeme()));
        generatedMeme.addSource(topTextColor,
                (Observer<? super Integer>) o -> generatedMeme.postValue(getGenerateMeme()));
        generatedMeme
                .addSource(bottomText, (Observer<? super String>) o -> generatedMeme.postValue(getGenerateMeme()));
        generatedMeme.addSource(bottomTextSize,
                (Observer<? super Integer>) o -> generatedMeme.postValue(getGenerateMeme()));
        generatedMeme.addSource(bottomTextColor,
                (Observer<? super Integer>) o -> generatedMeme.postValue(getGenerateMeme()));
    }

    private void initValues() {
        topText.postValue("Top text");
        topTextSize.postValue(140);
        topTextColor.postValue(Color.WHITE);

        bottomText.postValue("Bottom text");
        bottomTextSize.postValue(140);
        bottomTextColor.postValue(Color.WHITE);
    }

    private MutableLiveData<Bitmap> image = new MutableLiveData<>();

    public void setImage(Bitmap imageUri) {
        image.postValue(imageUri);
        initValues();
    }

    private MutableLiveData<String> topText = new MutableLiveData<>();

    public LiveData<String> getTopTextObservable() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText.postValue(topText);
    }

    private MutableLiveData<Integer> topTextSize = new MutableLiveData<>();

    public LiveData<Integer> getTopTextSizeObservable() {
        return topTextSize;
    }

    public void setTopTextSize(Integer topTextSize) {
        this.topTextSize.postValue(topTextSize);
    }

    private MutableLiveData<Integer> topTextColor = new MutableLiveData<>();

    public LiveData<Integer> getTopTextColorObservable() {
        return topTextColor;
    }

    public void setTopTextColor(Integer topTextColor) {
        this.topTextColor.postValue(topTextColor);
    }

    private MutableLiveData<String> bottomText = new MutableLiveData<>();

    public LiveData<String> getBottomTextObservable() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText.postValue(bottomText);
    }

    private MutableLiveData<Integer> bottomTextSize = new MutableLiveData<>();

    public LiveData<Integer> getBottomTextSizeObservable() {
        return bottomTextSize;
    }

    public void setBottomTextSize(Integer bottomTextSize) {
        this.bottomTextSize.postValue(bottomTextSize);
    }


    private MutableLiveData<Integer> bottomTextColor = new MutableLiveData<>();

    public LiveData<Integer> getBottomTextColorObservable() {
        return bottomTextColor;
    }

    public void setBottomTextColor(Integer bottomTextColor) {
        this.bottomTextColor.postValue(bottomTextColor);
    }

    private MediatorLiveData<Bitmap> generatedMeme = new MediatorLiveData<>();

    public LiveData<Bitmap> getGeneratedMemeObservable() {
        return generatedMeme;
    }

    private Bitmap getGenerateMeme() {
        if (image.getValue() == null) {
            return image.getValue();
        }
        Meme info = new Meme(image.getValue(), topText.getValue(), topTextSize.getValue(),
                topTextColor.getValue(), bottomText.getValue(), bottomTextSize.getValue(),
                bottomTextColor.getValue());
        return mGenerator.generateMeme(info);
    }

    public void onSaveMemeClicked() {
        mSaver.saveMemeToGallery(generatedMeme.getValue());
    }

    public static class Factory implements ViewModelProvider.Factory {

        private Context mContext;

        public Factory(Context context) {
            this.mContext = context;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
            if (modelClass.isAssignableFrom(MemeViewModel.class)) {
                return (T) new MemeViewModel(
                        DependencyInjection.provideMemeGenerator(mContext),
                        DependencyInjection.provideMemeSaver(mContext)
                );
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

}
