package tfreese.de.androidfiae02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputOutputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_output);

        TextView ausgabe = findViewById(R.id.textViewAusgabe);

        try (InputStream inputStream = getResources().openRawResource(R.raw.namen);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String zeile;
            while ((zeile = reader.readLine()) != null) {
                ausgabe.append("\n" + zeile);
                Log.i("ZEILE", zeile);
            }
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
        }
    }
}
