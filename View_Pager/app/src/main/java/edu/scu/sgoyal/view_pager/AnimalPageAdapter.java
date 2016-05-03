package edu.scu.sgoyal.view_pager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by shubhamgoyal on 5/2/16.
 */
public class AnimalPageAdapter extends PagerAdapter
{
    private final List<Animal> animals;
    private Context context;

    public AnimalPageAdapter(Context context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    @Override
    public int getCount()
    {
        return animals.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        ImageView iv = new ImageView(context);
        iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        iv.setImageResource(animals.get(position).getImageId());
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        container.addView(iv, 0);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
//        super.destroyItem(container, position, object);
        container.removeView((View)object);

    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return animals.get(position).getName();
    }
}

