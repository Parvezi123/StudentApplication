package college.cahcet.Student.Application.service;

import college.cahcet.Student.Application.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> getAllStudents() {
        return List.of(new Student());
    }
}