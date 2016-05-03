package edu.scu.sgoyal.recyclerview_cardview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<ContactInfo> nameList;
    private int numNames = 0;
    ContactAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.nameList);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        nameList = new ArrayList<ContactInfo>();
        ca = new ContactAdapter(nameList);
        rv.setAdapter(ca);

        FloatingActionButton fb = (FloatingActionButton) findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addNewContact();
                ca.notifyItemInserted(nameList.size() - 1);
            }
        });


    }


    public void addNewContact()
    {
        int i = numNames++;
        ContactInfo ci = new ContactInfo();
        ci.name = ContactInfo.NAME_PREFIX + i;
        ci.surname = ContactInfo.SURNAME_PREFIX + i;
        ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";
        ci.phone = randomDigit() + "-" + randomDigit() + "-" + randomDigit();

        nameList.add(ci);
    }

    public String randomDigit()
    {
        int i = 100 + (new Random().nextInt(900));
        return String.valueOf(i);
    }
}
