package dasturlash.uz;

import dasturlash.uz.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main { // Autowiring
    public static void main(String[] args) {
        // login: adminjon
        // pswd:  12345
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        MainController mainController = (MainController) context.getBean("mainController");
        mainController.start();
    }

}