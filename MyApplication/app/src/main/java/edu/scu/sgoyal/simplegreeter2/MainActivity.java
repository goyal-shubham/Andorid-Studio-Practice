package edu.scu.sgoyal.simplegreeter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message;
                EditText et = (EditText) findViewById(R.id.editText);
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

                int id = rg.getCheckedRadioButtonId();
                if( id == -1)
                {
                    message = "Hello";
                }
                else
                {
                    message = "Good " + ((RadioButton) findViewById(id)).getText();
                }

                message += ", " + et.getText() + "!";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
