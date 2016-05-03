package edu.scu.sgoyal.contextmenuwithactionmode;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shubhamgoyal on 5/2/16.
 */
public class ContextMenuCallback implements ActionMode.Callback
{
    MainActivity _mainActivity;
    TextView _textView;

    public ContextMenuCallback(MainActivity mainActivity, TextView textView) {
        _mainActivity = mainActivity;
        _textView = textView;
    }


    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu)
    {
        mode.getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu)
    {
        toast("Preparing ActionMode ...");
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.action_decrease:
                _textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, _textView.getTextSize()-10);
                _textView.setBackgroundColor(Color.RED);
                break;
            case R.id.action_increase:
                _textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, _textView.getTextSize() + 10);
                _textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.action_change_color:
                _textView.setBackgroundColor(Color.GRAY);
                break;
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode)
    {
        toast("ActionMode Destroyed");


    }

    private void toast (String msg) {
        Toast.makeText(_mainActivity.getApplicationContext(), msg , Toast.LENGTH_SHORT).show();
    }
}
