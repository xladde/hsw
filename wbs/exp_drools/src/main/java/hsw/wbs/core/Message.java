/**
 * 
 */
package hsw.wbs.core;

/**
 * @author tj
 *
 */
public class Message {

	public static enum State { INIT, WAIT, RUN, FINAL };
	
	private State state;
	
	public Message() {
		this.setState(State.INIT);
	}
	
	public Message(State state) {
		this.setState(state);
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
}
