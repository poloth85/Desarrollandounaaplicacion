package net.copaba.poloth85.desarrollandounaaplicacion;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Polo on 09/08/16.
 */
public class DateSettings implements DatePickerDialog.OnDateSetListener {

    Context context;
    public DateSettings(Context context)
    {
        this.context = context;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Toast.makeText(context, "Fecha seleccionada :" + day + " / " + month + " / " + year, Toast.LENGTH_LONG).show();
    }
}
