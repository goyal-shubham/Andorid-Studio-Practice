package edu.scu.sgoyal.dateandtimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    EditText date;
    EditText time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (EditText) findViewById(R.id.editText2);
        time = (EditText) findViewById(R.id.editText);

    }

    public void setDate(View v)
    {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
            }
        };
        (new DatePickerDialog(MainActivity.this, listener, 2016, 04, 29)).show();
    }

    public void setTime(View v)
    {

        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time.setText(hourOfDay + ":" + minute);

            }
        };

        (new TimePickerDialog(this, listener, 19, 00,false)).show();

    }
}
