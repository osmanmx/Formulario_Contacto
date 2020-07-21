package org.cidie.formulario;

/**
 *  Creado por Osman Villanueva 21 julio 2020, osman@cidie.org
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Contenido extends AppCompatActivity {
    TextView nombre;
    TextView fecha;
    TextView telefono;
    TextView email;
    TextView descripcion;
    Bundle parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);

        parametros = getIntent().getExtras();
        String nombreS = parametros.getString(getResources().getString(R.string.nombre_completo));
        String anioS = parametros.getString("anio");
        String mesS = parametros.getString("mes");
        String diaS = parametros.getString("dia");
        String telefonoS = parametros.getString(getResources().getString(R.string.telefono));
        String emailS = parametros.getString(getResources().getString(R.string.email));
        String descripcionS = parametros.getString(getResources().getString(R.string.descripcion_contacto));

        nombre = (TextView) findViewById(R.id.tvNombreContacto);
        fecha = (TextView) findViewById(R.id.tvFechaContacto);
        telefono = (TextView) findViewById(R.id.tvTelefonoContacto);
        email = (TextView) findViewById(R.id.tvEmailContacto);
        descripcion = (TextView) findViewById(R.id.tvDescripcionContacto);

        nombre.setText("Nombre: " + nombreS);
        fecha.setText("Fecha de Nacimiento: " + diaS + "/" + mesS + "/" + anioS );
        telefono.setText("Teléfono: " +telefonoS);
        email.setText("Email: " + emailS);
        descripcion.setText("Descripción: " + descripcionS);
    }

    public void onClick(View v) {

        Intent inten = new Intent(Contenido.this,MainActivity.class);
        inten.putExtra("bundle",parametros);
        startActivity(inten);
        finish();

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sesion",1);

    }

}