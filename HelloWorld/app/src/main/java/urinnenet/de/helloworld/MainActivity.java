package urinnenet.de.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView ausgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ausgabe = findViewById(R.id.textViewAusgabe);
        ausgabe.setText("Moin Welt!");

        Button buttonTuWas = findViewById(R.id.buttonTuWas);

        buttonTuWas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eingabe = findViewById(R.id.editTextEingabe);
                ausgabe.setText(eingabe.getText());
            }
        });
    }
}
