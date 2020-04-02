package edu.gatech.VRDR;

import edu.gatech.VRDR.context.VRDRFhirContext;
import edu.gatech.VRDR.model.DeathCertificateDocument;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	DeathCertificateDocument deathCertificateDocument = BuildDCD.buildExampleDeathCertificateDocument();
    	String encoded = new VRDRFhirContext().getCtx().newJsonParser().encodeResourceToString(deathCertificateDocument);
    	System.out.println(encoded.length());
    	System.out.println(encoded);
    	assertTrue( true );
    }
}