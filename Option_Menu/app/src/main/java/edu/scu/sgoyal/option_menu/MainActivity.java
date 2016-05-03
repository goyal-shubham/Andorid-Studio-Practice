package edu.scu.sgoyal.option_menu;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Shubham Goyal");
        actionBar.setSubtitle("Option Menu");
        actionBar.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.action_bar));
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        textView = (TextView) findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_xml, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_decrease:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textView.getTextSize() - 10);
                textView.setBackgroundColor(Color.RED);
                break;
            case R.id.action_increase:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textView.getTextSize() + 10);
                textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.action_change_color:
                textView.setBackgroundColor(Color.GRAY);
                break;
            case R.id.action_clear:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 50);
                textView.setBackgroundColor(Color.WHITE);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                toast("Search action ...");
                break;
            case R.id.action_share:
                toast("Share action ...");
                break;
            case R.id.action_download:
                toast("Download action ...");
                break;
            case R.id.action_settings:
                toast("Settings action ...");
                break;
            case R.id.action_about:
                toast("About action ...");
                break;
            case android.R.id.home:
                toast("Home button ...");
                break;
            default:
                toast("unknown action ...");
        }

        return true;
    }

    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
