package com.KG.KGMS.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.KG.KGMS.dateLimit.DateLimitService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final DateLimitService dateLimitService;

    public StudentController(StudentService studentService, DateLimitService dateLimitService) {
        this.studentService = studentService;
        this.dateLimitService = dateLimitService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        student.setStudentType(dateLimitService.checkIfBetweenDate(student.getDateOfBarthday()));
        return studentService.createStudent(student);
    }

    // @PostMapping("/upload")
    // public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile
    // file) {
    // try {
    // Student student = new Student();
    // student.setBirthCertificate(file.getBytes());
    // studentService.createStudent(student);
    // // imageService.saveImage(file.getBytes());
    // return ResponseEntity.ok(file.getBytes().toString());
    // } catch (Exception e) {
    // e.printStackTrace();
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed
    // to upload the image.");
    // }
    // }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setStudentId(id);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
