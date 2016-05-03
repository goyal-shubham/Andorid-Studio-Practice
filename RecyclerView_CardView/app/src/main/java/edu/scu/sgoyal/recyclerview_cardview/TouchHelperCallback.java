package edu.scu.sgoyal.recyclerview_cardview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

/**
 * Created by shubhamgoyal on 4/30/16.
 */
public class TouchHelperCallback extends ItemTouchHelper.Callback
{

    ContactAdapter mAdapter;

    public TouchHelperCallback(ContactAdapter adapter)
    {
        mAdapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder)
    {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager)
        {
            final int drawFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            final int swipeFlags = 0;
            return makeMovementFlags(drawFlags, swipeFlags);
        }
        else
        {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target)
    {
        Log.i("sgoyal" , "Item Moved from " + source.getAdapterPosition() + " to " + target.getAdapterPosition());
        return mAdapter.onItemMoved(source.getAdapterPosition(), target.getAdapterPosition());
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
    {
        Log.i("Sgoyal", "item at " + viewHolder.getAdapterPosition() + " is swiped away");
        mAdapter.onItemDismissed(viewHolder.getAdapterPosition());
    }
}
