package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPassword;
    private RadioGroup radioGroupVisibility;
    private RadioButton radioShowSymbols;
    private RadioButton radioShowAsterisks;
    private Button buttonOk;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPassword = findViewById(R.id.editTextPassword);
        radioGroupVisibility = findViewById(R.id.radioGroupVisibility);
        radioShowSymbols = findViewById(R.id.radioShowSymbols);
        radioShowAsterisks = findViewById(R.id.radioShowAsterisks);
        buttonOk = findViewById(R.id.buttonOk);
        textViewResult = findViewById(R.id.textViewResult);

        radioShowAsterisks.setChecked(true);
        editTextPassword.setInputType(
                InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
        );

        radioGroupVisibility.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == R.id.radioShowSymbols) {
                            editTextPassword.setInputType(
                                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                            );
                        } else if (checkedId == R.id.radioShowAsterisks) {
                            editTextPassword.setInputType(
                                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                            );
                        }
                        editTextPassword.setSelection(editTextPassword.getText().length());
                    }
                }
        );

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editTextPassword.getText().toString().trim();

                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            R.string.toast_fill_data,
                            Toast.LENGTH_SHORT).show();
                } else {
                    String resultText = getString(R.string.label_result) + " " + password;
                    textViewResult.setText(resultText);
                }
            }
        });
    }
}
