/**
 * @file wissensbasis.pl Wissensbasis fuer die Mini-Shell  'wbshell.pro'
 * @author Thomas Jonitz (114350)
 * @version 2013-11
 */

/**
 * @brief DIALOG-SYSTEM.
 */
frage(start, 'Welche Mahlzeit darf es denn sein?').
option(start, 'f', 'Frühstück', []).
option(start, 'm', 'Mittag', []).
option(start, 'a', 'Abendbrot', []).
option(start, 'k', 'Kein Hunger', []).
erklaerung(start, 'Es zwingt dich niemand zum Essen.').

frage(ernaehrung, 'Wie möchtest du essen?').
option(ernaehrung, 'g', 'vegan', [geschmack]).
option(ernaehrung, 'k', 'vegetarisch', [geschmack]).
option(ernaehrung, 'f', 'ohne Einschränkung', [geschmack]).

frage(geschmack, 'Was möchtest du essen?').
option(geschmack, 'l', 'leichte Kost', []).
option(geschmack, 'd', 'deftige Kost', []).
option(geschmack, 's', 'Süßes', []).

/**
 * @brief BEWERTUNGS-SYSTEM.
 */
/* Globale Bewertungen */
bewertung('Es zwingt dich niemand zum Essen.'):-
	wenn(start, k).

/********************************************************** Frühstück */
bewertung('Müsli aus Haferflocken, Rosinen und Dinkelmilch.'):-
	wenn(geschmack, 's').
bewertung('Knäckebrot mit Gurke und etwas Salz bestreut ist lecker.'):-
	wenn(start, 'f'), 
	wenn(ernaehrung, 'g'), 
	(wenn(geschmack, 'd'); wenn(geschmack, 'l')).
bewertung('Brot mit Butter und Marmelade'):-
	wenn(start, 'f'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 's').
bewertung('Brot mit Margarine und Frischkäse'):-
	wenn(start, 'f'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 'l').
bewertung('Brot mit Butter und Salami'):-
	wenn(start, 'f'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 'd').
bewertung('Mettigel mit Ananas auf Butterbrot'):-
	wenn(start, 'f'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 's').
bewertung('Gemüsebrühe und ein Butterbrot'):-
	wenn(start, 'f'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 'l').
bewertung(''):-
	wenn(start, 'f'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 'd').

/************************************************************* Mittag */
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'g'),
	wenn(geschmack, 's').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'g'),
	wenn(geschmack, 'l').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'g'),
	wenn(geschmack, 'd').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 's').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 'l').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 'd').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 's').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 'l').
bewertung(''):-
	wenn(start, 'm'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 'd').	

/********************************************************** Abendbrot */
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'g'),
	wenn(geschmack, 's').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'g'),
	wenn(geschmack, 'l').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'g'),
	wenn(geschmack, 'd').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 's').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 'l').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'k'),
	wenn(geschmack, 'd').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 's').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 'l').
bewertung(''):-
	wenn(start, 'a'),
	wenn(ernaehrung, 'f'),
	wenn(geschmack, 'd').


/* --- WRAP --- */
?-reconsult('wbshell').
?-expert. 
