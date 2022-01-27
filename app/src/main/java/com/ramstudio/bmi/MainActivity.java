package com.ramstudio.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button cal,next;
    EditText wt,ht;
    TextView rs1,rs2;

    float weight,hight,result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal=findViewById(R.id.btncal);
        wt=findViewById(R.id.weight);
        ht=findViewById(R.id.hight);
        rs1=findViewById(R.id.txtresult1);
        rs2=findViewById(R.id.txtresult2);
        next=findViewById(R.id.btnnext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cal=new Intent(MainActivity.this,calculator.class);
                startActivity(cal);
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                weight = Float.parseFloat(wt.getText().toString());
                hight = Float.parseFloat(ht.getText().toString());

                result = weight / (hight * hight);
                rs1.setText(String.valueOf(result));

                if (result >= 25) {
                    rs2.setText("fact");
                } else if (result <= 18) {
                    rs1.setText("Thin");
                } else {
                    rs1.setText("Normal");
                }
            }
        });
    }
}