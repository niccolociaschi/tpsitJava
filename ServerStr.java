import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import jdk.internal.org.jline.utils.InputStreamReader;

public class ServerStr {
    ServerSocket server = null;
Socket client = null;
String stringaRicevuta = null;
String stringaModificata = null;
BufferedReader inDalClient;
DataOutputStream outVersoClient;

public Socket attendi(){

    System.out.println("1 SERVER partito in esecuzione");
server = new ServerSocket(1234);
client =new server.accept();
server.close();
inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
outVersoClient new DataOutputStream(client.getOutputStream());

catch(Exception e) {
    System.out.println(e.getMessage());
System.out.println("errore durante l'istamza del server!");
System.exit();
}//catch
return client;
} //attendi

public void comunica(){
try{
    System.out.println("3 benvenuto client, scrivi una frase e la trasformo in maiuscolo, Attendo...");
stringaRicevuta= inDalClient.readLine();
System.out.println("Ricevuta la stringa" + stringaRicevuta);
stringaModificata= stringaRicevuta.toUpperCase();
System.out.println("7 invio la stringa modificata al client...");
outVersoClient.writeBytes(stringaModificata+ '\n');
System.out.println("9 SERVER: fine elaborazione nuonanotte!");
client.close();
}//try
} //comunica

} //class
