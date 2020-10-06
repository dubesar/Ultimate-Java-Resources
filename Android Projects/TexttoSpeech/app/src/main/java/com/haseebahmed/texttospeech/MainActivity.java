package com.haseebahmed.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSpeak,btnIncPitch,btnDecPitch,btnIncSpeed,btnDecSpeed;
    EditText editText;
    float pitch=1.0f;
    float speed=1.0f;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(getApplicationContext(), "This language is not supported!",
                                Toast.LENGTH_SHORT);
                    } else {
                        btnSpeak.setEnabled(true);


                        speak();
                    }
                }
            }
        });


        btnSpeak = (Button)findViewById(R.id.btnSpeak);
        btnIncPitch=(Button)findViewById(R.id.btnIncreasePitch);
        btnDecPitch=(Button)findViewById(R.id.btnDecreasePitch);
        btnIncSpeed=(Button)findViewById(R.id.btnIncreaseSpeed);
        btnDecSpeed=(Button)findViewById(R.id.btnDecreaseSpeed);
        editText = (EditText)findViewById(R.id.editText);

        btnIncPitch.setOnClickListener(this);
        btnDecPitch.setOnClickListener(this);
        btnIncSpeed.setOnClickListener(this);
        btnDecSpeed.setOnClickListener(this);


        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void speak() {
        String text = editText.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

        int source=view.getId();
        if(source==R.id.btnIncreasePitch)
        {
            pitch+=0.3;
            textToSpeech.setPitch(pitch);
        }
        else if(source==R.id.btnDecreasePitch)
        {
            pitch-=0.3;
            textToSpeech.setPitch(pitch);
        }

        else if(source==R.id.btnIncreaseSpeed)
        {
            speed+=0.3;
            textToSpeech.setSpeechRate(speed);
        }

        else if(source==R.id.btnDecreaseSpeed)
        {
            speed-=0.3;
            textToSpeech.setSpeechRate(speed);
        }
    }
}
