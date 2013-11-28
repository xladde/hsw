/**
 * @file Email.java
 * @author t.j.
 * @version 2013-09
 */

/**
 * @brief Basisklasse für Emails.
 */
public class Email {
    private String firstName;
    private String lastName;
    private String mailAddress;
    
    public Email(String fn, String ln, String ma) {
        firstName = fn;
        lastName = ln;
        mailAddress = ma;
    }
    
    public void setFirstName(String fn) {
        firstName = fn;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String ln) {
        lastName = ln;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setMailAddress(String ma) {
        mailAddress = ma;
    }
    
    public String getMailAdress() {
        return mailAddress;
    }
    
    public String toString() {
        String str = new String(lastName+", "+firstName+": "+mailAddress);
        return str;
    }
}