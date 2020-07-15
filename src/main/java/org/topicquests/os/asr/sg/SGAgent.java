/**
 * 
 */
package org.topicquests.os.asr.sg;

import java.util.ArrayList;
import java.util.List;

import org.topicquests.os.asr.sg.api.ISGAgent;
import org.topicquests.os.asr.sg.api.ISGModel;

/**
 * @author jackpark
 *
 */
public class SGAgent implements ISGAgent {
	private SGEnvironment environment;
	private boolean isRunning = true;
	private ISGModel model;
	private Worker worker;
	private List<List<String>> sentences;
	/**
	 * 
	 */
	public SGAgent(SGEnvironment env) {
		environment = env;
		isRunning = true;
		sentences = new ArrayList<List<String>>();
		model = environment.getModel();
		worker = new Worker();
		worker.start();
	}

	@Override
	public void acceptSentence(String sentenceId, String newSentence) {
		List<String> l = new ArrayList<String>();
		l.add(sentenceId);
		l.add(newSentence);
		environment.logDebug("Agent got "+sentenceId);
		synchronized(sentences) {
			environment.logDebug("Agent did "+sentenceId);
			sentences.add(l);
			sentences.notify();
		}

	}
	
	public class Worker extends Thread {
		
		public void run() {
			System.out.println("Agent starting");
			List<String>aSentence = null;
			while (isRunning) {
				synchronized(sentences) {
					if (sentences.isEmpty()) {
						try {
							sentences.wait();
						} catch (Exception e) {}
					} else {
						aSentence = sentences.remove(0);
					}
				}
				if (isRunning && aSentence != null) {
					environment.logDebug("Agent doing "+aSentence);

					model.processSentence(aSentence);
				}
			}
			kill();
		}
		
		void kill() {
			System.out.println("Agent dying");
			worker = null;
		}
	}

	@Override
	public void shutDown() {
		synchronized(sentences) {
			isRunning = false;
			sentences.notify();
		}
	}

}
