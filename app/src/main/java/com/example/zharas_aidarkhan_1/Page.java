package com.example.zharas_aidarkhan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Page extends AppCompatActivity {

    TextView textView;
    ArrayList<String> arrayList;
    Dialog dialog;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        textView = findViewById(R.id.text_view);
        btn = findViewById(R.id.button);

        arrayList = new ArrayList<>();
        arrayList.add("IITU");
        arrayList.add("KBTU");
        arrayList.add("SDU");
        arrayList.add("KAZNU");
        arrayList.add("AITU");
        arrayList.add("AUES");
        arrayList.add("ENU");
        arrayList.add("KAZNPU");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(Page.this);

                dialog.setContentView(R.layout.dialog_seatchable_spinner);

                dialog.getWindow().setLayout(650, 800);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(Page.this, android.R.layout.simple_list_item_1, arrayList);

                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setText(adapter.getItem(i));
                        dialog.dismiss();
                    }
                });
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().toString().isEmpty()) {
                    textView.setError("You need to choose");
                } else {
                    Intent intent = new Intent(Page.this, MainActivity2.class);
                    intent.putExtra("resId", textView.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}