package com.shamshad.splitwiseclone;

import com.shamshad.splitwiseclone.Commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseCloneApplication implements CommandLineRunner {
    CommandRegistry commandRegistry;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public SplitwiseCloneApplication(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseCloneApplication.class, args);
    }

    @Override
    public void run(String... args){
        System.out.println("/n**********Application is running**********");
        while(true){
            System.out.print("""
                            Please enter the next command\s
                            ->\s""");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("EXIT")){
                System.out.println("EXITING NOW!");
                break;
            }

            commandRegistry.execute(input);
        }
    }
}
