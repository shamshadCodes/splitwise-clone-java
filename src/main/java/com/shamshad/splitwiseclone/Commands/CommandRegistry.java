package com.shamshad.splitwiseclone.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    List<Command> commands;

    @Autowired
    public CommandRegistry(RegisterNewUserCommand registerNewUserCommand) {
        commands = new ArrayList<>();
        commands.add(registerNewUserCommand);
    }

    public void execute(String input) {
        boolean flag = false;
        for(Command command: commands){
            if(command.matches(input)){
                command.execute(input);
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println("Invalid Command. Please try again.");
    }
}
