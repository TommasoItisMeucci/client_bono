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

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String inviata = new String();
        String operazione = new String();

        do {
            //Stringa 
            Scanner scan = new Scanner(System.in);
            System.out.println("inserisci una parola oppure inserisci exit per uscire");
            String stringaMess = scan.nextLine();
            System.out.println("hai inserito: " + stringaMess);

            if (stringaMess.equals("exit")) {
                inviata = stringaMess;
                out.writeBytes(inviata + '\n');
                break;
            }
            
            //invia la parola
            inviata = stringaMess;
            out.writeBytes(inviata + '\n');


            //operazione 
            System.out.println("inserisci l'operazione da eseguire");
            System.out.println("1) premi 'M' per mettere la parola in maiuscolo");
            System.out.println("2) premi 'm' per mettere la parola in minuscolo");
            System.out.println("3) premi 'r' per ribaltare la parola");
            System.out.println("4) premi 'c' per contare il numero di caratteri della parola");
            String stringaScelta = scan.nextLine();
            System.out.println("hai inserito: " + stringaScelta);
            
            switch (stringaScelta) {
                case "M"://maiuscolo
                    operazione = stringaScelta;
                    out.writeBytes(operazione + "\n");
                    break;
                
                case "m"://minuscolo
                    operazione = stringaScelta;
                    out.writeBytes(operazione + "\n");
                break;

                case "r"://ribaltare
                    operazione = stringaScelta;
                    out.writeBytes(operazione + "\n");
                break;

                case "c"://contare
                    operazione = stringaScelta;
                    out.writeBytes(operazione + "\n");
                break;

                default:
                        operazione = "!";
                        out.writeBytes(operazione + "\n");
                    break;
            }
          

            //prendo la stringa
            String stringaRimandata = in.readLine();
            //controllo di errore
            if (stringaRimandata.equals("!")) {
                //notifica di errore
                System.out.println("operazione non valida, inserisci solo le operazioni proposte");
            }else{
                System.out.println("la stringa mo è: " + stringaRimandata);
            }
            
            
  
        } while (true);
        
        s.close();
    }
}