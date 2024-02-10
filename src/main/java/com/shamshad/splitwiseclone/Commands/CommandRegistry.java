package com.shamshad.splitwiseclone.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    List<Command> commands;

    @Autowired
    public CommandRegistry(RegisterCommand registerCommand) {
        commands = new ArrayList<>();
        commands.add(registerCommand);
    }

    public void execute(String input){
        for(Command command: commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
