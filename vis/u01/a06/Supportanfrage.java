/**
 * @author t.j.
 * @version 2014-03
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// make it accessible
@Retention(RetentionPolicy.RUNTIME)
public @interface Supportanfrage {
    String id();
    String beschreibung();
    String bearbeiter()     default "unbekannt";
    String datum()          default "unbestimmt";
}