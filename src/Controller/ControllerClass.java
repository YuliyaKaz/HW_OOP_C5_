package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClass;
import Model.Domain.Student;
import View.ViewClass;
import View.ViewGenericClass;

public class ControllerClass {

    private iGetModel model;
    private iGetView view;
    private List<Student> bufferStudentList = new ArrayList<Student>();

    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    private boolean testData(List<Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() {
        // MVC
        // view.printAllStudent(model.getStudents());

        // MVP
        bufferStudentList = model.getAllStudents();
        if (testData(bufferStudentList)) {
            view.printAllStudents(bufferStudentList);
        } else {
            System.out.println(ViewGenericClass.get(ViewGenericClass.LIST_IS_EMPTY) );
        }
    }

    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            try {
                String command = view.prompt(ViewGenericClass.get(ViewGenericClass.ENTER_COMMAND));
                com = Command.valueOf(command.toUpperCase());
            
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println(ViewGenericClass.get(ViewGenericClass.EXIT));
                    break;
                case LIST:
                    view.printAllStudents(model.getAllStudents());
                    break;
                case DELETE:
                    model.deleteStudent(view.prompt(ViewGenericClass.get(ViewGenericClass.SET_ID_FOR_DELETE)));
                    break; 
                case LANG:
                    view.changeLang(view.prompt(ViewGenericClass.get(ViewGenericClass.GET_LANG)));
                    break;
            }
            } catch (Exception e) {
                System.out.println(ViewGenericClass.get(ViewGenericClass.INVALID_COMMAND));
            }
        }   
    }

}
