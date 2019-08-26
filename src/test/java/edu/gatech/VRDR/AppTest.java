package edu.gatech.VRDR;

import java.util.Date;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.Address.AddressUse;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Composition.CompositionStatus;
import org.hl7.fhir.dstu3.model.Composition.SectionComponent;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.HumanName.NameUse;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.context.FhirContext;
import edu.gatech.VRDR.model.AutopsyPerformedIndicator;
import edu.gatech.VRDR.model.CauseOfDeathCondition;
import edu.gatech.VRDR.model.Certifier;
import edu.gatech.VRDR.model.DeathCertificate;
import edu.gatech.VRDR.model.DeathCertificateDocument;
import edu.gatech.VRDR.model.DeathCertification;
import edu.gatech.VRDR.model.DeathDate;
import edu.gatech.VRDR.model.Decedent;
import edu.gatech.VRDR.model.InjuryIncident;
import edu.gatech.VRDR.model.InjuryLocation;
import edu.gatech.VRDR.model.MannerOfDeath;
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
    	//Useful No codeableconcept
    	CodeableConcept noCode = new CodeableConcept().addCoding(new Coding("http://terminology.www.hl7.org/CodeSystem/v2-0136","N","No"));
    	DeathCertificateDocument deathCertificateDocument = new DeathCertificateDocument();
    	DeathCertificate deathCertificate = new DeathCertificate();
    	deathCertificateDocument.addEntry(new BundleEntryComponent().setResource(deathCertificate));
    	
    	deathCertificate.setStatus(CompositionStatus.FINAL);
    	
    	Address decedentsHome = new Address().addLine("1808 Stroop Hill Road").setCity("Atlanta")
		.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.HOME);
    	
    	Decedent decedent = new Decedent();
    	decedent.setRace("2106-3", "", "White");
    	decedent.setEthnicity("", "", "");
    	decedent.setBirthSex("M", "Male");
    	decedent.setBirthPlace(decedentsHome);
    	decedent.addIdentifier("1AN2BN3DE45");
    	decedent.addName(new HumanName().setFamily("Cleaveland").addGiven("Grover").setUse(NameUse.OFFICIAL));
    	decedent.setMaritalStatus(new CodeableConcept().addCoding(new Coding().setCode("S").setSystem("http://hl7.org/fhir/v3/MaritalStatus")));
    	Reference decedentReference = new Reference(decedent);
    	
    	InjuryLocation injuryLocation = new InjuryLocation();
    	injuryLocation.setName("Hospital");
    	injuryLocation.setDescription("Gracie Hospital");
    	injuryLocation.setType(new CodeableConcept().addCoding(new Coding().setCode("HOSP").setSystem("http://hl7.org/fhir/ValueSet/v3-ServiceDeliveryLocationRoleType")));
    	injuryLocation.setPhysicalType(new CodeableConcept().addCoding(new Coding().setCode("ro").setSystem("http://hl7.org/fhir/ValueSet/location-physical-type")));
    	injuryLocation.setAddress(decedentsHome);
    	deathCertificate.setSubject(decedentReference);
    	
    	Certifier certifier = new Certifier();
    	certifier.addName(new HumanName().setFamily("Baden").addGiven("Michael").setUse(NameUse.OFFICIAL));
    	certifier.addAddress(new Address().addLine("256 Mount Olive Road").setCity("Atlata")
    			.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.WORK));
    	certifier.addQualification("12345","MD");
    	Date rightNow = new Date();
    	deathCertificate.addAttester(certifier,rightNow);
    	
    	DeathCertification deathCertification = new DeathCertification();
    	deathCertification.setPerformed(new DateTimeType(rightNow));
    	deathCertificate.addEvent(deathCertification);
    	deathCertificate.addAttester(certifier, new Date());
    	deathCertificate.addSection(new SectionComponent().addEntry(decedentReference));
    	deathCertificate.addSection(new SectionComponent().addEntry(new Reference(injuryLocation)));
    
    	AutopsyPerformedIndicator autopsyPerformedIndicator = new AutopsyPerformedIndicator(decedent,noCode);
    	
    	CauseOfDeathCondition causeOfDeathCondition = new CauseOfDeathCondition();
    	causeOfDeathCondition.setSubject(decedentReference);
    	causeOfDeathCondition.setAsserter(new Reference(certifier));
    	
    	DeathDate deathDate = new DeathDate(rightNow);
    	deathDate.setSubject(decedentReference);
    	
    	InjuryIncident injuryIncident = new InjuryIncident(decedent, "Head", noCode, noCode);
    	
    	CodeableConcept manner = new CodeableConcept().addCoding(new Coding("http://www.hl7.org/fhir/stu3/valueset-MannerTypeVS","7878000","Accident"));
    	MannerOfDeath mannerOfDeath = new MannerOfDeath(manner,decedent,certifier);
    	
    	deathCertificateDocument.addEntry().setResource(decedent);
    	deathCertificateDocument.addEntry().setResource(injuryLocation);
    	deathCertificateDocument.addEntry().setResource(certifier);
    	deathCertificateDocument.addEntry().setResource(deathCertification);
    	deathCertificateDocument.addEntry().setResource(autopsyPerformedIndicator);
    	deathCertificateDocument.addEntry().setResource(causeOfDeathCondition);
    	deathCertificateDocument.addEntry().setResource(deathDate);
    	deathCertificateDocument.addEntry().setResource(injuryIncident);
    	deathCertificateDocument.addEntry().setResource(mannerOfDeath);
    	String encoded = FhirContext.forDstu3().newJsonParser().encodeResourceToString(deathCertificateDocument);
    	System.out.println(encoded);
    	assertTrue( true );
    }
}