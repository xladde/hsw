/**
 * @file wissensbasis.pl Wissensbasis fuer die Mini-Shell  'wbshell.pro'
 * @author Thomas Jonitz (114350)
 * @version 2013-11
 */

/* --- DIALOG-SYSTEM --- */
frage(start, 'Welche Mahlzeit liegt an?').
option(start, 'f', 'Frühstück', [fruehstueck]).
option(start, 'm', 'Mittag', [mittag]).
option(start, 'k', 'Kaffee', [kaffee]).
option(start, 'a', 'Abendbrot', [abendbrot]).
option(start, '', 'Kein Hunger', []).
erklaerung(start, 'Es zwingt dich niemand zum Essen.').

frage(fruehstueck, '?').
option(fruehstueck, '', '', []).
option(fruehstueck, '', '', []).

frage(fruehstueck, '?').
option(fruehstueck, '', '', []).
option(fruehstueck, '', '', []).

frage(fruehstueck, '?').
option(fruehstueck, '', '', []).
option(fruehstueck, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).

frage(, '?').
option(, '', '', []).
option(, '', '', []).


/* --- BEWERTUNGS-SYSTEM --- */
bewertung('Mach XYZ') :-
	wenn(id, option).
	
	
/* --- WRAP --- */
?-reconsult('wbshell').
?-expert. 
