/**
 * 
 */
package com.sample;

/**
 * @author tj
 *
 */
public class Message {
	public static enum  STAT_ENUM { INIT, FINAL, STAT1, STAT2, STAT3, STAT4, STAT5 };
	
	private STAT_ENUM status;
	private String    message;
	
	
	public Message() { 
		setStatus(STAT_ENUM.INIT); 
	}


	/**
	 * @return the status
	 */
	public STAT_ENUM getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(STAT_ENUM status) {
		this.status = status;
		switch(status) {
			case INIT:
				message = "Starte Freizeitentscheider";
				break;
			case FINAL:
				message = "Beende Freizeitentscheider";
				break;
			default:
				message = "Etwas unerwartetes ist gekommen.";
				break;
		}
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
