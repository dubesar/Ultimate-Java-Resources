package com.haseebahmed.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DistanceConverter extends AppCompatActivity   {
    Button convert;
    EditText answerText,quantityText;
    String from;
    String to;
    String stringAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_converter);


        convert=(Button) findViewById(R.id.btnConvert);

        answerText= (EditText) findViewById(R.id.answerText);
        quantityText= (EditText) findViewById(R.id.quantity);

        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.fromdistance, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.todistance, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner1.setOnItemSelectedListener(new FromSpinnerClass());
        spinner2.setOnItemSelectedListener(new ToSpinnerClass());
    }



    public void convertValues(View v){




      if( quantityText.getText().toString()==null || quantityText.getText().toString().equals("") )
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


          else if(from.equals("Miles") && to.equals("Kilometer"))
          {

              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*1.60934;
              answerText.setText(myAnswer+"");
          }

          else if(from.equals("Miles") && to.equals("Meter"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*1609.34;
              answerText.setText(myAnswer+"");

          }

          else if(from.equals("Miles") && to.equals("Centimeter"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*160934;
              answerText.setText(myAnswer+"");

          }

          else if(from.equals("Kilometer") && to.equals("Miles"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*0.621371;
              answerText.setText(myAnswer+"");
          }
          else if(from.equals("Kilometer") && to.equals("Meter"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*1000;
              answerText.setText(myAnswer+"");
          }

          else if(from.equals("Kilometer") && to.equals("Centimeter"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*100000;
              answerText.setText(myAnswer+"");
          }

          else if(from.equals("Meter") && to.equals("Miles"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*0.000621371;
              answerText.setText(myAnswer+"");
          }

          else if(from.equals("Meter") && to.equals("Kilometer"))
          {

              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*0.001;
              answerText.setText(myAnswer+"");
          }

          else if(from.equals("Meter") && to.equals("Centimeter"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity*100;
              answerText.setText(myAnswer+"");

          }

          else if(from.equals("Centimeter") && to.equals("Miles"))
          {

              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity/160934;
              answerText.setText(myAnswer+"");


          }

          else if(from.equals("Centimeter") && to.equals("Kilometer"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity/100000;
              answerText.setText(myAnswer+"");

          }

          else if(from.equals("Centimeter") && to.equals("Meter"))
          {
              double quantity=  Double.parseDouble(stringAnswer);
              double myAnswer= quantity/100;
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


