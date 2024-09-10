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
    Client client;

    public Validator(){}

    public void setter(Logger logger, LoginAuth loginAuth, Client client){
        this.logger = logger;
        this.loginAuth = loginAuth;
        this.client = client;
    }

    public void setMode(int behaviour){
        mode = Behaviors.getBehaviour(behaviour);
    }

    public void responseEndpoint(String response){
        switch (mode) {
            case Behaviors.init:
                break;

            case Behaviors.response:
                if(truePat.matcher(response).matches()){
                    this.setMode(2);
                    logger.createLog(response, Behaviors.response.name(), true);
                    client.waitInput("Insira o seu email.");
                }
                else if(falsePat.matcher(response).matches()){
                    this.setMode(2);
                    logger.createLog(response, Behaviors.response.name(), false);
                    client.waitInput("Insira o email que deseja utilizar para sua conta.\nPadrão: 'nome@provedor.com'");
                }
                else{
                    logger.createLog(response, Behaviors.response.name(), false);
                    client.waitInput("Por favor, responda novamente com Sim/S ou Nao/N.");
                }
                break;

            case Behaviors.email:
                if(emailPat.matcher(response).matches()){
                    this.setMode(3);
                    logger.createLog(response, Behaviors.email.name(), true);
                    client.waitInput("Insira a sua senha com no mínimo 8 caracteres, compostos de letras, números ou caracteres especiais(@$!%*?&).");
                }
                else{
                    logger.createLog(response, Behaviors.email.name(), false);
                    client.waitInput("Formato de email inválido. Siga o padrão 'nome@provedor.com");
                }
                break;

            case Behaviors.password:
                if(passwordPat.matcher(response).matches()){
                    this.setMode(1);
                    logger.createLog(response, Behaviors.password.name(), true);
                }
                else{
                    logger.createLog(response, Behaviors.password.name(), false);
                    client.waitInput("Formato inválido, a senha deve ter letras, números ou caracteres especiais(@$!%*?&), e no mínimo 8 caracteres.");
                }
                break;

            case Behaviors.debug:
                break;
        }
    }
}
