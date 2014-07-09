import javax.persistence.EntityBean;
import javax.persistence.Column;

@EntityBean
public class Straftat {
    private String  meldendePerson, sachverhalt, tatOrt, tatZeit,
                    tatHergang, zeugen, geschaedigter, taeter;

    public Straftat() {}

    // Exemplarisch 2 Setter und Getter
    public void setMeldendePerson(String meldendePerson) {this.meldendePerson = meldendePerson;}
    public String getMeldendePerson() {return this.meldendePerson;}
    
    public void setSachverhalt(String sachverhalt) {this.sachverhalt = sachverhalt;}
    public String getSachverhalt() {return this.sachverhalt;}
    
} // End EntityBean Straftat