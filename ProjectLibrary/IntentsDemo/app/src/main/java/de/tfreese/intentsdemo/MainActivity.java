package de.tfreese.intentsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {


    public void showOtherActivity(View v) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

    public void showOtherActivityWithData(View v) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra("MyString", "Daten als Zeichenkette");
        intent.putExtra("MyDouble", 123.456);

        int[] myArray = {2, 45, 698, 74, 120};
        intent.putExtra("MyArray", myArray);

        MyData myData = new MyData();
        intent.putExtra("MyData", myData);

        startActivity(intent);
    }

    private final int REQUEST_CODE_EXPLICIT = 123;

    public void showOtherActivityWithReturn(View v) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivityForResult(intent, REQUEST_CODE_EXPLICIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_EXPLICIT) {
            if (resultCode == RESULT_OK) {
                Log.i("RETURN", data.getStringExtra("RETURN"));
            }
        }
    }

    public void showImplicitIntentsActivity(View v) {
        Intent intent = new Intent(this, ImplicitIntentsActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "Resume");
    }
}
