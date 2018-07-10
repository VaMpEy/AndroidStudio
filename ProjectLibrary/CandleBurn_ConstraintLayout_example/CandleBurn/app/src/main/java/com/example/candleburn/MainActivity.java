package com.example.candleburn;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

  private EditText editTextLength;
  private EditText editTextDiameter;
  private TextView textViewResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editTextLength = findViewById(R.id.editTextLength);
    editTextDiameter = findViewById(R.id.editTextDiameter);
    textViewResult = findViewById(R.id.textViewResult);

    Button buttonReset = findViewById(R.id.buttonReset);
    buttonReset.setOnClickListener(view -> reset());

    Button buttonCalculate = findViewById(R.id.buttonCalculate);
    buttonCalculate.setOnClickListener(view -> calculate());
  }

  private void reset() {

  }

  private void calculate() {

  }
}
