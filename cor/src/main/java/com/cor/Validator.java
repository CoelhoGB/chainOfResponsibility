package com.cor;

import java.util.regex.Pattern;

public class Validator {
        private enum Behaviors{
            init(0),
            response(1),
            email(2),
            password(3),
            debug(4);

            private final int value;

            Behaviors(int value) {
                this.value = value;
            }
    
            public int getValue() {
                return value;
            }

            public static Behaviors getBehaviour(int value) {
                for (Behaviors behavior : Behaviors.values()) {
                    if (behavior.getValue() == value) {
                        return behavior;
                    }
                }
                return debug;
            }
        }


    Pattern emailPat = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    Pattern passwordPat = Pattern.compile("^[A-Za-z\\d@$!%*?&]{8,}$");
    Pattern truePat = Pattern.compile("^(?i)(Sim|S)$");
    Pattern falsePat = Pattern.compile("^(?i)(Nao|N)$");
    Logger logger;
    LoginAuth loginAuth;
    Behaviors mode = Behaviors.getBehaviour(0);

    public Validator(){}

    public Validator(Logger logger, LoginAuth loginAuth){
        this.loginAuth = loginAuth;
        this.logger = logger;
    }

    public String setMode(int behaviour){
        mode = Behaviors.getBehaviour(behaviour);
        return "Validator mode set: " + mode;
    }

    public void responseEndpoint(String response){
        switch (mode) {
            case Behaviors.init:
                System.out.println("Validator is Initialized");
                break;

            case Behaviors.response:
                if(truePat.matcher(response).matches()){
                    
                }
                else if(falsePat.matcher(response).matches()){

                }
                break;

            case Behaviors.email:
                if(emailPat.matcher(response).matches()){

                }
                break;

            case Behaviors.password:
                if(passwordPat.matcher(response).matches()){

                }
                break;

            case Behaviors.debug:
            System.out.println("Validator is debugging");
                break;
        }
    }
}
