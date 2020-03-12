package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Num1, Num2, Operation;
    TextView ResultText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Num1=findViewById(R.id.editText1);
        Num2=findViewById(R.id.editText2);
        Operation=findViewById(R.id.editTextOperation);
        ResultText=findViewById(R.id.textViewResult);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        float num1, num2, result=0;
        if(TextUtils.isEmpty(Num1.getText().toString()) || TextUtils.isEmpty(Num2.getText().toString()) || TextUtils.isEmpty(Operation.getText().toString())){

            Toast toast=Toast.makeText(getApplicationContext(),"Вы забыли ввести данные!", Toast.LENGTH_LONG);
            toast.setMargin(50,50);
            toast.show();
            return;
        }
        num1=Float.parseFloat(Num1.getText().toString());
        num2=Float.parseFloat(Num2.getText().toString());
        String task=Operation.getText().toString();
        switch (task){
            case "+": result=num1+num2; break;
            case "-": result=num1-num2; break;
            case "*": result=num1*num2; break;
            case "/": result=num1/num2; break;
            default: break;
        }
        ResultText.setText(num1+" "+task+" "+num2+"="+result);
    }
}
