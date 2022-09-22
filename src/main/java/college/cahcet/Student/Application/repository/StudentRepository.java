package college.cahcet.Student.Application.repository;

import college.cahcet.Student.Application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    @Override
    List<Student> findAll();
}