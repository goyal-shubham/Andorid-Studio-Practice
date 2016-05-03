package edu.scu.sgoyal.implicit_intent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    String intentExamples[] = {
            "ActionCall",
            "ActionDial",
            "ActionGetContent_Pictures",
            "ActionSendTo",
            "ActionSendEmail",
            "ActionViewWebPage",
            "ActionEditContacts",
            "ActionViewContacts",
            "ActionWebSearch",
            "ActionViewMapsStreetView",
            "ActionViewMapsDirections",
            "ActionViewMapsCoordinates",
            "ActionViewMapsLandmarks",
            "ActionInternalStorageSettings",
            "ActionViewMusicSD",
            "ActionMusicPlayer",
            "ActionCustomIntent",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, intentExamples));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (intentExamples[position]) {
                    case "ActionCall": ActionCall(); break;
                    case "ActionDial": ActionDial(); break;
                    case "ActionGetContent_Pictures": ActionGetContent_Pictures(); break;
                    case        "ActionSendTo": ActionSendTo(); break;
                    case       "ActionSendEmail": ActionSendEmail(); break;
                    case       "ActionViewWebPage": ActionViewWebPage(); break;
                    case       "ActionEditContacts":ActionEditContacts(); break;
                    case       "ActionViewContacts": ActionViewContacts(); break;
                    case       "ActionWebSearch":ActionWebSearch(); break;
                    case       "ActionViewMapsStreetView": ActionViewMapsStreetView(); break;
                    case       "ActionViewMapsDirections": ActionViewMapsDirections(); break;
                    case       "ActionViewMapsCoordinates": ActionViewMapsCoordinates(); break;
                    case        "ActionViewMapsLandmarks": ActionViewMapsLandmarks(); break;
                    case       "ActionInternalStorageSettings": ActionInternalStorageSettings(); break;
                    case       "ActionViewMusicSD": ActionViewMusicSD(); break;
                    case       "ActionMusicPlayer":ActionMusicPlayer(); break;
                    case "ActionCustomIntent" : ActionCustomIntent(); break;
                }
            }
        });
    }

    private void ActionViewMapsStreetView()
    {
        String geoCode = "google.streetview:" + "cbll=37.3496407,-121.9409972&"
                + "cbp=1,220,0,0,0";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
        startActivity(intent);
    }

    private void ActionViewMapsCoordinates() {

        // map is centered around given Lat, Long
        String geoCode = "geo:37.773972,-122.431297?z=12";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
        startActivity(intent);

    }

    private void ActionViewMapsLandmarks() {
        // (you may get multiple results)
        String thePlace = "Golden Gate Bridge, San Francisco";
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=(" + thePlace + ")"));
        startActivity(intent);

    }

    private void ActionViewMapsDirections() {

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?"
                        + "saddr=9.938083,-84.054430&"
                        + "daddr=9.926392,-84.055964"));
        startActivity(intent);

    }

    private void ActionWebSearch()
    {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "THINGS TO DO");
        startActivity(intent);
    }

    private void ActionViewContacts()
    {
        String myData = "content://contacts/people/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
        startActivity(intent);
    }

    private void ActionEditContacts()
    {
        String data = ContactsContract.Contacts.CONTENT_URI + "/" + "5";
        Intent intent = new Intent(Intent.ACTION_EDIT, Uri.parse(data));
        startActivity(intent);
    }

    private void ActionViewWebPage()
    {
        String myUriString = "https://www.youtube.com/results?search_query=tvf";
        Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUriString));
        startActivity(myActivity2);
    }

    private void ActionMusicPlayer() {
        Intent myActivity2 = new Intent("android.intent.action.MUSIC_PLAYER");

        startActivity(myActivity2);

    }

    private void ActionViewMusicSD() {
        Intent myActivity2 = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("file://"
                + Environment.getExternalStorageDirectory()
                .getAbsolutePath()
                + "/kgmusic/download/adele - rolling in the deep.mp3");

        myActivity2.setDataAndType(data, "audio/mp3");

        startActivity(myActivity2);

    }

    private void ActionSendEmail()
    {
        String[] address = {"sgoyal@scu.edu"};
        String subject = "test";
        String body = "This is the body of Test Email";

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, address);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        intent.setType("vnd.android.cursor.dir/email");
        startActivity(Intent.createChooser(intent,
                "To complete action choose:"));

    }

    private void ActionSendTo()
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:555-1111"));

        intent.putExtra("sms_body", "are we playing golf next Sunday?");

        startActivity(intent);
    }

    private void ActionGetContent_Pictures()
    {
        Intent intent = new Intent();

        intent.setType("image/pictures/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivity(intent);
    }

    private void ActionDial()
    {
        String myPhoneNumberUri = "tel:1-800-555-1212";
        Intent myActivity2 = new Intent(Intent.ACTION_DIAL,
                Uri.parse(myPhoneNumberUri));
        startActivity(myActivity2);
    }

    private void ActionInternalStorageSettings() {
        startActivity(new Intent(android.provider.Settings.ACTION_INTERNAL_STORAGE_SETTINGS));

    }


    private void ActionCall()
    {
        String numberUri = "tel:1-800-356789";
        Intent myActivity = new Intent(Intent.ACTION_CALL, Uri.parse(numberUri));
        startActivity(myActivity);
    }

    private void ActionCustomIntent() {
        startActivity(new Intent("net.junsun.action.VOIP_CALL", Uri.parse("tel:18005551212")));
    }



}
