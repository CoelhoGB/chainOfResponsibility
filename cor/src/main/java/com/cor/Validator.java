package com.cor;

public class Validator {
    private enum mode{
        response,
        email,
        password
    }

    Logger logger;

    public Validator(Logger logger){
        this.logger = logger;
    }
}
