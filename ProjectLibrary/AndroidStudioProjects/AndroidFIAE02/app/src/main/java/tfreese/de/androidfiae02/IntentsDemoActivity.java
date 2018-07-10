package tfreese.de.androidfiae02;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;

public class IntentsDemoActivity extends Activity {

    public void showOtherActivity(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

    public void showOtherActivityWithData(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra("MyString", "Daten als Zeichenkette");
        double preis = 12.89;
//        intent.putExtra("gesamtpreis",preis);

        int[] myArray = {2, 45, 236, 17, 32, 8};
        intent.putExtra("MyArray", myArray);

        startActivity(intent);
    }

    public void showOtherActivityWithParcelable(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        Person person = new Person("Hildegard",87);
        intent.putExtra("person", person);
        startActivity(intent);
    }

    private final int REQUEST_CODE = 4711;

    public void showOtherActivityWithResult(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Log.i("Result", data.getStringExtra("Rückgabe"));
            }
        }
    }

    public void startBrowser(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.it-bildungshaus.de"));
        startActivity(intent);
    }

    public void startWebSuche(View view) {
        String query = "android";
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 13);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 36);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Nachricht");
        startActivity(intent);
    }

    public void showMaps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String geo = "geo:0,0?q=bremen+konsul-smidt-strasse+24";
        // https://developers.google.com/maps/documentation/urls/android-intents
        intent.setData(Uri.parse(geo));
        startActivity(intent);
    }

    public void showGiza(View view) {
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=29.9774614,31.1329645&cbp=0,30,0,0,-15");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_demo);
    }
}
