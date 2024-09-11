package com.cor;
import java.util.Scanner;

public class Client {

    Validator validator;
    Scanner input = new Scanner(System.in);
    String response;
    String debug = "False";
    Boolean loggedIn = false;

    public Client(){}

    public void setter(Validator validator){
        this.validator = validator;
    }

    public void waitInput(String message){
        System.out.println(message);
        response = input.nextLine();
        validator.responseEndpoint(response);
    }

    public void login(){
        loggedIn = true;
    }
}
