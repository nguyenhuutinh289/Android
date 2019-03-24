package com.example.admin.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  static final int REQUEST_CODE = 1;
    EditText _num1, _num2;
    TextView _resultBack;
    Button _btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        _num1 = (EditText)findViewById(R.id.num1);
        _num2 = (EditText) findViewById(R.id.num2);
        _resultBack = (TextView) findViewById(R.id.resultBack);
        _btnSum = (Button) findViewById(R.id.btnSum);

        _btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle myBundle = new Bundle();

                myBundle.putDouble("num1",Double.parseDouble(_num1.getText().toString()));
                myBundle.putDouble("num2",Double.parseDouble(_num2.getText().toString()));

                Intent myIntent = new Intent(getApplicationContext(),SubActivity.class);
                myIntent.putExtras(myBundle);

                startActivityForResult(myIntent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this._resultBack = (TextView) findViewById(R.id.resultBack);
        if (resultCode == SubActivity.RESULT_OK && requestCode == REQUEST_CODE ) {
            String feedback = data.getStringExtra("resultBack");
            this._resultBack.setText(feedback);
        } else {
            this._resultBack.setText("!?");
        }

    }
}
