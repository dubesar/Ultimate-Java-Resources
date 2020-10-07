package com.example.qr_barcodescanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    Button ScanNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScanNow=findViewById(R.id.ScanNow);

        ScanNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator=new IntentIntegrator(MainActivity.this);
                intentIntegrator.setCaptureActivity(ScanCamera.class);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.setPrompt("Scanning Now");
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        final IntentResult intentResult=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult!=null){
            if(intentResult.getContents()!=null){
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                builder.setMessage(intentResult.getContents());
                builder.setTitle("Scanned Result");
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(intentResult.getContents().startsWith("http")){
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(intentResult.getContents()));
                            startActivity(intent);
                        }
                    }
                }).setNegativeButton("Scan Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        IntentIntegrator intentIntegrator=new IntentIntegrator(MainActivity.this);
                        intentIntegrator.setCaptureActivity(ScanCamera.class);
                        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                        intentIntegrator.setOrientationLocked(false);
                        intentIntegrator.setPrompt("Scanning Now");
                        intentIntegrator.initiateScan();
                    }
                }).setNeutralButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
            else{
                Toast.makeText(this,"No Results",Toast.LENGTH_SHORT).show();
            }
        }else{
        super.onActivityResult(requestCode, resultCode, data);
        }
    }
}