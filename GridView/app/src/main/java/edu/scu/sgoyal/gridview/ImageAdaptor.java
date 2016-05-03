package edu.scu.sgoyal.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by shubhamgoyal on 4/30/16.
 */
public class ImageAdaptor extends BaseAdapter
{

    Integer[] smallImages;
    private Context context;

    public ImageAdaptor(Context callingActivityContext, Integer[] smallImages)
    {
        this.context = callingActivityContext;
        this.smallImages = smallImages;
    }

    @Override
    public int getCount()
    {
        return smallImages.length;
    }

    @Override
    public Object getItem(int position)
    {
        return smallImages[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        SquareImageView squareImageView;
        if(convertView == null)
        {
            squareImageView = new SquareImageView(context);
            squareImageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            squareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            squareImageView.setPadding(0, 0, 0, 0);
        }
        else
        {
            squareImageView = (SquareImageView) convertView;

        }
        squareImageView.setImageResource(smallImages[position]);
        return  squareImageView;
    }


    public class SquareImageView extends ImageView
    {
        public SquareImageView(Context context) {
            super(context);
        }

        @Override
        public void onMeasure(int width, int height) {
            super.onMeasure(width, width);
        }
    }
}
