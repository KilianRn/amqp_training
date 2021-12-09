package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String args[]){
        AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(Launcher.class);
        Scanner scanner = new Scanner(System.in);
        RabbitTemplate rabbit = annotation.getBean(RabbitTemplate.class);
        String lu;
        do {
            System.out.println("Input a message, we will send it for you (q to quit)");
            lu=scanner.nextLine();

            if(!lu.equals("q")) {
                rabbit.convertAndSend("", "chat_messages", lu);
                System.out.print("Message sent.");
            }
        }while(!lu.equals("q") );
        System.out.println("You are leaving...");
    }

}

