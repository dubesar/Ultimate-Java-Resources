package com.orangeink.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.orangeink.agecalculator.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ActivityMainBinding binding;
    private boolean isDob;
    private Calendar dobCalendar, dateCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        Objects.requireNonNull(getSupportActionBar()).hide();
        setupDate(Calendar.getInstance(TimeZone.getDefault()), binding.tvDate);
        dateCalendar = Calendar.getInstance(TimeZone.getDefault());
        binding.tvDob.setOnClickListener(v -> {
            isDob = true;
            openDatePicker();
        });
        binding.tvDate.setOnClickListener(v -> {
            isDob = false;
            openDatePicker();
        });
        binding.btnClear.setOnClickListener(v -> clear());
        binding.btnCalculate.setOnClickListener(v -> {
            if (binding.btnCalculate.getText().toString().equalsIgnoreCase(getString(R.string.calculate)))
                calculateAge();
            else
                clear();
        });
    }

    private void clear() {
        if (binding.btnClear.getVisibility() == View.GONE)
            binding.btnClear.setVisibility(View.VISIBLE);
        dateCalendar = Calendar.getInstance(TimeZone.getDefault());
        binding.tvCalculate.setText(getString(R.string.calculate));
        binding.tvYourAge.setText(getString(R.string.your_today_s_age));
        binding.tvDob.setText(getString(R.string.dd_mm_yyyy));
        setupDate(Calendar.getInstance(TimeZone.getDefault()), binding.tvDate);
        binding.tvHeadingDob.setVisibility(View.VISIBLE);
        binding.tvDob.setVisibility(View.VISIBLE);
        binding.tvAge.setVisibility(View.GONE);
        binding.tvHeadingDate.setVisibility(View.VISIBLE);
        binding.tvDate.setVisibility(View.VISIBLE);
        binding.tvNextBirthday.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    private void calculateAge() {
        if (binding.tvDob.getText().toString().equalsIgnoreCase(getString(R.string.dd_mm_yyyy))) {
            Toast.makeText(this, "Enter your date of birth!", Toast.LENGTH_SHORT).show();
            return;
        }
        AgeCalculator ageCalculator = new AgeCalculator(dobCalendar, dateCalendar);
        String[] age = ageCalculator.getResult().split(":");
        binding.tvCalculate.setText(R.string.today_you_re);
        binding.tvYourAge.setText(age[2] + " years old");
        binding.btnClear.setVisibility(View.GONE);
        binding.btnCalculate.setText(R.string.calculate_again);
        binding.tvAge.setText("Your age (" + dobCalendar.get(Calendar.YEAR) + " - present )\nDAY OF BIRTH- " + ageCalculator.getDayOfBirth() + "\n" + age[2] + " years " + age[1] + " months " + age[0] + " days");
        binding.tvNextBirthday.setText("Your next birthday is in\n" + ageCalculator.getNextBirthday() + " days");
        binding.tvHeadingDob.setVisibility(View.GONE);
        binding.tvDob.setVisibility(View.GONE);
        binding.tvAge.setVisibility(View.VISIBLE);
        binding.tvHeadingDate.setVisibility(View.GONE);
        binding.tvDate.setVisibility(View.GONE);
        binding.tvNextBirthday.setVisibility(View.VISIBLE);
    }

    private void openDatePicker() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        DatePickerDialog dialog = new DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar myCalendar = Calendar.getInstance(TimeZone.getDefault());
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, month);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        if (isDob) {
            setupDate(myCalendar, binding.tvDob);
            dobCalendar = myCalendar;
        } else {
            setupDate(myCalendar, binding.tvDate);
            dateCalendar = myCalendar;
        }
    }

    private void setupDate(Calendar calendar, TextView tv) {
        String myFormat = "dd-MM-yyyy"; //Date Format
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        tv.setText(sdf.format(calendar.getTime()));
    }
}