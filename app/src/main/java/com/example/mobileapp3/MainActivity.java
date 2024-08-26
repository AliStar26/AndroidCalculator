package com.example.mobileapp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumber1, secondNumber2;
    private TextView resText;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstNumber1 = findViewById(R.id.firstNumber1);
        secondNumber2 = findViewById(R.id.secondNumber2);
        resText = findViewById(R.id.res);

    }

    public void clickAdd(View view){
        operations('+');
    }
    public void clickSub(View view){
        operations('-');
    }
    public void clickMul(View view){
        operations('*');
    }
    public void clickDiv(View view){
        operations('/');
    }


    private void operations(char operator) {
        String numOne = firstNumber1.getText().toString();
        String numTwo = secondNumber2.getText().toString();

        double num1 = Double.parseDouble(numOne);
        double num2 = Double.parseDouble(numTwo);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Деление на ноль нельзя", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        resText.setText("Результат: " + result);
    }
}