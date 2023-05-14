package com.example.SpringReact.student;

import com.example.SpringReact.exception.BadRequestException;
import com.example.SpringReact.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public List<Student> getAllStudents()
  {
    return studentRepository.findAll();
  }
  public void addStudent(Student student){
    //check if email is taken
    if(studentRepository.findByEmail(student.getEmail()) != null)
      {
        System.out.println("Student already exist from addStudent method");
        throw new BadRequestException("Student already exist.");
      }
    throw new BadRequestException("Student already exist.");
    // studentRepository.save(student);
    }
  public void deleteStudent(Long studentId){
    //check if student exist
    if(!studentRepository.existsById(studentId))
    {
      throw new StudentNotFoundException("Student with id: "+studentId+" does not exist.");
    }

    studentRepository.deleteById(studentId);}
}
