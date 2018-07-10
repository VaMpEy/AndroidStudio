package tfreese.de.androidfiae02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class OtherActivity extends Activity {

    public void finishActivity(View view) {
        Intent intent = new Intent();
        intent.putExtra("Rückgabe","Der Rückgabewert");
        setResult(RESULT_OK, intent);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("MyString")) {
                String myString = intent.getStringExtra("MyString");
                Log.i("MyString", myString);
            }
//            if (intent.hasExtra("gesamtpreis")) {
            double preis = intent.getDoubleExtra("gesamtpreis", 0.0);
            Log.i("gesamtpreis", String.valueOf(preis));
//            }
            if (intent.hasExtra("MyArray")) {
                int[] myArray = intent.getIntArrayExtra("MyArray");
                String arrayContent = "";
                for (int i : myArray) {
                    arrayContent += i + " ";
                }
                Log.i("MyArray", arrayContent);
            }

            if (intent.hasExtra("person")) {
                Person person = intent.getParcelableExtra("person");
                Log.i("Name", person.getName());
                Log.i("Age", String.valueOf(person.getAge()));
            }

        }
    }
}
