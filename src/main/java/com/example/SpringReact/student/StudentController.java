package com.example.SpringReact.student;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping(path="api/v1/students")
public class StudentController {

  private final StudentService studentService;

  @GetMapping
  public List<Student> getAllStudents() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    return studentService.getAllStudents();

  }
 @PostMapping
  public void addStudent(@Valid @RequestBody Student student)
  {
    studentService.addStudent(student);
  }

  @DeleteMapping("{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId)
  {
    studentService.deleteStudent(studentId);
  }
}
