package com.cor;

public class Main {

    public static void main(String[] args){
        
        Server server = new Server();
        Logger logger = new Logger();
        Validator validator =  new Validator();
        LoginReg loginReg = new LoginReg(logger);
        LoginAuth loginAuth = new LoginAuth(logger);
        Client client = new Client(validator);

        validator = new Validator(logger, loginAuth);
        logger = new Logger(server, loginAuth, loginReg);
        server = new Server(client, loginAuth, loginReg, logger, validator);
    }
}
