package tfreese.de.androidfiae02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class LifecycleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.i("LIFECYCLE","onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFECYCLE","onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFECYCLE","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE","onDestroy");
    }
}
