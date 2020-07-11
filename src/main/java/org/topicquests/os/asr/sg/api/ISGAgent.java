/**
 * 
 */
package org.topicquests.os.asr.sg.api;

/**
 * @author jackpark
 *
 */
public interface ISGAgent {

	/**
	 * Inject a new sentence into a threaded agent for processing
	 * @param sentenceId
	 * @param newSentence
	 */
	public void acceptSentence(String sentenceId, String newSentence);
	
	public void shutDown();
}
