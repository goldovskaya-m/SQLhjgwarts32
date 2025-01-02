package pro.skypro.SQL32.service;

import org.springframework.stereotype.Service;
import pro.skypro.SQL32.model.Faculty;
import pro.skypro.SQL32.model.exception.FacultyNotFoundException;
import pro.skypro.SQL32.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> repository = new HashMap<>();
    private long counter = 0;
    private final FacultyRepository facultyRepository;
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public long add(Faculty faculty) {
        return facultyRepository.save(faculty).getId();

    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        checkFacultyExist(id);
        return repository.put(id, faculty);
    }

    @Override
    public Faculty deleteById(Long id) {
        checkFacultyExist(id);
        return repository.remove(id);

    }
    @Override
    public Faculty findById(Long id){
        return repository.get(id);

    }

    @Override
    public Collection<Faculty> findAll() {
        return Collections.unmodifiableCollection
                (repository.values());

    }

   @Override
    public Collection<Faculty> findByColor(String color) {
        return repository.values().stream()
                .filter(st-> Objects.equals(st.getColor(), color))
                .toList();
    }

    private void checkFacultyExist(Long id) {
        if (!repository.containsKey(id)) {
            throw new FacultyNotFoundException(id);

        }
    }
}
