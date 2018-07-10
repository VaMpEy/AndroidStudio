package tfreese.de.candleburn;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Spinner spinnerMaterial;
    private EditText editTextLength;
    private EditText editTextDiameter;
    private EditText editTextBurningTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMaterial = findViewById(R.id.spinnerMaterial);
        editTextLength = findViewById(R.id.editTextLength);
        editTextDiameter = findViewById(R.id.editTextDiameter);
        editTextBurningTime = findViewById(R.id.editTextBurningTime);
    }

    public void reset(View view) {
        spinnerMaterial.setSelection(0);
        editTextLength.setText("");
        editTextDiameter.setText("");
        editTextBurningTime.setText("");
    }

    public void showErrorMessage(int resId) {
        Toast toast = Toast.makeText(this, resId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public Material getMaterial() {
        int index = (int) spinnerMaterial.getSelectedItemId();
        try {
            String[] enumNames = getResources().getStringArray(R.array.material_enum_array);
            return Material.valueOf(enumNames[index]);
        } catch (Resources.NotFoundException e) {
            return Material.STEARIN;
        } catch (IllegalArgumentException e) {
            return Material.STEARIN;
        }
    }

    public double getLength() {
        String lengthStr = editTextLength.getText().toString();
        try {
            return Double.parseDouble(lengthStr);
        } catch (NumberFormatException e) {
            showErrorMessage(R.string.error_msg_length);
            return 0.0;
        }
    }

    public double getDiameter() {
        String diameterStr = editTextDiameter.getText().toString();
        try {
            return Double.parseDouble(diameterStr);
        } catch (NumberFormatException e) {
            showErrorMessage(R.string.error_msg_diameter);
            return 0.0;
        }
    }

    public void calculate(View view) {
        double length = getLength();
        double diameter = getDiameter();
        Material material = getMaterial();

        Candle candle = new Candle(length, diameter, material);

        // Variante 1
        editTextBurningTime.setText(candle.getBurningtimeAsString());

        // Variante 2
//        double burningtime = candle.getBurningtime();
//        editTextBurningTime.setText(Time.asString(burningtime));
    }
}
