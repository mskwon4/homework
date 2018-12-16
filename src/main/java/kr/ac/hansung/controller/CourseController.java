package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public String showCourses(Model model) {
		List<Course> courses=courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "courses";
	}
	
	@RequestMapping("/createcourse")
	public String createCourse(Model model) {
		model.addAttribute("course", new Course());
		return "createcourse";
	}

	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Course course, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors=result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createcoure";
		}
		courseService.insert(course);
		
		return "coursecreated";
	}
}
