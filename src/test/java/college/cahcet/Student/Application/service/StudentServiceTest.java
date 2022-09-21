package college.cahcet.Student.Application.service;

import college.cahcet.Student.Application.model.Student;
import college.cahcet.Student.Application.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebFluxTest(StudentService.class)
public class StudentServiceTest {

    @MockBean
    private StudentRepository studentRepository;

    @DisplayName("Test to Retrieve All Student List")
    @Test
    public void getAllStudent() {

        Student student = new Student("11","Parvez",99,"Bengaluru");
        when(studentRepository.findAll()).thenReturn(List.of(student));

        List<Student> studentList = studentRepository.findAll();
        Assertions.assertNotNull(studentList);
        verify(studentRepository,times(1)).findAll();
    }
}