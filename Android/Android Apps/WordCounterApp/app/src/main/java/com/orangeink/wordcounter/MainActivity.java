package com.orangeink.wordcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.orangeink.wordcounter.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        binding.btnCount.setOnClickListener(v -> countWords());
        binding.btnClear.setOnClickListener(v -> {
            binding.tvWordCount.setText(getString(R.string._0));
            binding.editWords.setText("");
        });
    }

    private void countWords() {
        if (binding.editWords.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter the words!", Toast.LENGTH_SHORT).show();
            return;
        }
        hideKeyboardFrom(this, binding.getRoot());
        String[] words = binding.editWords.getText().toString().split("\\W+"); //W+ means not an alphanumeric character.
        binding.tvWordCount.setText(String.valueOf(words.length));
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}