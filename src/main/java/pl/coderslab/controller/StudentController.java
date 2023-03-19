package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/studentsform")
    String showStudentsForm(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("futball");
        hobbies.add("dancing");
        hobbies.add("singing");
        return hobbies;
    }

}
