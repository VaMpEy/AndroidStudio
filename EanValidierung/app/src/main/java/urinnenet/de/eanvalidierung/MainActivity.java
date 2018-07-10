package urinnenet.de.eanvalidierung;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView output;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.textViewResultMessage);

        Button buttonCheckEan = findViewById(R.id.buttonCheckEan);

        buttonCheckEan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = findViewById(R.id.editTextEanCode);
                EAN ean = new EAN(R.id.editTextEanCode);

                if(ean.isValid()) {
                    result = "EAN is valid";
                }
                else {
                    result = "EAN is not valid";
                }

                output.setText(result);
            }
        });
    }
}
