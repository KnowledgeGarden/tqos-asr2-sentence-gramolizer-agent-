/**
 * 
 */
package org.topicquests.os.asr.sg;

import org.topicquests.hyperbrane.WordGramCache;
import org.topicquests.os.asr.sg.api.ISGModel;
import org.topicquests.os.asr.wordgram.WordGramEnvironment;
import org.topicquests.os.asr.wordgram.api.IWordGramAgentModel;
import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class SGEnvironment extends RootEnvironment {
	private boolean isShutdown  = false;
	private WordGramEnvironment wordGramEnvironment;
	private WordGramCache wgCache;
	private final int cacheSize = 8192;
	private ISGModel model;

	/**
	 */
	public SGEnvironment() {
		super("sg-props.xml", "logger.properties");
		isShutdown = false;
		wordGramEnvironment = new WordGramEnvironment("wordgram-props.xml", "logger.properties");
		wgCache = new WordGramCache(this, cacheSize);
	}
	
	public WordGramCache getWordGramCache() {
		return wgCache;
	}

	public IWordGramAgentModel getWordgramAgentModel() {
		return wordGramEnvironment.getModel();
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
