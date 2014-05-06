package pack1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Column;

/**
 *
 * @author tj
 * @version 2014-05-05
 */
@Entity
public class Kunde implements Serializable {
    
    @Column(name="vorname")
    private String vorname;
    @Column(name="familienname")
    private String nachname;
    @Column(name="adresse")
    private String adresse;
    @Column(name="kreditkartennummer")
    private String kreditkartennummer;
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKreditkartennummer() {
        return kreditkartennummer;
    }

    public void setKreditkartennummer(String kreditkartennummer) {
        this.kreditkartennummer = kreditkartennummer;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kunde)) {
            return false;
        }
        Kunde other = (Kunde) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack1.Kunde[ id=" + id + " ]";
    }
    
}
