package service.student;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentSevice {

    private static Map<Long, Student> listStudent;
    static {
        listStudent = new HashMap<>();
        listStudent.put(1L, new Student(1l, "Thành", "Hà Nội"));
        listStudent.put(2L, new Student(2l, "Tuấn Anh", "Hà Đông"));
        listStudent.put(3L, new Student(3l, "Tú", "Hải Dương"));
        listStudent.put(4L, new Student(4l, "Dũng", "Hải Phòng"));
    }

    @Override
    public List<Student> findAll() {
        ArrayList list = new ArrayList(listStudent.values());
//        return (ArrayList)listStudent.values();
        return list;
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public void update(Student model) {

    }

    @Override
    public void save(Student model) {
        Long stt = listStudent.size() + 1L;
        model.setId(stt);
        listStudent.put(stt, model);
    }

    @Override
    public void remove(Long id) {

    }
}