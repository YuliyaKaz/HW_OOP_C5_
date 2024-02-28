package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

public class ViewClassEng extends ViewGenericClass implements iGetView {

    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("--------------------List of students-------------------");
        for(Student s: students)
        {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }

    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
    
}
