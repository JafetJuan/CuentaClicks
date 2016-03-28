package com.pccomponentes.cuentaclicks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private Button miBoton;
    private TextView miTexto;
    private int numVecesPulsado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        miBoton = (Button) findViewById(R.id.boton);
        miTexto = (TextView) findViewById(R.id.texto);

        View.OnClickListener miClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numVecesPulsado = numVecesPulsado + 1;
                String resultado = "El botón fue pulsado " + numVecesPulsado;
                if(numVecesPulsado == 1){
                     resultado += " vez.";
                } else {
                    resultado += " veces.";
                }
                miTexto.setText(resultado);
            }
        };

        miBoton.setOnClickListener(miClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast mensajeToast = Toast.makeText(this, "El valor de miTexto es " + miTexto.getText(),
                    Toast.LENGTH_SHORT);
            mensajeToast.show();
            numVecesPulsado = 0;
            miTexto.setText("Pulsa el botón 'Mi Botón'");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
