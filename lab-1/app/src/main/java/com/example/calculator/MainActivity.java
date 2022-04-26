package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText displayEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        displayEditText = findViewById(R.id.displayEditText);
        displayEditText.setShowSoftInputOnFocus(false);
    }

    private void appendToDisplayText(String string) {
        int cursorPos = displayEditText.getSelectionStart();

        String oldStr = displayEditText.getText().toString();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        displayEditText.setText(String.format("%s%s%s", leftStr, string, rightStr));
        displayEditText.setSelection(cursorPos + string.length());
    }

    public void onButtonClick(View view) {
        Button button = (Button)view;

        String buttonText = button.getText().toString();

        if (button.getTag().toString().equals("trigonometry")) {
            buttonText = buttonText + "(";
        }

        appendToDisplayText(buttonText);
    }

    public void onClearAllButtonClick(View view) {
       displayEditText.setText("");
       previousCalculation.setText("");
    }

    public void onClearOneSymbolButtonClick(View view) {
        int cursorPos = displayEditText.getSelectionStart();
        int textLen = displayEditText.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) displayEditText.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            displayEditText.setText(selection);
            displayEditText.setSelection(cursorPos-1);
        }
    }

    public void onEqualsButtonClick(View view){
        String userExp = displayEditText.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.division), "/");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        displayEditText.setText(result);
        displayEditText.setSelection(result.length());
    }

    public void onArcSinPress(View view){
        appendToDisplayText("arcsin(");
    }

    public void onArcCosPress(View view){
        appendToDisplayText("arccos(");
    }

    public void onArcTanPress(View view){
        appendToDisplayText("arctan(");
    }

    public void onSqrtPress(View view){
        appendToDisplayText("sqrt(");
    }

    public void onAbsPress(View view){
        appendToDisplayText("abs(");
    }

    public void onxSquaredPress(View view){
        appendToDisplayText("^(2)");
    }

    public void onxPowerYPress(View view){
        appendToDisplayText("^(");
    }

    public void onPrimePress(View view){
        appendToDisplayText("ispr(");
    }

    public void onPiPress(View view){
        appendToDisplayText("pi");
    }
}