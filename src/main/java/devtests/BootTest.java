/**
 * 
 */
package devtests;

import org.topicquests.os.asr.sg.SGEnvironment;

/**
 * @author jackpark
 *
 */
public class BootTest {
	private SGEnvironment environment;

	/**
	 * 
	 */
	public BootTest() {
		environment = new SGEnvironment();
		System.out.println("A "+environment.getProperties());
		
		environment.shutDown();
		System.exit(0);
	}

}
