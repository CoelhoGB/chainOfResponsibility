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
    Behaviors mode;

    public Validator(){}

    public void setter(Logger logger, LoginAuth loginAuth){
        this.logger = logger;
        this.loginAuth = loginAuth;
    }

    public void setMode(int behaviour){
        mode = Behaviors.getBehaviour(behaviour);
    }

    public void responseEndpoint(String response){
        switch (mode) {
            case Behaviors.init:
                System.out.println("Validator is Initialized");
                break;

            case Behaviors.response:
                if(truePat.matcher(response).matches()){
                    this.setMode(2);
                    logger.createLog(response, Behaviors.response.name(), true);
                }
                else if(falsePat.matcher(response).matches()){
                    this.setMode(2);
                    logger.createLog(response, Behaviors.response.name(), false);
                }
                else{
                    logger.createLog(response, Behaviors.response.name(), false);
                }
                break;

            case Behaviors.email:
                if(emailPat.matcher(response).matches()){
                    this.setMode(3);
                    logger.createLog(response, Behaviors.email.name(), true);
                }
                else{
                    logger.createLog(response, Behaviors.email.name(), false);
                }
                break;

            case Behaviors.password:
                if(passwordPat.matcher(response).matches()){
                    this.setMode(1);
                    logger.createLog(response, Behaviors.password.name(), true);
                }
                else{
                    logger.createLog(response, Behaviors.password.name(), false);
                }
                break;

            case Behaviors.debug:
            System.out.println("Validator is debugging");
                break;
        }
    }
}
