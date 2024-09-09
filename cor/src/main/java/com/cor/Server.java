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
        startService();
    }

    public void startService(){

        String startMessage = "Bem vindo(a) ao sistema!\nJá és usuário?";
        client.waitInput(startMessage);
    }
}
