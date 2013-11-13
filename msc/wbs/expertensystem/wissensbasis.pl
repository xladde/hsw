/**
 * @file wissensbasis.pl Wissensbasis fuer die Mini-Shell  'wbshell.pro'
 * @author Thomas Jonitz (114350)
 * @version 2013-11
 */

?- write(' ******* Es wird das Wissen geladen ********'),nl,nl.
wissensbasis('   ***   Kleidungswahl   ***').

/**
 * DIALOG-SYSTEM.
 */
frage(start, 'Regnet es?').
option(start, 'j', 'ja', [sommerregen]).
option(start, 'n', 'nein', [rausgehen]).

frage(rausgehen, 'Willst du draussen etwas unternehmen?').
option(rausgehen, 'j', 'ja', [freunde]).
option(rausgehen, 'n', 'nein', [lernen]).

frage(freunde, 'Hast du Freunde?').
option(freunde, 'j', 'ja', [geld]).
option(freunde, 'n', 'nein', [geld]).

frage(indoor1, 'Moechtest du etwas spielen?').
option(indoor1, 'j', 'ja', [indoor2]).
option(indoor1, 'n', 'nein', [prokast1]).

frage(lernen, 'Musst du lernen?').
option(lernen, 'j', 'ja', [prokast1]).
option(lernen, 'n', 'nein', [indoor1]).

frage(prokast1, 'Ist der Fussboden sauber?').
option(prokast1, 'j', 'ja', [prokast2]).
option(prokast1, 'n', 'nein', []).


frage(prokast2, 'Hast du noch frische Waesche da?').
option(prokast2, 'j', 'ja', [prokast3]).
option(prokast2, 'n', 'nein', []).


frage(prokast3, 'Hast du heute schon etwas gegessen?').
option(prokast3, 'j', 'ja', [prokast4]).
option(prokast3, 'n', 'nein', []).


frage(prokast4, 'Sind deine unterlagen ordentlich sortiert?').
option(prokast4, 'j', 'ja', []).
option(prokast4, 'n', 'nein', []).


frage(geld, 'Ist Geld vorhanden?').
option(geld, 'j', 'ja', []).
option(geld, 'n', 'nein', []).

frage(indoor2, 'Moechtest du ausspannen?').
option(indoor2, 'j', 'ja', []).
option(indoor2, 'n', 'nein', []).

frage(sommerregen, 'Ist es Sommerregen').
option(sommerregen, 'j', 'ja', []).
option(sommerregen, 'n', 'nein', [lernen]).

/**
 * BEWERTUNGS-SYSTEM.
 */
/* Globale Bewertungen */
bewertung('Barfuss im Regen tanzen.'):-
	wenn(sommerregen, 'j').

bewertung('In die Spielhalle gehen.'):-
	wenn(freunde, 'n'), 
	wenn(geld, 'j').

bewertung('Kino.'):-
	wenn(freunde, 'j'),
	wenn(geld, 'j').

bewertung('Kubb auf dem Campus.'):-
	wenn(freunde, 'j'),
	wenn(geld, 'n').

bewertung('Dann steht dem Lernprozess nichts mehr im Wege.'):-
	wenn(lernen, 'j'),
	wenn(prokast4, 'j').

bewertung('Am besten du wischt nochmal schnell durch.'):-
	wenn(prokast1, 'n').
	
bewertung('Geh Waesche waschen.'):-
	wenn(prokast2, 'n').
	
bewertung('Auf leeren Magen lernen geht gar nicht! Die Pizza ist bestellt.'):-
	wenn(prokast3, 'n').
	

bewertung('Es wäre effizienter, wenn du erstmal alle Unterlagen zusammensuchst ... und dabei gleich aufräumst. Wie sieht das hier nur wieder aus?'):-
	wenn(prokast4, 'n').
	
bewertung('Pack mal wieder die Modelleisenbahn aus.'):-
	wenn(indoor2, 'j').

bewertung('Ich empfehle dringend Counter Strike.'):-
	wenn(indoor2, 'n').

bewertung('Dir kann niemand helfen.'):-
	wenn(freunde, 'n'),
	wenn(geld, 'n').




/* --- WRAP --- */
?-reconsult('wbshell').
?-expert. 
/*-- end of file ----------------------------------------------*/