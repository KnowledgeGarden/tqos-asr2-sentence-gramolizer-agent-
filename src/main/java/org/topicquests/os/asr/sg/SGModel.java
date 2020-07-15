/**
 * 
 */
package org.topicquests.os.asr.sg;

import java.util.List;

import org.topicquests.os.asr.sg.api.ISGModel;
import org.topicquests.os.asr.wordgram.api.IWordGramAgentModel;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class SGModel implements ISGModel {
	private SGEnvironment environment;
	private final String USER_ID = "SystemUser";
	private IWordGramAgentModel model;

	/**
	 * 
	 */
	public SGModel(SGEnvironment env) {
		environment = env;
		model = environment.getWordgramAgentModel();
	}

	@Override
	public void processSentence(List<String> aSentence) {
		environment.logDebug("SGModel.processSentence "+aSentence);
		String sentenceId = aSentence.get(0);
		String text = aSentence.get(1);
		IResult r = model.processString(text, USER_ID, sentenceId);
		environment.logDebug("SGModel.processSentence+ "+r.getErrorString()
				+"\n"+r.getResultObject());
	}

}
