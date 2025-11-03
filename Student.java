package com.example.danhsachhocsinh_recyclerview;


public class Student {
    private String name;
    private String studentClass;
    private double score;
    private String gender;

    public Student(String name, String studentClass, double score, String gender) {
        this.name = name;
        this.studentClass = studentClass;
        this.score = score;
        this.gender = gender;
    }

    public String getName() { return name; }
    public String getStudentClass() { return studentClass; }
    public double getScore() { return score; }
    public String getGender() { return gender; }
}
