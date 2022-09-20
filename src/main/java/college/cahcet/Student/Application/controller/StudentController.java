package college.cahcet.Student.Application.controller;

import college.cahcet.Student.Application.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/student")
@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/allstudents")
    public ResponseEntity<List<?>> getAllStudents() {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(studentService.getAllStudents());
        }
        catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}