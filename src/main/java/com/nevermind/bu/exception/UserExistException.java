package com.nevermind.bu.exception;

public class UserExistException extends Exception {
    @Override
    public String getMessage() {
        return "User with this name already exist!";
    }
}
