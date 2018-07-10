package urinnenet.de.androidfiae02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListenerActivity extends Activity {

    public void xmlButtonClicked(View view) {
        Toast.makeText(ListenerActivity.this, "XML Attribut", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);

        /*
            Anonyme Klasse
         */
        Button buttonAnonym = findViewById(R.id.buttonAnonym);
        buttonAnonym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ListenerActivity.this, "Anonyme Klasse", Toast.LENGTH_SHORT).show();
            }
        });

        /*
            Lambda
        */
        Button buttonLambda = findViewById(R.id.buttonLambda);
        buttonLambda.setOnClickListener(view -> Toast.makeText(ListenerActivity.this, "Lambda", Toast.LENGTH_LONG).show());

    }

    public void methRef(View view) {
    }
}
