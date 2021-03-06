/**
 *  Ticket2Rock ist die Beispielanwendung des Buchs "EJB 3 professionell" (dpunkt).
 *  Es implementiert eine einfache Webanwendung zur Onlinebuchung von Tickets f�r
 *  Rockkonzerte auf Basis von EJB 3.0 und JavaServer Faces.
 *
 *  Copyright (C) 2006
 *  Jo Ehm, Dierk Harbeck, Stefan M. Heldt, Oliver Ihns, Jochen J�rg, Holger Koschek,
 *  Carsten Sahling, Roman Schloemmer
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package de.ejb3buch.ticket2rock.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Ein Album ist eine Zusammenstellung von Songs eines Interpreten. Es hat einen
 * Titel und ein Erscheinungsdatum. Ein Interpret kann mehrere Alben ver�ffent-
 * lichen. Ein Album wird von genau einem Interpreten ver�ffentlicht.
 */

@Entity
public class Album {

	private int id;

	private String titel;

	private Date erscheinungsdatum;

	private Interpret interpret;

	// Songs werden in einer List gehalten, um die Ordnung
	// sicherzustellen (der Einfachheit halber wird angenommen, dass die
	// Reihenfolge der Songs in der Datenbank mit der Reihenfolge auf dem Album
	// �bereinstimmt).
	private List<Song> songs;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Date getErscheinungsdatum() {
		return erscheinungsdatum;
	}

	public void setErscheinungsdatum(Date erscheinungsdatum) {
		this.erscheinungsdatum = erscheinungsdatum;
	}

	@ManyToOne
	public Interpret getInterpret() {
		return interpret;
	}

	public void setInterpret(Interpret interpret) {
		this.interpret = interpret;
	}

	// Hier muss der Default Fetch Type (LAZY) �berschrieben werden,
	// sonst beschwert sich JBoss ("org.hibernate.LazyInitializationException:
	// failed to lazily initialize a collection of role:
	// de.ejb3buch.ticket2rock.entity.Album.songs,
	// no session or session was closed")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "album")
	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
