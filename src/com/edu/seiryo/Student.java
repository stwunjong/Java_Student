package com.edu.seiryo;

public class Student {
	// 学生の番号
	int id;
	// 学生の名前
	String name;
	// 学生のジェンダー
	String gender;
	//学生年龄
	int age;
	//班级编号
	String classNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public Student(int id, String name, String gender, int age, String classNumber) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.classNumber = classNumber;
	}
	public Student() {
		super();
	}
	
}
