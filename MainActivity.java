package com.example.danhsachhocsinh_recyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> studentList;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);

        studentList = new ArrayList<>();
        studentList.add(new Student("Nguyễn Thị Cẩm Nguyên", "23T3", 8.5, "Nữ"));
        studentList.add(new Student("Nguyễn Tấn Đức", "21TDH1", 9.2, "Nam"));
        studentList.add(new Student("Ngô Võ Kiều Tâm", "47KT1", 7.3, "Nữ"));
        studentList.add(new Student("Đinh Việt Hoàng", "20SK1", 8.0, "Nam"));
        studentList.add(new Student("Lê Trung Phong", "12A3", 6.5, "Nam"));
        studentList.add(new Student("Trương Thị Thúy Huyền", "22T3", 5.5, "Nữ"));
        studentList.add(new Student("Nguyễn Quang Tuấn", "21DT1", 9.3, "Nam"));
        studentList.add(new Student("Trần Ngọc Gia Hân", "19KT1", 7.0, "Nữ"));
        studentList.add(new Student("Trần Việt Bảo Khánh", "25KT1", 8.6, "Nam"));
        studentList.add(new Student("Lê Tấn Đạt", "45DTVT1", 8.5, "Nam"));

        adapter = new StudentAdapter(this, studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> showAddDialog());
    }


    private void showAddDialog() {
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_student, null);
        EditText edtName = dialogView.findViewById(R.id.edtName);
        EditText edtClass = dialogView.findViewById(R.id.edtClass);
        EditText edtScore = dialogView.findViewById(R.id.edtScore);
        Spinner spGender = dialogView.findViewById(R.id.spGender);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[]{"Nam", "Nữ"});
        spGender.setAdapter(genderAdapter);

        new AlertDialog.Builder(this)
                .setTitle("Thêm học sinh")
                .setView(dialogView)
                .setPositiveButton("Thêm", (dialog, which) -> {
                    String name = edtName.getText().toString().trim();
                    String className = edtClass.getText().toString().trim();
                    String scoreStr = edtScore.getText().toString().trim();
                    String gender = spGender.getSelectedItem().toString();

                    if (!name.isEmpty() && !className.isEmpty() && !scoreStr.isEmpty()) {
                        double score = Double.parseDouble(scoreStr);
                        adapter.addStudent(new Student(name, className, score, gender));
                    } else {
                        Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}
