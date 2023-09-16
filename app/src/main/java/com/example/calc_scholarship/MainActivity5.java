package com.example.calc_scholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    Spinner spinner;
    ImageView imageView;
    TextView txt8;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.image5);
        btn = findViewById(R.id.btnSend);
        txt8 = findViewById(R.id.text8);

        final String str[] = {"IITU", "KBTU", "SDU"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity5.this, android.R.layout.simple_dropdown_item_1line, str);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (str[0].equals(spinner.getItemAtPosition(i).toString())) {
                    txt8.setText("IITU");
                    imageView.setImageResource(R.drawable.img1);
                } else if (str[1].equals(spinner.getItemAtPosition(i).toString())) {
                    txt8.setText("KBTU");
                    imageView.setImageResource(R.drawable.img2);
                } else if (str[2].equals(spinner.getItemAtPosition(i).toString())) {
                    txt8.setText("SDU");
                    imageView.setImageResource(R.drawable.img3);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                intent.putExtra("resId", txt8.getText().toString());
                startActivity(intent);
            }
        });
    }
//    public void SendImage(View view) {
//        Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
//        intent.putExtra("resId", R.drawable.kbtu_logo);
//        startActivity(intent);
//    }
}