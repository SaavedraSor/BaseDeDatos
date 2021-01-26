package com.example.base_datos_tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class insertar extends AppCompatActivity {
Button insertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        insertar = (Button) findViewById(R.id.regreso);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Menu = new Intent(insertar.this,Menu.class);
                startActivity(Menu);
            }
        });



    }
}