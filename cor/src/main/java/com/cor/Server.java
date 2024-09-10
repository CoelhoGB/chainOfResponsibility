package com.cor;

public class Server 
{

    Client client;
    LoginAuth loginAuth;
    LoginReg loginReg;
    Logger logger;
    Validator validator;

    public Server(){System.out.println("Iniciou vazio");}

    public Server(Client client, LoginAuth loginAuth, LoginReg loginReg, Logger logger, Validator validator){
        this.client = client;
        this.loginAuth = loginAuth;
        this.loginReg = loginReg;
        this.logger = logger;
        this.validator =  validator;
        System.out.println("Iniciou certo");
        startService();
    }

    public void startService(){
        String startMessage = "Bem vindo(a) ao sistema!\nJá és usuário?(Responda Sim/S ou Nao/N)";
        validator.setMode(1);
        System.out.println("Validador setado");
        client.waitInput(startMessage);
    }

    public void responseError(String response){
        if(response.matches("(rpErr)*")){

        }
        else if(response.matches("(@Err)*")){

        }
        else if(response.matches("(pwErr)*")){
        }
        else{
            System.out.println("Logging Error.");
        }
    }
}
