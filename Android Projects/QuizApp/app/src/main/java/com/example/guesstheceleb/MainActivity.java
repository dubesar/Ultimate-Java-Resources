package com.example.guesstheceleb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> nameOfCeleb = new ArrayList<String>();
    ArrayList<String> imagesUrlOfCelebs = new ArrayList<String>();
    int chosenCeleb=0;
    int locationOfCorrectAnswer;

    String answers[]= new String[4];

    int noOfQuestionAsked=1;

    Button button1 ;
    Button button2 ;
    Button button3 ;
    Button button4;

    Bitmap myBitmap;
    ImageView imageView;


    public void generateQuestion(){
        try {
            Random random = new Random();
            chosenCeleb = random.nextInt(imagesUrlOfCelebs.size());

            DownloadImage downloadImage = new DownloadImage();
            myBitmap = downloadImage.execute(imagesUrlOfCelebs.get(chosenCeleb)).get();
            imageView.setImageBitmap(myBitmap);

            locationOfCorrectAnswer = random.nextInt(4);
            int incorrectAnswerLocation = 0;
            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer)//get the correct answer
                {
                    answers[i] = nameOfCeleb.get(chosenCeleb);
                } else {
                    incorrectAnswerLocation = random.nextInt(imagesUrlOfCelebs.size());
                    while (incorrectAnswerLocation == chosenCeleb)
                        incorrectAnswerLocation = random.nextInt(imagesUrlOfCelebs.size());
                    answers[i] = nameOfCeleb.get(incorrectAnswerLocation);
                }

            }
            button1.setText(answers[0]);
            button2.setText(answers[1]);
            button3.setText(answers[2]);
            button4.setText(answers[3]);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }
    public void guess(View view)
    {
        if(Integer.valueOf(view.getTag().toString()) == locationOfCorrectAnswer){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        //create 5 more questions

        noOfQuestionAsked++;
        if (noOfQuestionAsked==5){
            Toast.makeText(this, "COMPLETE", Toast.LENGTH_SHORT).show();
            imageView.setVisibility(View.GONE);
            button1.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button4.setVisibility(View.GONE);


        }
        generateQuestion();
    }
    public class DownloadTask extends AsyncTask<String,Void,String> {
        //Made a change in ANdroid Manifest .Take note .

        @Override
        protected String doInBackground(String... strings) {
            String result = null;
            URL u;
            HttpURLConnection urlConnection = null;

            try {
                u =new URL(strings[0]);

                urlConnection = (HttpURLConnection)u.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isr = new InputStreamReader(in);


                int data = isr.read();

                while(data!=-1)
                {
                    char current = (char)data;
                    result+=current;
                    data=isr.read();
                }
                return result;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return "Failed";
        }
    }


    public class DownloadImage extends AsyncTask<String,Void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.connect();
                InputStream in =httpURLConnection.getInputStream();
                myBitmap = BitmapFactory.decodeStream(in);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();

            }
            return null;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        imageView = findViewById(R.id.imageView);


        try {
            DownloadTask task = new DownloadTask();
            String result = task.execute("http://www.posh24.se/kandisar").get();

            String[] splitResult = result.split("div class=\"sidebarContainer\"");
            String[] splitResult2 = splitResult[0].split("class=\"articleContainer contentBlock \"");
            Pattern p = Pattern.compile("src=\"(.*?)\"");
            Matcher matcher = p.matcher(splitResult2[1]);
            while (matcher.find()){
                imagesUrlOfCelebs.add(matcher.group(1));
            }

            p= Pattern.compile("alt=\"(.*?)\"");
            matcher = p.matcher(splitResult2[1]);
            while (matcher.find()){
                nameOfCeleb.add(matcher.group(1));
            }
            generateQuestion();


        }

        catch (Exception e)
        {
            System.out.println("FAIL");
        }
    }

}
