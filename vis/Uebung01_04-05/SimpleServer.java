/**
 * Verteilte Systeme, Aufgabe 1.5 Sicherheitsrichtlinie
 * Das Serverprogramm soll mit Portnummmern kleiner 5000 nicht gestartet werden koennen.
 * Ergaenzen Sie ihr Programm mit einer entsprechenden Sicherheitsrichtlinie, 
 * die als SecurityManager-Objekt geladen wird. 
 * @author Michael Mueller
 * @version 19.03.2012
 */
import java.io.*;
import java.net.*;

public class SimpleServer {

	public static void main(String[] arg) {

		try {
			int listenPort = Integer.parseInt(arg[0]);
			System.setSecurityManager(new PortSecurityManager(listenPort));
			// Objekt vom Typ ServerSocket wird erzeugt.
			ServerSocket serverSocket = new ServerSocket(listenPort);
			// Ein Objekt vom Typ Socket wird erzeugt sobald eine Verbindung
			// zu einem Client hergestellt wurde(serverSocket.accept()).
			// Die Verbindungseigenschaften werden an das Objekt uebergeben
			Socket socket = serverSocket.accept();

			BufferedReader input = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintStream output = new PrintStream(socket.getOutputStream());
			String inputString = "";
			System.out.println("IP-Adresse des Clients lautet: "
					+ socket.getInetAddress());
			do {
				inputString = input.readLine();
				if (inputString == null) {
					System.out
							.println("Kein Empfang mehr, warte auf Verbindung");
					socket.close();
					socket = serverSocket.accept();
					input = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					output = new PrintStream(socket.getOutputStream());
					System.out.println("IP-Adresse des neuen Clients lautet: "
							+ socket.getInetAddress());
					inputString = "";
					continue;

				}
				System.out.println("Empfangen von Client: " + inputString);
				output.println("Hi");
				output.flush();

			} while (!(inputString.equals("server stop") || inputString
					.equals("all stop")));

			serverSocket.close();
			input.close();
			output.close();
			System.out.println("Verbindung geschlossen");
		} catch (IOException exc) {
			exc.getMessage();
		} catch (NumberFormatException nfe) {
			System.out.println("\"" + arg[0]
					+ "\" ist kein gueltiger Integer-Wert.");
		} catch (SecurityException secEx) {
			System.out.println(secEx.getMessage());
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Beim Aufruf des Programs muss eine Portnummer uebergeben werden.");
		}

	}
}