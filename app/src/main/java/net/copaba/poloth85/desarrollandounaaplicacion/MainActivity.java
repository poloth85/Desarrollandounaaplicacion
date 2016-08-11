package net.copaba.poloth85.desarrollandounaaplicacion;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int y;
    int m;
    int d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();

        final Calendar c    = Calendar.getInstance();
        final int year      = c.get(Calendar.YEAR);
        final int month     = c.get(Calendar.MONTH);
        final int day       = c.get(Calendar.DAY_OF_MONTH);
        final String dfecha  = day + " / " + (month + 1) + " / " + year;

        final Button boton = (Button) findViewById(R.id.boton);
        final TextView tvBdate = (TextView) findViewById(R.id.bdate);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.picker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year1, int month1, int day1) {
                String nfecha = day1 + " / " + (month1 + 1) + " / " + year1;
                System.out.println(nfecha);
                tvBdate.setText(nfecha);
                //Toast.makeText(MainActivity.this,"Fecha Seleccionada",Toast.LENGTH_SHORT).show();
                System.out.println("/////////////"+datePicker.getYear()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getDayOfMonth());
                y = year1;
                m = month1;
                d = day1;
            }
        });
        if(parametros != null){
            String nombre       = parametros.getString(getResources().getString(R.string.pnombre));

            String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));;
            String email        = parametros.getString(getResources().getString(R.string.pemail));;
            String descripcion  = parametros.getString(getResources().getString(R.string.pdescripcion));;

            y = parametros.getInt(getResources().getString(R.string.y));
            m = parametros.getInt(getResources().getString(R.string.m));
            d = parametros.getInt(getResources().getString(R.string.d));
            String fecha = d + " / " + m + " / " + y;
            TextInputEditText pnombre = (TextInputEditText) findViewById(R.id.nombre);
            TextView pfecha = (TextView) findViewById(R.id.bdate);
            TextInputEditText ptelefono = (TextInputEditText) findViewById(R.id.telefono);
            TextInputEditText pmail = (TextInputEditText) findViewById(R.id.email);
            TextInputEditText pdescripcion = (TextInputEditText) findViewById(R.id.descripcion);
            pnombre.setText(nombre);
            pfecha.setText(fecha);
            ptelefono.setText(telefono);
            pmail.setText(email);
            pdescripcion.setText(descripcion);
            datePicker.updateDate(y,m,d);

        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText pnombre = (TextInputEditText) findViewById(R.id.nombre);
                TextView pfecha = (TextView) findViewById(R.id.bdate);
                TextInputEditText ptelefono = (TextInputEditText) findViewById(R.id.telefono);
                TextInputEditText pmail = (TextInputEditText) findViewById(R.id.email);
                TextInputEditText pdescripcion = (TextInputEditText) findViewById(R.id.descripcion);
                if(pnombre.length() == 0){
                    pnombre.setError("este campo no puede estar vacío");
                    pnombre.requestFocus();
                    return;
                }else{
                    if(pfecha.length() == 0){
                        pfecha.setError("este campo no puede estar vacío");
                        datePicker.requestFocus();
                        return;
                    }else{
                        if(ptelefono.length() == 0){
                            ptelefono.setError("este campo no puede estar vacío");
                            ptelefono.requestFocus();
                            return;
                        }else{
                            if(pmail.length() == 0){
                                pmail.setError("este campo no puede estar vacío");
                                pmail.requestFocus();
                                return;
                            }else{
                                if(pdescripcion.length() == 0){
                                    pdescripcion.setError("este campo no puede estar vacío");
                                    pdescripcion.requestFocus();
                                    return;
                                }
                            }
                        }
                    }
                }

                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra(getResources().getString(R.string.pnombre), pnombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), pfecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), ptelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), pmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), pdescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.y),y);
                intent.putExtra(getResources().getString(R.string.m),m);
                intent.putExtra(getResources().getString(R.string.d),d);
                startActivity(intent);
                finish();
            }
        });
    }
}
