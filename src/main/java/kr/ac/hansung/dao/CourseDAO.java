package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	//query and return a single object
	public Course getCourse(String name) {
		String sqlStatement="select * from courses where name=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, new RowMapper<Course>(){
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course=new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCourseCode(rs.getString("courseCode"));
				course.setCourseName(rs.getString("courseName"));
				course.setClassify(rs.getString("classify"));
				course.setGrade(rs.getInt("grade"));
				return course;
			}
			
		});
	}
	//query and return multiple objects
		public List<Course> getCourses() {
			String sqlStatement="select * from courses";
			return jdbcTemplate.query(sqlStatement, new RowMapper<Course>(){
				@Override
				public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
					Course course=new Course();
					course.setYear(rs.getInt("year"));
					course.setSemester(rs.getInt("semester"));
					course.setCourseCode(rs.getString("courseCode"));
					course.setCourseName(rs.getString("courseName"));
					course.setClassify(rs.getString("classify"));
					course.setGrade(rs.getInt("grade"));
					
					return course;
				}
				
			});
		}
		
		public boolean insert(Course course) {
			int year=course.getYear();
			int semester=course.getSemester();
			String courseCode=course.getCourseCode();
			String courseName=course.getCourseName();
			String classify=course.getClassify();
			int grade=course.getGrade();
			
			String sqlStatement="insert into courses (year, semester, courseCode, courseName, classify, grade) values (?,?,?,?,?,?)";
			
			return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, courseCode, courseName, classify, grade})==1);
		}
		
		public boolean update(Course course) {
			int year=course.getYear();
			int semester=course.getSemester();
			String courseCode=course.getCourseCode();
			String courseName=course.getCourseName();
			String classify=course.getClassify();
			int grade=course.getGrade();
			//sqlStatement 맞는지 모르겠다
			String sqlStatement="update courses set year=?, semester=?, courseCode=?, courseName=?, classify=?, grade=? where year=? and semester=? and courseCode=?";
			
			return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, courseCode, courseName, classify, grade})==1);
		}

		public boolean delete(int id) {
			String sqlStatement="delete from courses where year=? and semester=? and courseCode=?";
			return (jdbcTemplate.update(sqlStatement, new Object[] {id})==1);
		}
}
