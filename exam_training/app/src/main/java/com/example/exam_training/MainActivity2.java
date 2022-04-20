package com.example.exam_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onStart() {
        Log.i(getText(R.string.TAG).toString(), "User went through onStart() on MainActivity2");
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText inputFirstName = findViewById(R.id.editFirstName);
        EditText inputLastName = findViewById(R.id.editLastName);
        EditText inputSpecialty = findViewById(R.id.editSpecialty);
        EditText inputCourse = findViewById(R.id.editCourse);
        EditText inputEmail = findViewById(R.id.editEmail);

        Button backButton = findViewById(R.id.backButton);
        Button nextButton = findViewById(R.id.nextButton);

        TextView textView = findViewById(R.id.facNumView);

        String fn = getIntent().getStringExtra("fn");
        textView.setText(fn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag1 = false,
                        flag2 = false,
                        flag3 = false,
                        flag4 = false,
                        flag5 = false;
                String firstName = inputFirstName.getText().toString();
                String lastName = inputLastName.getText().toString();
                String specialty =  inputSpecialty.getText().toString();
                String course = inputCourse.getText().toString();
                String email = inputEmail.getText().toString();

                if(firstName.length() > 2 && firstName.length() < 100){
                    flag1 = true;
                } else {
                    inputFirstName.setError(getText(R.string.firstname_error));
                }
                if(lastName.length() > 2 && lastName.length() < 100){
                    flag2 = true;
                } else {
                    inputLastName.setError(getText(R.string.lastname_error));
                }
                if(specialty.length() > 2 && specialty.length() < 10 && specialty.equals(specialty.toUpperCase())){
                    flag3 = true;
                } else {
                    inputSpecialty.setError(getText(R.string.specialty_error));
                }
                //boolean isNumeric = course.chars().allMatch( Character::isDigit );
                int num = Integer.parseInt(course);
                if(num >= 1 && num <= 5){
                    flag4 = true;
                } else {
                    inputCourse.setError(getText(R.string.course_error));
                }
                String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
                Pattern emailPattern = Pattern.compile(regex);
                Matcher emailMatcher = emailPattern.matcher(email);
                if (emailMatcher.matches() && email.endsWith("@tu-varna.bg")){
                    flag5 = true;
                } else {
                    inputEmail.setError(getText(R.string.email_error));
                }

                if (flag1 && flag2 && flag3 && flag4 && flag5){
                    Model model = new Model(fn, firstName, lastName, specialty, course, email);
                    Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent1.putExtra("model", model);
                    startActivity(intent1);
                }
            }
        });
    }
}