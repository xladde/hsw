import javax.persistence.EntityBean;
import javax.persistence.Column;

@EntityBean
public class Lagerartikel {
    @Column(name="Artikelnummer")
    private Integer     artikelnummer;
    private String      Artikelbezeichnung;
    private Integer     Regalnummer;
    private Integer     Fachnummer;
    private Integer     Bestand;
    private Integer     Mindestbestand;
    private String      Mengeneinheit
    
    public Lagerartikel() {}
    
    public Integer getArtikelnummer()        {return this.artikelnummer;}
    public void setArtikelnummer(Integer an) {this.artikelnummer = an;}
    // ... restliche Getter/Setter
} // end class Lagerartikel