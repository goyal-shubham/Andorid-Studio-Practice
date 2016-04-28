package edu.scu.sgoyal.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shubhamgoyal on 4/28/16.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
