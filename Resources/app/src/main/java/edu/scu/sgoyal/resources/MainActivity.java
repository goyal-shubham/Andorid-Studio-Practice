package edu.scu.sgoyal.resources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Changing Pic from Cat to Lion
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.lion);

        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        param.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        param.addRule(RelativeLayout.CENTER_VERTICAL);
        iv.setLayoutParams(param);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout);
        rl.addView(iv);




    }
}
