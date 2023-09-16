package com.example.calc_scholarship;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    ImageView img1, img2, img3;
    TextView txt1, txt2, txt3, txt4, txt5;
    EditText ed1, ed2, ed3;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img1 = (ImageView) findViewById(R.id.red_circle);
        img2 = (ImageView) findViewById(R.id.blue_circle);
        img3 = (ImageView) findViewById(R.id.zhake);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.fullname);

        ed1 = findViewById(R.id.attendance1);
        ed2 = findViewById(R.id.attendance2);
        ed3 = findViewById(R.id.stname);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            String resId = bundle.getString("resId");
//            if (resId.equals("IITU")) {
//                img3.setImageResource(R.drawable.iitu);
//            } else if (resId.equals("KBTU")) {
//                img3.setImageResource(R.drawable.kbtu_logo);
//            } else if( resId.equals("SDU")) {
//                img3.setImageResource(R.drawable.sdu_logo);
//            }
//        }

        Intent intent = getIntent();

        String name = intent.getStringExtra("resId");

        txt5.setText(name);

        if (name.equals("IITU")) {
            img3.setImageResource(R.drawable.iitu);
        } else if (name.equals("KBTU")) {
            img3.setImageResource(R.drawable.kbtu_logo);
        } else if (name.equals("SDU")) {
            img3.setImageResource(R.drawable.sdu_logo);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
    }

    public void calculate() {

        try {
            String fullname;
            Double first, second, total, grant, scholarship, value1, value2, value3, value4;

            fullname = ed3.getText().toString();

            txt5.setText(fullname);

            first = Double.parseDouble(ed1.getText().toString());
            second = Double.parseDouble(ed2.getText().toString());

            if (first > 100) {
                ed1.setError("The number must be between 1 and 100");
            }

            if (second > 100) {
                ed2.setError("The number must be between 1 and 100");
            }

            value4 = first + second;

            if (value4.floatValue() >= 100) {

                txt1.setText(50 + "% на файнале");

                total = ((first * 0.3) + (second * 0.3));

                value1 = 70.0;

                scholarship = value1 - total;

                grant = scholarship * 2.5;

                if (grant >= 0 && grant <= 50) {
                    txt2.setText(50 + "% на файнале");
                } else {
                    txt2.setText(grant.floatValue() + "% на файнале");
                }

                value2 = 90.0;

                scholarship = value2 - total;

                grant = scholarship * 2.5;

                if (grant <= 100) {
                    txt3.setText(grant.floatValue() + "% на файнале");
                } else {
                    txt3.setText("Невозможно получить");
                }

                value3 = total + 40;
                txt4.setText(value3.floatValue() + "%");
            } else {
                if (first < 50) {
                    ed1.setError("У вас слишком мало баллов по мид термам," + " вы не допускаетесь на файнал");
                }
                if (second < 50) {
                    ed2.setError("У вас слишком мало баллов по мид термам," + " вы не допускаетесь на файнал");
                }
            }
        } catch (NumberFormatException e) {
            String fullname;

            fullname = ed1.getText().toString();

            if (fullname.isEmpty()) {
                ed1.setError("Введите баллы за 1-уя половину семестра (1st Attestation): ");
            } else ed2.setError("Введите баллы за 2-уя половину семестра (2nd Attestation): ");
            //Toast toast = Toast.makeText(this, "Hello Android!", Toast.LENGTH_LONG);
            //toast.show();
        }
    }

    public void clear() {
        ed1.setText("");
        ed1.setError(null);
        ed2.setText("");
        ed2.setError(null);
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        ed1.requestFocus();
    }
}