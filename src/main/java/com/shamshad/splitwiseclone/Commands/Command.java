package com.shamshad.splitwiseclone.Commands;

public interface Command {
    boolean matches(String input);
    public void execute(String input);
}
