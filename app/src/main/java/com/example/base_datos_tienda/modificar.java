package com.example.base_datos_tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class modificar extends AppCompatActivity {
   Button modificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);


        modificar = (Button) findViewById(R.id.regreso2);

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Menu = new Intent(modificar.this,Menu.class);
                startActivity(Menu);
            }
        });





    }
}