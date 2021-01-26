package com.example.base_datos_tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et,con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et = (EditText) findViewById(R.id.txt1);
        con = (EditText) findViewById(R.id.pass);


        SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);



        if (preferences1.contains("nombre")&&preferences1.contains("contrasenna")) {

            Intent intent = new Intent(Login.this,Menu.class);
            startActivity(intent);
            finish();
        }

    }

    public void iniciar(View view){
        //SharedPreferences = getSharedPreferences( "dato", 0);
        SharedPreferences preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences1.edit();

        String datosN = et.getText().toString();
        String Cont = con.getText().toString();

        editor.putString("nombre",datosN);
        editor.putString("contrasena",Cont);
        editor.commit();

        Toast.makeText(this,"Ingreso correcto, Bienvenido", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);

        finish();
        editor.clear();
    }


}