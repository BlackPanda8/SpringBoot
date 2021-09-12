package com.example;

import com.example.dao.JdbcTemplateDeveloperDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplateDeveloperDaoImpl jdbcTemplateDeveloperDao = (JdbcTemplateDeveloperDaoImpl) context.getBean("jdbcTemplateDeveloperDao");
        for( ; ; ) {
            System.out.println("1.Add a new developer to the database");
            System.out.println("2.Update developer data");
            System.out.println("3.Remove the developer");
            System.out.println("4.All developers");
            System.out.println("5.Exit");
            System.out.print("Select an option:");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number == 5) {
                System.exit(0);
            }
            switch (number) {
                case 1:
                    System.out.println("Write the name of the developer: ");
                    String name = scanner.next();
                    System.out.println("Write developer specialty: ");
                    String specialty = scanner.next();
                    System.out.println("Write the experience of the developer: ");
                    int expirience = scanner.nextInt();
                    jdbcTemplateDeveloperDao.createDeveloper(name, specialty, expirience);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Write the developer ID: ");
                    int idUpDate = scanner.nextInt();
                    System.out.println("write the name of the developer: ");
                    String nameUpDate = scanner.next();
                    System.out.println("Write developer specialty: ");
                    String specialtyUpDate = scanner.next();
                    System.out.println("Write the experience of the developer: ");
                    int expirienceUpDate = scanner.nextInt();
                    jdbcTemplateDeveloperDao.updateDeveloper(idUpDate, nameUpDate, specialtyUpDate, expirienceUpDate);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Write the id of the developer you want to delete: ");
                    int id = scanner.nextInt();
                    jdbcTemplateDeveloperDao.removeDeveloper(id);
                    System.out.println();
                    break;
                case 4:
                    List AllDevelopers = jdbcTemplateDeveloperDao.listDevelopers();
                    for (Object developer : AllDevelopers) {
                        System.out.println(developer);
                    }
                    System.out.println();
                    break;
            }
        }
    }
}