package com.example.base_datos_tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button modificar,consultar,eliminar,insertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        consultar = (Button) findViewById(R.id.button4);
        eliminar = (Button) findViewById(R.id.button6);
        modificar = (Button) findViewById(R.id.button9);
        insertar = (Button) findViewById(R.id.button8);




        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consultar= new Intent(Menu.this,consultar.class);
                startActivity(consultar);
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent eliminar= new Intent(Menu.this,eliminar.class);
                startActivity(eliminar);
            }
        });

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modificar= new Intent(Menu.this,modificar.class);
                startActivity(modificar);
            }
        });


        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insertar= new Intent(Menu.this,insertar.class);
                startActivity(insertar);
            }
        });


    }
}
