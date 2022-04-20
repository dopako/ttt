package com.example.exam_training;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView facNum = findViewById(R.id.textViewFN);
        TextView fName = findViewById(R.id.textViewFirstName);
        TextView lName = findViewById(R.id.textViewLastName);
        TextView spec = findViewById(R.id.textViewSpecialty);
        TextView crs = findViewById(R.id.textViewCourse);
        TextView mail = findViewById(R.id.textViewEmail);

        Model model = getIntent().getParcelableExtra("model");

        facNum.setText(model.getFacultyNumber());
        fName.setText(model.getFirstName());
        lName.setText(model.getLastName());
        spec.setText(model.getSpecialty());
        crs.setText(model.getCourse());
        mail.setText(model.getEmail());
    }
}