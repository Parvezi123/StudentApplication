package college.cahcet.Student.Application.controller;

import college.cahcet.Student.Application.model.Student;
import college.cahcet.Student.Application.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;


@AutoConfigureWebTestClient
@WebFluxTest(StudentController.class)
public class StudentControllerTest {


    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private StudentService studentService;


    @Test
    @DisplayName("Test to Retrieve All Students with Status 200")
    public void testAllStudents() {
        Student student1 = new Student("123", "Parvez", 90, "Bengaluru");
        Student student2 = new Student("456", "Alam", 80, "Chennai");

        when(studentService.getAllStudents()).thenReturn(List.of(student1,student2));

         webTestClient.get().uri("/student/allstudents")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()

                .expectStatus().isOk()
                .expectBodyList(Student.class)
                 .hasSize(2);

         verify(studentService,times(1)).getAllStudents();
    }

    @Test
    @DisplayName("Test to Retrieve no Student List")
    public void testNoStudent() {

        when(studentService.getAllStudents()).thenReturn(Collections.emptyList());

        webTestClient.get().uri("/student/allstudents")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()

                .expectStatus().isOk()
                .expectBodyList(Student.class)
                .hasSize(0);
        verify(studentService,times(1)).getAllStudents();
    }

    @Test
    @DisplayName("Test Exception while Retrieving all students")
    public void testExceptionWhileStudentsRetrieval() {

        when(studentService.getAllStudents()).thenThrow(RuntimeException.class);

        webTestClient.get().uri("/student/allstudents")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()

                .expectStatus().is5xxServerError();
        verify(studentService,times(1)).getAllStudents();
    }
}