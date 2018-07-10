package tfreese.de.eanvalidator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonCheckEAN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eingabe = findViewById(R.id.editTextEAN);
                TextView ausgabe = findViewById(R.id.textViewAusgabe);
                Ean ean = new Ean();
                ean.setEan(eingabe.getText().toString());
                if (ean.isValid())
                    ausgabe.setText("gültig");
                else
                    ausgabe.setText("ungültig!");
            }
        });

    }
}
