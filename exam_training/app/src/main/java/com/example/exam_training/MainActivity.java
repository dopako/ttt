package com.example.exam_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText facultyNumber = findViewById(R.id.editFN);
        Button next = findViewById(R.id.button);

        facultyNumber.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                String fn = facultyNumber.getText().toString();
                if (fn.length() != 10){
                    facultyNumber.setError(getString(R.string.fn_error));
                } else {
                    next.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getText(R.string.TAG).toString(), "next button clicked MainActivity");
                String fn = facultyNumber.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("fn", fn);
                startActivity(intent);
            }
        });
    }
}