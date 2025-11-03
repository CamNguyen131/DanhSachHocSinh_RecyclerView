package com.example.danhsachhocsinh_recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvName.setText(student.getName());
        holder.tvClass.setText("Lớp: " + student.getStudentClass());

        // Icon theo giới tính
        if (student.getGender().equalsIgnoreCase("Nam")) {
            holder.imgIcon.setImageResource(R.drawable.ic_male);
        } else {
            holder.imgIcon.setImageResource(R.drawable.ic_female);
        }

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context,
                        "Điểm của " + student.getName() + ": " + student.getScore(),
                        Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        notifyItemInserted(studentList.size() - 1);
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvClass;
        ImageView imgIcon;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvClass = itemView.findViewById(R.id.tvClass);
            imgIcon = itemView.findViewById(R.id.imgIcon);
        }
    }
}
