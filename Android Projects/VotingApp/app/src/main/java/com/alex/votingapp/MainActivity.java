package com.alex.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    TextView tvJavaVotes, tvCppVotes, tvPythonVotes, tvJSVotes;
    RadioGroup rgQuestion;
    Button btnVote;
    SharedPreferences sharedPreferences;
    final String DATA_FILE = "data_file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        viewFlipper = findViewById(R.id.viewFlipper);
        rgQuestion = findViewById(R.id.rgQuestion);
        btnVote = findViewById(R.id.btnVote);

        tvJavaVotes = findViewById(R.id.tvJavaVotes);
        tvCppVotes = findViewById(R.id.tvCppVotes);
        tvPythonVotes = findViewById(R.id.tvPythonVotes);
        tvJSVotes = findViewById(R.id.tvJSVotes);
    }

    public void onClickVote(View view) {
        int ansPos  = 0;
        switch (rgQuestion.getCheckedRadioButtonId()){
            case R.id.rbJava: ansPos = 1; break;
            case R.id.rbCpp: ansPos = 2; break;
            case R.id.rbPython: ansPos = 3; break;
            case R.id.rbJs: ansPos = 4; break;
        }
        //if user didn't choose any language
        if (ansPos == 0) {
            Toast.makeText(
                    MainActivity.this,
                    "Vote pls",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        // save vote in DB
        voteFor(ansPos);
        // refresh data in TextView
        refreshData();

        viewFlipper.showNext();
        btnVote.setEnabled(false);
    }

    void voteFor(int position) {
        SharedPreferences.Editor ed = sharedPreferences.edit();
        //get current votes
        int votes = sharedPreferences.getInt(position+"", 0);
        //apply votes+1
        ed.putInt(position+"", votes+1);
        ed.apply();
    }

    void refreshData(){
        int vote = sharedPreferences.getInt("1", 0);
        tvJavaVotes.setText(getString(R.string.java)+": "+vote);

        vote = sharedPreferences.getInt("2", 0);
        tvCppVotes.setText(getString(R.string.c_c) +": "+vote);

        vote = sharedPreferences.getInt("3", 0);
        tvPythonVotes.setText(getString(R.string.python) +": "+vote);

        vote = sharedPreferences.getInt("4", 0);
        tvJSVotes.setText(getString(R.string.javascript) +": "+vote);
    }

    @Override
    public void onBackPressed() {
        if (btnVote.isEnabled()) return;

        btnVote.setEnabled(true);
        viewFlipper.showPrevious();
    }
}
