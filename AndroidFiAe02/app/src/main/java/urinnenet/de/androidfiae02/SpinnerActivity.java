package urinnenet.de.androidfiae02;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Spinner;
        import android.widget.Toast;

public class SpinnerActivity extends Activity {

    public void spinnerSelected(View view) {
        Spinner spinner = findViewById(R.id.spinner);
        String item = (String)spinner.getSelectedItem();
        Toast.makeText(SpinnerActivity.this, item,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = findViewById(R.id.spinner);
        String item = (String)spinner.getSelectedItem();
    }
}
