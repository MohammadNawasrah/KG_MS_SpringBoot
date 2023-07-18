package com.KG.KGMS.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public List<Student> findAllByTeacherId(Long teacherId) {
        return studentRepository.findAllByTeacherId(teacherId);
    }

    public int getCountOfStudent() {
        return getAllStudents().size();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void updateTeacherId(Long studentId, Long newTeacherId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null && student.getTeacherId() == null) {
            System.out.println(student.getStudentName());
            student.setTeacherId(newTeacherId);
            studentRepository.save(student);
        }
    }
}
