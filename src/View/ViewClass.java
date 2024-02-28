package View;

import java.util.List;
import java.util.Scanner;

import Model.Domain.Student;


public class ViewClass extends ViewGenericClass {

     public void printAllStudents(List<Student> students)
     {
         System.out.println("-------------------" + ViewGenericClass.get(ViewGenericClass.LIST_OF_STUDENTS) + "-------------------");
         for(Student s: students)
         {
             System.out.println(s);
         }
         System.out.println("-------------------------------------------------------");
     }
    
     public String prompt(String msg)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
 }
