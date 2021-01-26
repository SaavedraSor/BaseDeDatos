package com.example.base_datos_tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
EditText et_nombreI,et_codigoI,et_nombreM,et_codigoM,et_nombreC,et_codigoC,et_nombreE,et_codigoE;
Button insertarDI,consultaBC,eliminarBE,moficarBM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);



        insertarDI = (Button)findViewById(R.id.insert);
        consultaBC = (Button)findViewById(R.id.button2);
        eliminarBE = (Button)findViewById(R.id.eliminarBE);
        moficarBM = (Button)findViewById(R.id.modif);

        et_nombreC = (EditText) findViewById(R.id.et_nombreC);
        et_codigoC = (EditText) findViewById(R.id.et_codigoC);
        et_nombreE = (EditText) findViewById(R.id.et_nombreE);
        et_codigoE = (EditText) findViewById(R.id.et_codigoE);
        et_nombreM = (EditText) findViewById(R.id.et_nombreM);
        et_codigoM = (EditText) findViewById(R.id.et_codigoM);
        et_nombreI = (EditText) findViewById(R.id.et_nombreI);
        et_codigoI = (EditText) findViewById(R.id.et_codigoI);
    }
     public void insertarDI(View view){

       BaseD sqLiteDatabase = new BaseD(this,"db1", null,1);
        SQLiteDatabase BaseDatos = sqLiteDatabase.getWritableDatabase();

        String codigo = et_codigoI.getText().toString();
        String nombre = et_nombreI.getText().toString();



        ContentValues registro = new ContentValues();

        registro.put("codigo", codigo);
        registro.put("nombre", nombre);

        BaseDatos.insert("productos",null, registro);
        BaseDatos.close();

        Toast.makeText(this,"Datos Insertados", Toast.LENGTH_LONG).show();

    }

    public void consultaBC(View view)
    {
    BaseD sqLiteDatabase= new BaseD(this,"db1",null,1);
    SQLiteDatabase BaseDatos = sqLiteDatabase.getWritableDatabase();

    String codigo = et_codigoC.getText().toString();
        String nombre = et_nombreC.getText().toString();

        Cursor fila = BaseDatos.rawQuery("select nombre from productos where codigo"+codigo, null);
   if(fila.moveToFirst())
   {

   }
        et_nombreC.setText(fila.getString(0));
        et_codigoC.setText(fila.getString(0));
        BaseDatos.close();




    }

       public void eliminarBE(View view)
       {
           BaseD sqLiteDatabase= new BaseD(this,"db1",null,1);
           SQLiteDatabase BaseDatos = sqLiteDatabase.getWritableDatabase();

           String codigo = et_codigoE.getText().toString();

           BaseDatos.delete("productos", "codigo"+ codigo, null);
       }

        public void modificarBM(View view)
        {
            BaseD sqLiteDatabase= new BaseD(this,"db1",null,1);
            SQLiteDatabase BaseDatos = sqLiteDatabase.getWritableDatabase();


            String codigo = et_codigoM.getText().toString();
            String nombre = et_nombreM.getText().toString();


            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("nombre", nombre);

            BaseDatos.update("productos",registro, "codigo"+ codigo, null);
             BaseDatos.close();
        }



}