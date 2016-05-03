package edu.scu.sgoyal.spinnerwithcustom_row;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.List;

/**
 * Created by shubhamgoyal on 4/30/16.
 */
public class AnimalArrayAdaptor extends ArrayAdapter<Animal>
{

    List<Animal> animalList;
    public AnimalArrayAdaptor(Context context, int resource, List<Animal> animalList)
    {
        super(context, resource, animalList);
        this.animalList = animalList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return getDropDownView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, null);

        TextView tv = (TextView) row.findViewById(R.id.label);
        tv.setText(animalList.get(position).getName());

        try
        {
            ImageView imageView = (ImageView) row.findViewById(R.id.icon);
            String fileName = animalList.get(position).getFilename();
            InputStream is = getContext().getAssets().open(fileName);
            Drawable drawable = Drawable.createFromStream(is, null);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return row;
    }
}
