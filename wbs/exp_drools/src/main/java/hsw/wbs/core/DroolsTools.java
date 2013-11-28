package hsw.wbs.core;

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
//import org.drools.logger.KnowledgeRuntimeLogger;
//import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTools {

    
	public static StatefulKnowledgeSession getStatefulKnowledgeSession(String path, Object o) {
		StatefulKnowledgeSession ksession;
		if(o != null) {
			ksession = getStatefulKnowledgeSession(path);
			if(ksession != null) {
				ksession.insert(o);
				return ksession;
			} else { return null; }
		} else { return null; }
	}

    public static StatefulKnowledgeSession getStatefulKnowledgeSession(String path) {
    	KnowledgeBase kbase;
    	StatefulKnowledgeSession ksession;
    	KnowledgeRuntimeLogger logger;
    	try {
    		kbase    = readKnowledgeBase(path);
        	ksession = kbase.newStatefulKnowledgeSession();
        	logger   = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
        	logger.close();
        	if(ksession != null) {
        		return ksession;
        	} else { return null; }        	
    	} catch(Throwable t) {
    		System.out.println("X:\tErr in DroolsTools: cannot read knowlegde base\n\t"+t.getMessage());
    		//t.printStackTrace();
    		return null;
    	}
    }
    
    /**
     * 
     * @param message
     * @param rule
     */
    public static Object fireMessage(Object message, String rule) {
		StatefulKnowledgeSession session;
		try {
			session = DroolsTools.getStatefulKnowledgeSession(rule);
			if(session != null) {
				session.insert(message);
				session.fireAllRules();
			} else {
				System.out.println("X:\tCannot create Session\n\t");
			}
		} catch(Throwable t) {
			System.out.println("X:\tCannot fire Message\n\t"+t.getMessage());
		}
		return message;
	}
    
    /**
     * 
     * @return
     * @throws Exception
     */
    private static KnowledgeBase readKnowledgeBase(String path) throws Exception {
        if(path != null) {
	    	KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	        kbuilder.add(ResourceFactory.newClassPathResource(path), ResourceType.DRL);
	        KnowledgeBuilderErrors errors = kbuilder.getErrors();
	        if (errors.size() > 0) {
	            for (KnowledgeBuilderError error: errors) {
	                System.err.println(error);
	            }
	            throw new IllegalArgumentException("Could not parse knowledge.");
	        }
	        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	        return kbase;
        } else { return null; }
    }
}