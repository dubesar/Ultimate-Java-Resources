package com.haseebahmed.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class WeightConverter extends AppCompatActivity {

    Button convert;
    EditText answerText,quantityText;
    String from;
    String to;
    String stringAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);

        convert=(Button) findViewById(R.id.btnConvert);

        answerText= (EditText) findViewById(R.id.answerText);
        quantityText= (EditText) findViewById(R.id.quantity);

        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.fromweight, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.toweight, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner1.setOnItemSelectedListener(new WeightConverter.FromSpinnerClass());
        spinner2.setOnItemSelectedListener(new WeightConverter.ToSpinnerClass());

    }

    public void convertValues(View v) {


        if(quantityText.getText().toString()==null || quantityText.getText().toString().equals(""))
        {
            Toast.makeText(this,"Empty,Please enter quantity",Toast.LENGTH_LONG).show();
        }

        else
        {
            stringAnswer= quantityText.getText().toString();
            if(from.equals(to))
            {
                Toast.makeText(this,"Can not convert to same unit",Toast.LENGTH_LONG).show();
            }

            else if(from.equals("Kilogram") && to.equals("Pound"))
            {

                double quantity=  Double.parseDouble(stringAnswer);
                double myAnswer= quantity*2.204;
                answerText.setText(myAnswer+"");

            }

            else if(from.equals("Kilogram") && to.equals("Gram"))
            {

                double quantity=  Double.parseDouble(stringAnswer);
                double myAnswer= quantity*1000;
                answerText.setText(myAnswer+"");


            }

            else if(from.equals("Pound") && to.equals("Kilogram"))
            {

                double quantity=  Double.parseDouble(stringAnswer);
                double myAnswer= quantity*0.453592;
                answerText.setText(myAnswer+"");

            }

            else if(from.equals("Pound") && to.equals("Gram"))
            {


                double quantity=  Double.parseDouble(stringAnswer);
                double myAnswer= quantity*453.592;
                answerText.setText(myAnswer+"");

            }

            else if(from.equals("Gram") && to.equals("Kilogram"))
            {

                double quantity=  Double.parseDouble(stringAnswer);
                double myAnswer= quantity*0.001;
                answerText.setText(myAnswer+"");


            }

            else if(from.equals("Gram") && to.equals("Pound"))
            {

                double quantity=  Double.parseDouble(stringAnswer);
                double myAnswer= quantity*0.00220462;
                answerText.setText(myAnswer+"");

            }
        }



        quantityText.setText("");



    }


    class FromSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            from = parent.getItemAtPosition(position).toString();



        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    class ToSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            to = parent.getItemAtPosition(position).toString();


        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }






}