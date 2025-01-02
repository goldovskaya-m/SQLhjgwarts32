package pro.skypro.SQL32.service;

import pro.skypro.SQL32.model.Student;

import java.util.Collection;

public interface StudentService {

    long add(Student student);

    Student update(Long id, Student faculty);

    Student deleteById(Long id);

    Student findById(Long id);

    Collection<Student> FindAll();

    Collection<Student> FindByAge(int age);
}
