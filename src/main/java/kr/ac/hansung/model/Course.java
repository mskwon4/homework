package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	private int year;	//수강년도
	private int semester;	//학기
	private String courseCode;	//교과코드
	
	@Size(min=2, max=100, message="Name must be between 2 and 100 chars")
	private String courseName;	//교과목명
	
	@Size(min=2, max=10, message="Name must be between 2 and 10 chars")
	private String classify;	//구분
	
	private int grade;	//학점

}
