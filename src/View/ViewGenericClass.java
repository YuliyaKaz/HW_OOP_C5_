package View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

public class ViewGenericClass implements iGetView {
    private String lang;
    public static Map<String,String> langCom ;
    public static final String LIST_OF_STUDENTS = "ListOfStudent";
    public static final String LIST_IS_EMPTY = "ListIsEmpty";
    public static final String LANGUAGE_NOT_CHANGED = "LangNotChanged";
    public static final String INVALID_LANGUAGE = "InvalidLang";
    public static final String ENTER_COMMAND = "EnterCommand";
    public static final String EXIT = "Exit";
    public static final String SET_ID_FOR_DELETE = "SetIdForDelete";
    public static final String GET_LANG = "GetLang";
    public static final String INVALID_COMMAND = "InvalidCommand";
    public static final String STUDENT_IS_DELETED = "StudentIsDeleted";
    public static final String STUDENT_ID_DELETED = "StudentIdDeleted";
    public static final String STUDENT_DELETED = "StudentDeleted";
    public static final String INVALID_STUDENT_ID = "InvalidStudentId";
    
    public ViewGenericClass(){
        this.lang = "RU";
        langCom = setLangCom("RU");
    }
    public ViewGenericClass(String lang){
        if (lang == "EN") {
            langCom = setLangCom("EN");
            this.lang = "EN";
            return;
        }
        this.lang = "RU";
        langCom = setLangCom("RU");
    }

    public void printAllStudents(List<Student> students)
    {   String listof = ViewGenericClass.get(LIST_OF_STUDENTS);
        System.out.println(listof);
        System.out.println("-------------------" + ViewGenericClass.get(LIST_OF_STUDENTS) + "--------------------");
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
    public void changeLang(String lang){
        if (this.lang.equals(lang.toUpperCase())) {
            System.out.println(ViewGenericClass.get(ViewGenericClass.LANGUAGE_NOT_CHANGED));
            return;
        }
        switch (lang.toUpperCase()) {
            case "EN":
                this.lang = lang.toUpperCase();
                langCom = setLangCom(this.lang);
                break;
            case "RU":
                this.lang = "RU";
                langCom = setLangCom(this.lang); 
                break;      
            default:
                System.out.println(ViewGenericClass.get(ViewGenericClass.INVALID_LANGUAGE));
        }
    }
    private static Map<String,String> setLangCom(String lang){
        Map<String,String> com = new HashMap<String,String>();
        com.put(LIST_OF_STUDENTS, lang.equals("EN")?"List of students":"Список студентов");
        com.put(LIST_IS_EMPTY, lang.equals("EN")?"List is empty":"Список студентов пуст");
        com.put(ENTER_COMMAND, lang.equals("EN")?"Enter command: ":"Введите команду: ");
        com.put(EXIT, lang.equals("EN")?"Exit program!":"Выход из программы!");
        com.put(SET_ID_FOR_DELETE, lang.equals("EN")?"Set student id for delete: ":"Введите id студента для удаления: ");
        com.put(GET_LANG, lang.equals("EN")?"Select language: ":"Выберите язык: ");
        com.put(INVALID_COMMAND, lang.equals("EN")?"This command not exist ":"Команды не существует: ");
        com.put(STUDENT_IS_DELETED, lang.equals("EN")?"Student is deleted ":"Студент удален ");
        com.put(STUDENT_ID_DELETED, lang.equals("EN")?"Student already is deleted ":"Студен с таким id уже был удален ");
        com.put(STUDENT_DELETED, lang.equals("EN")?"Deleted student with id ":"Студент удален с id = ");
        com.put(INVALID_STUDENT_ID, lang.equals("EN")?"Student not exist with id = ":"Студент не существует с id: ");
        com.put(LANGUAGE_NOT_CHANGED, lang.equals("EN")?"Language is not changed ":"Язык не изменен ");
        com.put(INVALID_LANGUAGE, lang.equals("EN")?"Invalid Language ":"Такой язык не предусмотрен ");
        return com;
    };
    public static String get(String sid){
        return ViewGenericClass.langCom.get(sid);
    }
    
    
}
