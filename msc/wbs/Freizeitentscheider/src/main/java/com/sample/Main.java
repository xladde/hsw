package com.sample;

import org.drools.runtime.StatefulKnowledgeSession;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StatefulKnowledgeSession ksession = DroolsTools.getKnowledgeSession("MyRules.drl", new com.sample.Message());
		if( ksession != null ) ksession.fireAllRules();
		System.out.println("Goodbye. I'm leaving...");
	}

}
