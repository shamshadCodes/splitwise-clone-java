package com.shamshad.splitwiseclone;

import com.shamshad.splitwiseclone.Commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
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
    public void run(String... args) throws Exception {

        while(true){
            System.out.println("Please enter the next command");
            String input = scanner.nextLine();

            commandRegistry.execute(input);
        }
    }
}
