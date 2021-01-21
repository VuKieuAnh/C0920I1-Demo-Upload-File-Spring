package controller;

import model.Student;
import model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.student.IStudentSevice;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentSevice studentSevice;

    @Autowired
    private Environment environment;

    @GetMapping()
    public ModelAndView index(){
        ModelAndView index = new ModelAndView("index");
        index.addObject("list", studentSevice.findAll());
        return index;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView create = new ModelAndView("create", "s", new StudentForm());
        return create;
    }

    @PostMapping("/create")
    public ModelAndView creatNewStudent(@ModelAttribute StudentForm s) throws IOException {
        ModelAndView modelAndView = new ModelAndView("create");
        MultipartFile file = s.getAvatar();

        String avatar = file.getOriginalFilename();
        String thu_muc = environment.getProperty("file_upload").toString();
        FileCopyUtils.copy(file.getBytes(), new File(thu_muc+avatar));

        Student s1 = new Student(s.getName(), s.getAddress(), avatar);
        studentSevice.save(s1);
        modelAndView.addObject( "s",new StudentForm() );
        modelAndView.addObject( "mess","Thanh cong");
        return modelAndView;

    }
}