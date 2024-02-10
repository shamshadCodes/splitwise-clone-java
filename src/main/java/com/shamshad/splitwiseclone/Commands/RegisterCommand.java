package com.shamshad.splitwiseclone.Commands;

import java.util.Arrays;
import java.util.List;

public class RegisterCommand implements Command{
//    Sample Command
//    Register vinsmokesanji 003 namisswwaann
//    u1 is registering with the username "vinsmokesanji", phone "003" and password as "namisswwaann"

    @Override
    public boolean matches(String input) {
        //TODO: Apply a check for leading zeroes or more than one zero between words
        List<String> inputKeywords = Arrays.stream(input.split(" ")).toList();

        if(inputKeywords.size() == 4 && inputKeywords.get(0).equals(CommandKeywords.REGISTER_NEW_USER)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        //TODO: Apply a check for leading zeroes or more than one zero between words
        List<String> inputKeywords = Arrays.stream(input.split(" ")).toList();

        String username = inputKeywords.get(1);
        String userId = inputKeywords.get(2);
        String password = inputKeywords.get(3);


    }
}
