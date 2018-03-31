package com.example.raushan.factorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText number;
    private TextView textView;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView2);
        calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int num = Integer.parseInt(number.getText().toString());
                double  result = factorial(num);
                if (Double.toString(result).equals("Infinity"))
                {
                    textView.setText("result is out of range");
                }
                else
                    {
                        textView.setText(" " + Double.toString(result));
                        closeKeyboard();
                    }
            }
        });

    }

    private  double factorial(double num)
    {
           if (num < 2)
           {
               return 1;
           }
           else
           {
               return num * factorial(num - 1);
           }

    }

    private void closeKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imn = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imn.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}

