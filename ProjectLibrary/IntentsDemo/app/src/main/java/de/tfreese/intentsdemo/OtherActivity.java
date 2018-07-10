package de.tfreese.intentsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class OtherActivity extends Activity {

    public void closeOtherActivity(View v) {
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
            if (intent.hasExtra("MyDouble")) {
                double myDouble = intent.getDoubleExtra("MyDoubleX", 0.0);
                Log.i("MyDouble", String.valueOf(myDouble));
            }
            if (intent.hasExtra("MyArray")) {
                int[] myArray = intent.getIntArrayExtra("MyArray");
                // Ausgabe 1
                for (int i = 0; i < myArray.length; i++) {
                    Log.i("MyArray " + i, String.valueOf(myArray[i]));
                }

                // Ausgabe 2
                String ausgabe = "";
                for (int zahl : myArray) {
                    ausgabe += String.valueOf(zahl) + " ";
                }
                Log.i("MyArray", ausgabe);
            }
            if(intent.hasExtra("MyData")) {
                MyData mydata = intent.getParcelableExtra("MyData");
                Log.i("MyData", mydata.toString());
            }

        }
    }
    public void closeOtherActivityWithReturn(View v) {
        Intent intent = new Intent();
        intent.putExtra("RETURN","Der Rückgabewert");
        setResult(RESULT_OK, intent);
        this.finish();
    }
}
