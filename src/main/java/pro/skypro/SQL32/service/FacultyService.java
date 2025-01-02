package pro.skypro.SQL32.service;

import pro.skypro.SQL32.model.Faculty;

import java.util.Collection;

public interface FacultyService {

    long add(Faculty faculty);

    Faculty update(Long id, Faculty faculty);

    Faculty deleteById(Long id);

    Faculty findById(Long id);

    Collection<Faculty> findAll();

    Collection<Faculty> findByColor(String color);

}
