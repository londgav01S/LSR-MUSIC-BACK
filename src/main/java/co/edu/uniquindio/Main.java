package co.edu.uniquindio;

import co.edu.uniquindio.model.Song;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Song cancion = (Song) context.getBean("cancion");
    }
}

