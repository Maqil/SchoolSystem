package com.school;

import com.school.entities.Professor;
import com.school.entities.Todo;
import com.school.repository.ProfessorRepository;
import com.school.repository.StudentRepository;
import com.school.entities.Student;
import com.school.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Professor p1 = professorRepository.save(new Professor(null, "John smith", "John@gmail.com", "+2125445", null));
        Professor p2 = professorRepository.save(new Professor(null, "aicha curry", "curry@gmail.com", "+2125445", null));
        Professor p3 = professorRepository.save(new Professor(null, "steve harr", "harr@gmail.com", "+2125445", null));

        Todo t1 = todoRepository.save(new Todo(null, "Read 5 pages",  p1));
        Todo t2 = todoRepository.save(new Todo(null, "Read 6 pages",  p2));
        Todo t3 = todoRepository.save(new Todo(null, "Read 8 pages", p3));
        Todo t4 = todoRepository.save(new Todo(null, "Read 5 pages",  p1));

        List<Todo> list = new ArrayList<Todo>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        Student s1 = studentRepository.save(new Student(null, "Ziyad Maqil", "ziyad@gmail.com", "+2124545",list));
        studentRepository.save(new Student(null, "Noah Harari", "noad@gmail.com", "+212423",list));
        studentRepository.save(new Student(null, "James Time", "jame@gmail.com", "+2125445",list));

        System.out.println(s1.toString());


    }
}
