/**
 * 
 */
package devtests;

/**
 * @author jackpark
 *
 */
public class FirstTest extends TestRoot {
	private final String
		ID1		= "12345",
		S1		= "My first sentence",
		ID2		= "23456",
		S2		= "My second sentence";
	/**
	 * 
	 */
	public FirstTest() {
		agent.acceptSentence(ID1, S1);
		agent.acceptSentence(ID2, S2);
		
		//environment.shutDown();
	}

}
