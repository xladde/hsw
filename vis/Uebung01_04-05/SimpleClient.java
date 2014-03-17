/**
* Aufgabe 8_04
*/

import java.io.*;
import java.net.*;

public class SimpleClient{
	public static void main(String[] args) throws IOException{
		
		try{
		Socket s = new Socket("rivera.wi.hs-wismar.de",8008);
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintStream out = new PrintStream(s.getOutputStream());
		BufferedReader consoleStream = new BufferedReader(new InputStreamReader(System.in));
		String consoleInput = "";
		do{
			System.out.print("An den Server senden:\t");
			consoleInput = consoleStream.readLine();
			out.println(consoleInput);
			out.flush();
			System.out.println("Gesendet an Server: " + consoleInput);
			System.out.println("Empfangen von Server: " + in.readLine());
		}while(!(consoleInput.equals("client stop") || consoleInput.equals("all stop")));
		s.close();
		out.close();
		in.close();
		System.out.println("Verbindung geschlossen");
		}
		catch(ConnectException ce){
			System.out.println("Es konnte keine Verbindung zum Server hergestellt werden.");	
		}

			
	}
}