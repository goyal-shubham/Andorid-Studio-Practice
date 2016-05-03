package edu.scu.sgoyal.complexcustomlistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by shubhamgoyal on 4/30/16.
 */
public class AnimalArrayAdapter extends ArrayAdapter<Animal> {

    private final List<Animal> animals;
    Context context;

    public AnimalArrayAdapter(Context context, int resource, List<Animal> animals) {
        super(context, resource, animals);
        this.animals = animals;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ScrapViewHolder holder;
        if (row == null) {
            Log.i("Me", "Row will be inflated");

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.custom_row, parent, false);

            holder = new ScrapViewHolder();
            holder.label = (TextView) row.findViewById(R.id.label);
            holder.icon = (ImageView) row.findViewById(R.id.icon);
            holder.menu = (ImageView) row.findViewById(R.id.menu);

            row.setTag(holder);

        }
        else
        {
            Log.i("jsun", "Row is NOT null; reusing it!");
            holder = (ScrapViewHolder) row.getTag();
        }

        holder.label.setText(animals.get(position).getName());
        try {
            String fileName = animals.get(position).getFilename();
            InputStream is = getContext().getAssets().open(fileName);
            Drawable drawable = Drawable.createFromStream(is, null);
            holder.icon.setImageDrawable(drawable);
            holder.icon.setScaleType(ImageView.ScaleType.CENTER_CROP);

        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "MENU clicked for " + animals.get(position).getName();
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });

        return row;
    }

    public class ScrapViewHolder {
        TextView label;
        ImageView icon;
        ImageView menu;
    }
}
