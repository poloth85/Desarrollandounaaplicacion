package net.copaba.poloth85.desarrollandounaaplicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button btnEditar;
    int y;
    int m;
    int d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();

        String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha        = parametros.getString(getResources().getString(R.string.pfecha));;
        String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));;
        String email        = parametros.getString(getResources().getString(R.string.pemail));;
        String descripcion  = parametros.getString(getResources().getString(R.string.pdescripcion));;

        y = parametros.getInt(getResources().getString(R.string.y));
        m = parametros.getInt(getResources().getString(R.string.m));
        d = parametros.getInt(getResources().getString(R.string.d));
        System.out.println(nombre);
        System.out.println(fecha);
        System.out.println(telefono);
        System.out.println(email);
        System.out.println(descripcion);

        tvNombre        = (TextView) findViewById(R.id.txtNombre);
        tvFecha         = (TextView) findViewById(R.id.txtFecha);
        tvTelefono      = (TextView) findViewById(R.id.txtTel);
        tvEmail         = (TextView) findViewById(R.id.txtEmail);
        tvDescripcion   = (TextView) findViewById(R.id.txtDescripcion);
        btnEditar       = (Button) findViewById(R.id.edBoton);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), tvNombre.getText().toString());
                //intent.putExtra(getResources().getString(R.string.pfecha), tvFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), tvDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.y), y);
                intent.putExtra(getResources().getString(R.string.m), m);
                intent.putExtra(getResources().getString(R.string.d), d);
                startActivity(intent);
                finish();
            }
        });

    }
}
