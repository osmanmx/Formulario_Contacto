package org.cidie.formulario;

/**
 *  Creado por Osman Villanueva 21 julio 2020, osman@cidie.org
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity   {

    EditText nombre;
    DatePicker fecha;
    EditText telefono;
    EditText email;
    EditText descripcion;
    int sesion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre =  (EditText)findViewById(R.id.etNombreCompleto);
        fecha =  (DatePicker)findViewById(R.id.dpFecha);
        telefono =  (EditText)findViewById(R.id.etTelefono);
        email = (EditText)findViewById(R.id.etEmail);
        descripcion =  (EditText)findViewById(R.id.etDescripcionContacto);

        SharedPreferences preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        int valorRestaurado = (int) preferencias.getInt("sesion",0);
        if(valorRestaurado == 1){
            restaurarDatos(savedInstanceState);
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putInt("sesion",0);
            editor.apply();

        }

    }



    public void onClick(View v) {


        Intent inten = new Intent(MainActivity.this,Contenido.class);
        inten.putExtra(getResources().getString(R.string.nombre_completo),nombre.getText().toString());
        inten.putExtra("anio",String.valueOf(fecha.getYear()));
        inten.putExtra("mes",String.valueOf(fecha.getMonth()));
        inten.putExtra("dia",String.valueOf(fecha.getDayOfMonth()));
        inten.putExtra(getResources().getString(R.string.telefono),telefono.getText().toString());
        inten.putExtra(getResources().getString(R.string.email),email.getText().toString());
        inten.putExtra(getResources().getString(R.string.descripcion_contacto),descripcion.getText().toString());
        startActivity(inten);
        SharedPreferences preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putInt("sesion",1);
        editor.apply();

        finish();
    }



    public void restaurarDatos(Bundle restaurado){
        Bundle parametros = getIntent().getExtras();
        Bundle bundleContenido = parametros.getBundle("bundle");

        String nombreS = bundleContenido.getString(getResources().getString(R.string.nombre_completo));
        String anioS = bundleContenido.getString("anio");
        String mesS = bundleContenido.getString("mes");
        String diaS = bundleContenido.getString("dia");
        String telefonoS =bundleContenido.getString(getResources().getString(R.string.telefono));
        String emailS = bundleContenido.getString(getResources().getString(R.string.email));
        String descripcionS = bundleContenido.getString(getResources().getString(R.string.descripcion_contacto));

        nombre.setText(nombreS);
        fecha.updateDate(Integer.parseInt(anioS),Integer.parseInt(mesS),Integer.parseInt(diaS));
        telefono.setText(telefonoS);
        email.setText(emailS);
        descripcion.setText(descripcionS);

    }

}
