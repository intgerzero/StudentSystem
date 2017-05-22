package com.studentSystem;

public class Course {
	private String CourseNo;
    private String CourseName;
    private float StudyTime;
    private float Grade;
    private float Term;
    private String WhentoStudy;
    public String getCourseNo() {
		return CourseNo;
	}
	public void setCourseNo(String courseNo) {
		CourseNo = courseNo;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public float getStudyTime() {
		return StudyTime;
	}
	public void setStudyTime(float studyTime) {
		StudyTime = studyTime;
	}
	public float getGrade() {
		return Grade;
	}
	public void setGrade(float grade) {
		Grade = grade;
	}
	public float getTerm() {
		return Term;
	}
	public void setTerm(float term) {
		Term = term;
	}
	public String getWhentoStudy() {
		return WhentoStudy;
	}
	public void setWhentoStudy(String whentoStudy) {
		WhentoStudy = whentoStudy;
	}
	public float getResult() {
		return Result;
	}
	public void setResult(float result) {
		Result = result;
	}
	public int getStudentSum() {
		return StudentSum;
	}
	public void setStudentSum(int studentSum) {
		StudentSum = studentSum;
	}
	public String getTeachername() {
		return Teachername;
	}
	public void setTeachername(String teachername) {
		Teachername = teachername;
	}
	private float Result;
    private int StudentSum;
    private String Teachername;
}
