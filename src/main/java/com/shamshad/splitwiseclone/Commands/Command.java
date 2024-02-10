package com.shamshad.splitwiseclone.Commands;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
