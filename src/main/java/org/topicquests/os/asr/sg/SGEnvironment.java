/**
 * 
 */
package org.topicquests.os.asr.sg;

import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class SGEnvironment extends RootEnvironment {
	private boolean isShutdown  = false;

	/**
	 */
	public SGEnvironment() {
		super("sg-props.xml", "logger.properties");
		isShutdown = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shutDown() {
		System.out.println("SGEnvironment.shutDown "+isShutdown);
		if (!isShutdown) {
			//TODO
			isShutdown = true;
		}

	}

}
