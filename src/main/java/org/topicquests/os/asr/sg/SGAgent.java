/**
 * 
 */
package org.topicquests.os.asr.sg;

import java.util.ArrayList;
import java.util.List;

import org.topicquests.os.asr.sg.api.ISGAgent;

/**
 * @author jackpark
 *
 */
public class SGAgent implements ISGAgent {
	private SGEnvironment environment;
	private boolean isRunning = true;
	private Worker worker;
	private List<List<String>> sentences;
	/**
	 * 
	 */
	public SGAgent(SGEnvironment env) {
		environment = env;
		isRunning = true;
		sentences = new ArrayList<List<String>>();
		worker = new Worker();
		worker.start();
	}

	@Override
	public void acceptSentence(String sentenceId, String newSentence) {
		List<String> l = new ArrayList<String>();
		l.add(sentenceId);
		l.add(newSentence);
		synchronized(sentences) {
			sentences.add(l);
			sentences.notify();
		}

	}
	
	public class Worker extends Thread {
		
		public void run() {
			System.out.println("Agent starting");
			List<String>aSentence = null;
			while (isRunning) {
				//TODO
				yield();
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
