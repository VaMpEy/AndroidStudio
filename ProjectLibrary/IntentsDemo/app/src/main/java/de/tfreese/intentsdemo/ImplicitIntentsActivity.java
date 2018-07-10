package de.tfreese.intentsdemo;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.os.Bundle;
import android.view.View;

public class ImplicitIntentsActivity extends Activity {

    public void startBrowser(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.it-bildungshaus.de"));
        startActivity(intent);
    }

    public void searchWeb(View v) {
        String query = "android";
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void setAlarm(View v) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Aufwachen!!!");
        intent.putExtra(AlarmClock.EXTRA_HOUR, 7);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 28);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showGoogleMaps(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String geo = "geo:0,0?q=bremen+konsul-smidt-strasse+24";
//        String geo ="geo:0,0?q=brandenburger+tor&z=23";
        Uri geoLocation = Uri.parse(geo);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);
    }
}
