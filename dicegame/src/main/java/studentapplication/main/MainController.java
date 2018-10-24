package studentapplication.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainController {

    public MainController(int choice) {
        Ui ui = new Ui();
        ui.askInfo();

        if(choice ==1) {

        }else if(choice==2){
            ui.showStudentInfo();
        }
    }

    public void result(){

    }


    ApplicationContext context
            = new ClassPathXmlApplicationContext("student.xml");


}
