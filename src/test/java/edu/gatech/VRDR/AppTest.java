package edu.gatech.VRDR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import ca.uhn.fhir.context.ConfigurationException;
import ca.uhn.fhir.parser.DataFormatException;
import edu.gatech.chai.VRDR.context.VRDRFhirContext;
import edu.gatech.chai.VRDR.model.CauseOfDeathPathway;
import edu.gatech.chai.VRDR.model.DeathCertificateDocument;
import edu.gatech.chai.VRDR.model.DeathDate;
import edu.gatech.chai.VRDR.model.Decedent;
import edu.gatech.chai.VRDR.model.MannerOfDeath;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	VRDRFhirContext context;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	super( testName );
    	context = new VRDRFhirContext();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testProducingDeathCertificateDocument()
    {
    	DeathCertificateDocument deathCertificateDocument = BuildDCD.buildExampleDeathCertificateDocument();
    	String encoded = context.getCtx().newJsonParser().encodeResourceToString(deathCertificateDocument);
    	System.out.println(encoded);
    	assertTrue( true );
    }
    
    public void testConsumingDeathCertificateDocument()
    {
    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File(classLoader.getResource("Testcase_Certificate.json").getFile());
    	DeathCertificateDocument deathCertificateDocument = null;
		try {
			deathCertificateDocument = (DeathCertificateDocument) context.getCtx().newJsonParser().parseResource(new FileInputStream(file));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (DataFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	String encoded = context.getCtx().newJsonParser().encodeResourceToString(deathCertificateDocument);
    	System.out.println(encoded);
    	assertTrue( true );
    }
    
    public void testGetResourceFromDocument() {
    	DeathCertificateDocument deathCertificateDocument = BuildDCD.buildExampleDeathCertificateDocument();
    	List<MannerOfDeath> mannerOfDeathList = deathCertificateDocument.getMannerOfDeath();
    	for(MannerOfDeath manner:mannerOfDeathList) {
    		String jsonForm = context.getCtx().newJsonParser().encodeResourceToString(manner);
    		System.out.println(jsonForm);
    	}
    }
    
    public void testPartialDecedentBirthDateRecord() {
    	Decedent decedent = BuildDCD.buildDecedentWithBirthDateAbsentReason();
    	String jsonForm = context.getCtx().newJsonParser().encodeResourceToString(decedent);
		System.out.println(jsonForm);
    }
    
    public void testPartialDeathDateRecord() {
    	DeathDate deathDate = BuildDCD.buildDeathWithPartialDateAbsentReason();
    	String jsonForm = context.getCtx().newJsonParser().encodeResourceToString(deathDate);
		System.out.println(jsonForm);
    }
}