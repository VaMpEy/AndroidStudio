package urinnenet.de.androidfiae02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StringsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strings);

        String s = getResources().getString(R.string.app_name);
        Log.i("RESSOURCE",s);
    }
}
