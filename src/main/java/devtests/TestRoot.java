/**
 * 
 */
package devtests;

import org.topicquests.os.asr.sg.SGEnvironment;
import org.topicquests.os.asr.sg.api.ISGAgent;

/**
 * @author jackpark
 *
 */
public class TestRoot {
	protected SGEnvironment environment;
	protected ISGAgent agent;

	/**
	 * 
	 */
	public TestRoot() {
		environment = new SGEnvironment();
		agent = environment.getAgent();
	}

}
