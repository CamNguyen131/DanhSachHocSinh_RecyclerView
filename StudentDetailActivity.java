package com.example.danhsachhocsinh_recyclerview;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    TextView tvName, tvClass, tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        tvName = findViewById(R.id.tvName);
        tvClass = findViewById(R.id.tvClass);
        tvScore = findViewById(R.id.tvScore);

        String name = getIntent().getStringExtra("name");
        String className = getIntent().getStringExtra("className");
        double score = getIntent().getDoubleExtra("score", 0);

        tvName.setText("Tên: " + name);
        tvClass.setText("Lớp: " + className);
        tvScore.setText("Điểm trung bình: " + score);
    }
}
