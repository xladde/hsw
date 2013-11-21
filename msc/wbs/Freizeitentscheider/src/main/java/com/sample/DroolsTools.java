package com.sample;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.sample.Message;
import com.sample.Message.STAT_ENUM;

public class DroolsTools {

	private final static String DEFAULT_KB  = "MyRules.drl";
	private final static String DEFAULT_LOG = "test";
	
	public static StatefulKnowledgeSession getKnowledgeSession(String rulepath, Message m) {
		
		KnowledgeBase kbase;
		StatefulKnowledgeSession ksession;
		//KnowledgeRuntimeLogger logger;

		if(rulepath == null) { 
			rulepath = DEFAULT_KB; 
		}
		if(m == null) { 
			m = new Message(); 
			m.setStatus(STAT_ENUM.INIT);
		}
		
		try {
			// prepare engine
			kbase = readKnowledgeBase(rulepath);
			if( kbase != null ) {
				ksession = kbase.newStatefulKnowledgeSession();
				//logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, DEFAULT_LOG);
				// start engine
				ksession.insert(m);
				//ksession.fireAllRules();
				//logger.close();
				return ksession;
			} else return null;
			
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}
	
	private static KnowledgeBase readKnowledgeBase(String path) throws Exception {
    	
    	KnowledgeBuilder       kbuilder;
    	KnowledgeBase          kbase;
    	KnowledgeBuilderErrors errors;
    	
    	if(path != null) {
    		kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    		kbuilder.add(ResourceFactory.newClassPathResource(path), ResourceType.DRL);
            errors = kbuilder.getErrors();
            if (errors.size() > 0) {
                for (KnowledgeBuilderError error: errors) {
                    System.err.println(error);
                }
                throw new IllegalArgumentException("Could not parse knowledge.");
            }
            kbase = KnowledgeBaseFactory.newKnowledgeBase();
            kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
            return kbase;
    	} else return null;        
    }
}
