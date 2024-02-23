package com.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roll_no;
	private String name;
	private float percentage;
	private String branch;
	
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
				+ "]";
	}
	public Student() {
		super();
	}
	public Student(int roll_no, String name, float percentage, String branch) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
	}
	
	

}
