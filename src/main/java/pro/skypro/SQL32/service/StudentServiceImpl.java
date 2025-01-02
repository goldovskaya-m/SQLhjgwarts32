package pro.skypro.SQL32.service;

import org.springframework.stereotype.Service;
import pro.skypro.SQL32.model.Student;
import pro.skypro.SQL32.model.exception.StudentNotFoundException;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> repository = new HashMap<>();
    private long counter = 0;

    @Override
    public long add(Student student) {
        student.setId(++counter);
        repository.put(counter, student);
        return counter;

    }

    @Override
    public Student update(Long id, Student student) {
        checkStudentExist(id);
        Student studentForUpdate = repository.get(id);


        return repository.put(id, student);

    }

    @Override
    public Student deleteById(Long id) {
        checkStudentExist(id);
        //Student studentForUpdate = repository.get(id);
        return repository.remove(id);

    }

    @Override
    public Student findById(Long id) {
        return repository.get(id);

    }

    // @Override
    //public Collection<Student> FindAll() {
    //    return List.of();
    // }

    @Override
    public Collection<Student> FindAll() {
        return Collections.unmodifiableCollection
                (repository.values());

    }

    @Override
    public Collection<Student> FindByAge(int age) {
        return repository.values().stream().filter(st -> st.getAge() == age).toList();

    }

    private void checkStudentExist(Long id) {
        if (!repository.containsKey(id)) {
            throw new StudentNotFoundException(id);

        }
    }
}
