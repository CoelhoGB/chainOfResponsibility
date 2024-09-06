package com.cor;
import java.util.Scanner;


public class Server 
{

    Scanner scanner = new Scanner(System.in);
    Client client = new Client();
    DBManager manager = new DBManager();
    public static void main( String[] args ){

        

    }

    public void startService(){

        System.out.println( "Bem vindo(a) ao sistema!\nInsira seu email para começarmos. (Padrão: exemplo@email.com)" );
        String emailInput = scanner.nextLine();
        
    }



}
