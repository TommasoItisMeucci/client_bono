package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client parciaotito!");
        Socket s = new Socket("localhost", 3000);
        System.out.println("client collegato!");

        //first try 
        /* 
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaInviata = "salve" + '\n';
        out.writeBytes(stringaInviata);

        String stringaRimandata = in.readLine();
        System.out.println("la stringa mo è: " + stringaRimandata);
        String stringaRimandata = in.readLine();
        System.out.println("la stringa mo è: " + stringaRimandata);
        
        s.close();*/
        //second try 
        /* 
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        Scanner scan = new Scanner(System.in);
        System.out.println("inserisci");
        String stringaInviata = scan.nextLine();
        System.out.println("hai inserito: " + stringaInviata);
        scan.close();
        out.writeBytes(stringaInviata + '\n');

        String stringaRimandata = in.readLine();
        System.out.println("la stringa mo è: " + stringaRimandata);
        
        s.close();*/

        //
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String inviata = new String();
        
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("inserisci, inserisci exit per uscire");
            String stringaMess = scan.nextLine();
            System.out.println("hai inserito: " + stringaMess);
            scan.close();
            
            if (stringaMess.equals("exit")) {
                stringaMess = "!";
                out.writeBytes(stringaMess + '\n');
                break;
            }
            inviata = stringaMess;
            out.writeBytes(inviata + '\n');

            String stringaRimandata = in.readLine();
            System.out.println("la stringa mo è: " + stringaRimandata);
        
        } while (true);
        
        s.close();
    }
}