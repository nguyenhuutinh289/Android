package com.example.admin.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    Double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sublayout);

        Bundle getBundle = getIntent().getExtras();


        Double num1 = getBundle.getDouble("num1");
        Double num2 = getBundle.getDouble("num2");

        TextView tvResult = (TextView) findViewById(R.id.result);
        result = num1 + num2;
        tvResult.setText(result.toString());

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private  static Double Count(Double _num1, Double _num2){
        return  _num1 + _num2;
    }

    @Override
    public void finish() {
        Intent resultBack = new Intent();
        resultBack.putExtra("resultBack",result.toString());
        this.setResult(RESULT_OK,resultBack);
        super.finish();
    }
}
