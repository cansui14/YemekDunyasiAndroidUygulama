package com.example.yemek_dunyasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView sayfadegis=findViewById(R.id.sayfa);

        sayfadegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent girisyap = new Intent(MainActivity.this, siparis.class);
                startActivity(girisyap);

            }
        });
    }
}
