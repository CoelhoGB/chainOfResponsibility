package com.cor;

public class Server 
{

    Client client;
    LoginAuth loginAuth;
    LoginReg loginReg;
    Logger logger;
    Validator validator;

    public Server(){}

    public Server(Client client, LoginAuth loginAuth, LoginReg loginReg, Logger logger, Validator validator){
        this.client = client;
        this.loginAuth = loginAuth;
        this.loginReg = loginReg;
        this.logger = logger;
        this.validator =  validator;
    }

    public void startService(){
        String startMessage = "Bem vindo(a) ao sistema!\nJá és usuário?(Responda Sim/S ou Nao/N)";
        validator.setMode(1);
        client.waitInput(startMessage);
    }

    public void responseError(String result){
        if(result.matches("^rpErr.*")){

        }
        else if(result.matches("^@Err.*")){

        }
        else if(result.matches("^pwErr.*")){

        }
        else{
            System.out.println("Logging Error.");
        }
    }

    public void confirmLogin(){
        client.login();
    }
}
