package com.cor;

public class Main {

    public static void main(String[] args){
        
        Server server = new Server();
        Client client = new Client();
        Logger logger = new Logger();
        Validator validator =  new Validator(logger);
        LoginAuth loginAuth = new LoginAuth(logger);
        LoginReg loginReg = new LoginReg(logger);

        logger = new Logger(server, loginAuth, loginReg);
        server = new Server(client, loginAuth, loginReg, logger, validator);
    }
}
