package edu.scu.sgoyal.simplegreeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Greeter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()    {

            @Override
            public void onClick(View v) {
                EditText ed = (EditText) findViewById(R.id.editText);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox);
                String msg;
                if(cb.isChecked())
                {
                    msg = "Good morning , " + ed.getText() + " !";
                }
                else
                {
                    msg = "Hello " + ed.getText() + " !";
                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
