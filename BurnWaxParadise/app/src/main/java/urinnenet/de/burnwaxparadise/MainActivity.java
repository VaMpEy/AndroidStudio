package urinnenet.de.burnwaxparadise;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Candle candle;
    Time time;

    public void doCalculate() {
        candle.setWeight((Math.PI * candle.getHeight()) * candle.getWidth() * candle.getWidth() / 4 * candle.getDensity());
        double temp = candle.getWeight() / candle.getDensity();
        time.setHours(((int) Math.floor(temp)));
        time.setMinutes(((int) (temp- time.getHours())*60));
        while(time.getMinutes()>59) {
            time.setMinutes(time.getMinutes() - 60);
            time.setHours(time.getHours() + 1);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        Button buttonReset = findViewById(R.id.buttonReset);
        candle = new Candle();
        time = new Time();
        final Spinner spinner = findViewById(R.id.spinnerMaterial);
        final TextView editTextHeight = findViewById(R.id.editTextHeight);
        final TextView editTextWidth = findViewById(R.id.editTextWidth);
        final TextView burnTimeResult = findViewById(R.id.textViewBurnTimeResult);
        Material material = candle.getMaterial();

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().equals("Paraffin wax")){
//                    textArea.setText("");
                    candle.setMaterial("Paraffin wax");
                    candle.setDensity(.9);
                    Toast.makeText(MainActivity.this, "Paraffin wax it is!", Toast.LENGTH_SHORT).show();
                    doCalculate();
//                    editTextHeight.setText(editTextHeight.getText()*);
                    burnTimeResult.setText(time.getHours() + ":" + time.getMinutes());

                }
                else if (spinner.getSelectedItem().toString().equals("Stearin")){
                    candle.setMaterial("Stearin");
                    candle.setDensity(.93);
                    Toast.makeText(MainActivity.this, "Stearin it is!", Toast.LENGTH_SHORT).show();
                    burnTimeResult.setText(time.getHours() + ":" + time.getMinutes());
                }
                else {
                    candle.setMaterial("Bees wax");
                    candle.setDensity(.95);
                    Toast.makeText(MainActivity.this, "Bees wax it is!", Toast.LENGTH_SHORT).show();
                    burnTimeResult.setText(time.getHours() + ":" + time.getMinutes());
                }

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                editTextHeight.setText("0.0");
                editTextWidth.setText("0.0");
                burnTimeResult.setText("0:0");
            }
        });
    }
}
