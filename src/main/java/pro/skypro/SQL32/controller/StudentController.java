package pro.skypro.SQL32.controller;

import org.springframework.web.bind.annotation.*;
import pro.skypro.SQL32.model.Student;
import pro.skypro.SQL32.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }
    @PostMapping("/add")
    public long add(@RequestBody Student student) {
        return studentService.add(student);

    }
    @PutMapping("/{id}/update")
    public Student update(@PathVariable("id") Long id,
                          @RequestBody Student student) {
        return  studentService.update(id, student);

    }
    @DeleteMapping("/{id}/remove")
    public Student deleteById(@PathVariable("id") Long id) {
        return studentService.deleteById(id);

    }
    @GetMapping("/{id}/get")
    public Student findBiId(@PathVariable("id") Long id) {
        return studentService.findById(id);

    }
    @GetMapping("/get/all")
    public Collection<Student> FindAll() {
        return studentService.FindAll();

    }
    @GetMapping("/get/by-age")
    public Collection<Student> FindByAge(@RequestParam("age") int age) {
        return studentService.FindByAge(age);

    }
}
