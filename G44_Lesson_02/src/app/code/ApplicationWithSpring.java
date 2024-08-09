package app.code;

import app.staff.administration.Director;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ApplicationWithSpring {

    public static void main(String[] args) {

        // Запуск приложения со Spring-ом


        // Получаем объект контекста
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext("app.config");

        // Из контекста получаем директора
        Director director = context.getBean(Director.class);


        director.manageCompany();


    }
}
