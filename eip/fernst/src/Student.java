public class Student {
    // Merkmale von Studenten
    private String  name;
    private String  matNr;
    private int     credits;
    // Konstruktor
    public Student(String name, String matrikelNummer) {
        this.name   = name;
        matNr       = matrikelnummer;
        credits     = 0;
    }
    // Zugriffsmethoden
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setMatNr(String matNr) {this.matNr = matNr;}
    public String getMatNr() {return matNr;}
    public void setCredits(int credits) {this.credits = credits;}
    public int getCredits() {return credits;}
} // Ende Klasse Student