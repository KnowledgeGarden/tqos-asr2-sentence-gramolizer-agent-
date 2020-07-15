/**
 * 
 */
package org.topicquests.os.asr.sg.api;

import java.util.List;

/**
 * @author jackpark
 *
 */
public interface ISGModel {

	/**
	 * Given {@code aSentence} process it into WordGrams
	 * @param aSentence
	 * Note: aSentence[0] = sentenceId
	 * Note: aSentence[1] = sentenceText
	 */
	void processSentence(List<String> aSentence);
}
