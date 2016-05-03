package edu.scu.sgoyal.view_pager;

/**
 * Created by shubhamgoyal on 5/2/16.
 */
public class Animal
{
    private String name;
    private int imageResrouceId;

    public Animal(String name, int resourceId) {
        this.name = name;
        this.imageResrouceId = resourceId;
    }

    public String getName()
    {
        return name;
    }

    public int getImageId()
    {
        return imageResrouceId;
    }
}

