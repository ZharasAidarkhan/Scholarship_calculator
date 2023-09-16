package com.example.calc_scholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView txt8;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        txt8 = findViewById(R.id.text8);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        final String str[] = {"IITU", "KBTU", "SDU", "Aues", "KAZNPU", "AITU", "KAZNPU", "AITU", "KAZNPU", "AITU", "KAZNPU", "AITU", "KAZNPU", "AITU", "KAZNPU", "AITU", "KAZNPU", "AITU", "KAZNPU", "AITU"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_dropdown_item_1line, str);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (str[0].equals(spinner.getItemAtPosition(i).toString())) {
                    txt8.setText("IITU");
                } else if (str[1].equals(spinner.getItemAtPosition(i).toString())) {
                    txt8.setText("KBTU");
                } else if (str[2].equals(spinner.getItemAtPosition(i).toString())) {
                    txt8.setText("SDU");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("resId", txt8.getText().toString());
                startActivity(intent);
            }
        });
    }
}