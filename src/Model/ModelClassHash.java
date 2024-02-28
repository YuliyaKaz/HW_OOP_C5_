package Model;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;
import View.ViewGenericClass;

public class ModelClassHash implements iGetModel {
    private Map<Integer,Student> studentStorage = new HashMap<Integer,Student>();
    private static int cnt = 0;

    @Override
    public List<Student> getAllStudents() {
        List<Student> listStudents = new ArrayList<Student>();
        for (Integer id : studentStorage.keySet()){
            listStudents.add(studentStorage.get(id));
        }
        return listStudents;
    }
    public void addStudentsList(List<Student> listStudents){
        for (Student student : listStudents) {
              cnt++;
              studentStorage.put(cnt,student);
        }
    }
    public void getStudentsFromFile(String filename){
        FileModelClass fmClass = new FileModelClass(filename);
        List<Student> listStudent = fmClass.getAllStudents();
        for (Student student : listStudent) {
            cnt++;
            studentStorage.put(cnt,student);   
        }
    }
    @Override
    public void deleteStudent(String sid){
        int id = Integer.valueOf(sid);
        if (id > cnt) {System.out.println(ViewGenericClass.get(ViewGenericClass.INVALID_STUDENT_ID) + id); return; };
        if (studentStorage.get(id) == null) {System.out.println(ViewGenericClass.get(ViewGenericClass.STUDENT_ID_DELETED)); return; };
        studentStorage.remove(id);
        System.out.println(ViewGenericClass.get(ViewGenericClass.STUDENT_DELETED) + id );
    }
    

}
