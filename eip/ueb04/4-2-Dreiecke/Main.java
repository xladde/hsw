/**
 * @file Main.java
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Aufg 4-2 (Main-Klasse)
 *
 * Eine zweite Methode gibEigenschaft(int code) soll den Code in den oben 
 * angegebenen Text umwandeln und als String zurückgeben. Schreiben Sie eine 
 * ausführbare Klasse mit einer main-Methode. Erzeugen Sie ein Dreieck, 
 * ermitteln Sie die Eigenschaft und geben Sie diese Eigenschaft aus.
 */
public class Main {
	public static void main(String[] args){
		// einige Dreiecke zum testen (seitenlaengen zwischen 0>= und <10)
		Dreieck[] d = new Dreieck[5];
		for(int i = 0; i<d.length; i++){
			Dreieck tmp = new Dreieck(
				(int)Math.random()*10,(int)Math.random()*10,(int)Math.random()*10
			);
			d[i] = tmp;
		}
		
		for(int i = 0; i < d.length; i++) {
			System.out.print("Das Dreieck "+i+" ist ");
			switch(d[i].getCode()){
				case 0:
					System.out.println("kein Dreieck. Abbruch.");
					break;
				case 1:
					System.out.println("rechtwinklig, gleichschenklig");
					break;
				case 2:
					System.out.println("stumpfwinklig, gleichschenklig");
					break;
				case 3:
					System.out.println("spitzwinklig, gleichschenklig");
					break;
				case 4:
					System.out.println("gleichseitig");
					break;
				case 5:
					System.out.println("rechtwinklig");
					break;
				case 6:
					System.out.println("stumpfwinklig");
					break;
				case 7:
					System.out.println("spitzwinklig");
					break;
				default:
					break;
			}//end switch case
			System.out.println(
				"Seiten: a="+d[i].getA()+" b="+d[i].getB()+" c="+d[i].getC()
			);
		}//end for
	}//end main
}//end class
