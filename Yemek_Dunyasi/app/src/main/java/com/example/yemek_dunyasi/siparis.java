package com.example.yemek_dunyasi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class siparis extends AppCompatActivity{
    private static final int REQUEST_CALL=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siparis);

        Button gonder=findViewById(R.id.gonder);
        Button ara=findViewById(R.id.ara);
        final Spinner menu=findViewById(R.id.spinner);

        final EditText ad=findViewById(R.id.txtad);
        final EditText soyad=findViewById(R.id.txtsoyad);
        final EditText adres=findViewById(R.id.txtadres);


        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mesajGonder = new Intent(Intent.ACTION_VIEW);
                mesajGonder.setData(Uri.parse("sms: 05535535353"));
                mesajGonder.putExtra("sms_body", ad.getText().toString()+" "+soyad.getText().toString()+" Adres "+adres.getText().toString()+" Siparis : "+menu.getSelectedItem().toString());
                startActivity(mesajGonder);

            }
        });

        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(siparis.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(siparis.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }
                else
                {
                    String ara="tel: 05555555555";
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(ara)));
                    Toast.makeText(getApplicationContext(),"Aranıyor...",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

