package edu.gatech.VRDR;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.Address.AddressUse;
import org.hl7.fhir.dstu3.model.Age;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Composition.CompositionStatus;
import org.hl7.fhir.dstu3.model.Composition.SectionComponent;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.dstu3.model.HumanName.NameUse;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent;
import org.hl7.fhir.dstu3.model.Quantity;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Resource;

import ca.uhn.fhir.context.FhirContext;
import edu.gatech.VRDR.model.AutopsyPerformedIndicator;
import edu.gatech.VRDR.model.BirthRecordIdentifier;
import edu.gatech.VRDR.model.ConditionContributingToDeath;
import edu.gatech.VRDR.model.CauseOfDeathPathway;
import edu.gatech.VRDR.model.Certifier;
import edu.gatech.VRDR.model.DeathCertificate;
import edu.gatech.VRDR.model.DeathCertificateDocument;
import edu.gatech.VRDR.model.DeathCertificateReference;
import edu.gatech.VRDR.model.DeathCertification;
import edu.gatech.VRDR.model.DeathDate;
import edu.gatech.VRDR.model.DeathLocation;
import edu.gatech.VRDR.model.DeathPronouncementPerformer;
import edu.gatech.VRDR.model.Decedent;
import edu.gatech.VRDR.model.DecedentAge;
import edu.gatech.VRDR.model.DecedentDispositionMethod;
import edu.gatech.VRDR.model.DecedentEducationLevel;
import edu.gatech.VRDR.model.DecedentEmploymentHistory;
import edu.gatech.VRDR.model.DecedentFather;
import edu.gatech.VRDR.model.DecedentMother;
import edu.gatech.VRDR.model.DecedentPregnancy;
import edu.gatech.VRDR.model.DecedentSpouse;
import edu.gatech.VRDR.model.DecedentTransportationRole;
import edu.gatech.VRDR.model.DispositionLocation;
import edu.gatech.VRDR.model.ExaminerContacted;
import edu.gatech.VRDR.model.FuneralHome;
import edu.gatech.VRDR.model.FuneralHomeDirector;
import edu.gatech.VRDR.model.InjuryIncident;
import edu.gatech.VRDR.model.InjuryLocation;
import edu.gatech.VRDR.model.InterestedParty;
import edu.gatech.VRDR.model.MannerOfDeath;
import edu.gatech.VRDR.model.Mortician;
import edu.gatech.VRDR.model.TobaccoUseContributedToDeath;
import edu.gatech.VRDR.model.util.CommonUtil;
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
    	CodeableConcept yesCode = new CodeableConcept().addCoding(new Coding("http://terminology.www.hl7.org/CodeSystem/v2-0136","Y","Yes"));
    	DeathCertificateDocument deathCertificateDocument = new DeathCertificateDocument();
    	DeathCertificate deathCertificate = new DeathCertificate();
    	deathCertificateDocument.addEntry(new BundleEntryComponent().setResource(deathCertificate));
    	List<Resource> contents = new ArrayList<Resource>();
    	
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
    	Reference decedentReference = new Reference(decedent.getId());
    	contents.add(decedent);
    	
    	Certifier certifier = new Certifier();
    	certifier.addName(new HumanName().setFamily("Baden").addGiven("Michael").setUse(NameUse.OFFICIAL));
    	certifier.addAddress(new Address().addLine("256 Mount Olive Road").setCity("Atlata")
    			.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.WORK));
    	certifier.addQualification("12345","MD");
    	Date rightNow = new Date();
    	deathCertificate.addAttester(certifier,rightNow);
    	Reference certifierReference = new Reference(certifier.getId());
    	contents.add(certifier);
    	
    	CodeableConcept gaState = new CodeableConcept().addCoding(new Coding("","32","Georgia"));
    	DateTimeType birthYear = new DateTimeType("1935-01-01");
    	BirthRecordIdentifier birthRecordIdentifier = new BirthRecordIdentifier("June 3rd 1935",gaState,birthYear);
    	birthRecordIdentifier.setSubject(decedentReference);
    	contents.add(birthRecordIdentifier);
    	
    	DecedentEducationLevel decedentEducationLevel = new DecedentEducationLevel();
    	decedentEducationLevel.setValue(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/ValueSet/v3-EducationLevel","BD","College or baccalaureate degree complete")));
    	decedentEducationLevel.setSubject(decedentReference);
    	contents.add(decedentEducationLevel);
    	
    	DecedentFather decedentFather = new DecedentFather();
    	decedentFather.addName(new HumanName().setFamily("Baden").addGiven("George"));
    	decedentFather.setPatient(decedentReference);
    	contents.add(decedentFather);
    	
    	DecedentMother decedentMother = new DecedentMother();
    	decedentMother.addName(new HumanName().setFamily("Baden").addGiven("Beatrice"));
    	decedentMother.setPatient(decedentReference);
    	contents.add(decedentMother);
    	
    	DecedentSpouse decedentSpouse = new DecedentSpouse();
    	decedentSpouse.addName(new HumanName().setFamily("Baden").addGiven("Teresa"));
    	decedentSpouse.setPatient(decedentReference);
    	contents.add(decedentSpouse);
    	
    	AutopsyPerformedIndicator autopsyPerformedIndicator = new AutopsyPerformedIndicator(yesCode);
    	autopsyPerformedIndicator.setSubject(decedentReference);
    	contents.add(autopsyPerformedIndicator);
    	
    	ConditionContributingToDeath ConditionContributingToDeath = new ConditionContributingToDeath();
    	ConditionContributingToDeath.setSubject(decedentReference);
    	ConditionContributingToDeath.setAsserter(new Reference(certifier));
    	ConditionContributingToDeath.setCode(new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","241006","Epilepsia partialis continua")));
    	ConditionContributingToDeath.setOnset(new Age().setValue(50));
    	contents.add(ConditionContributingToDeath);
    	
    	CauseOfDeathPathway causeOfDeathPathway = new CauseOfDeathPathway();
    	causeOfDeathPathway.setSource(certifierReference);
    	causeOfDeathPathway.addEntry(new ListEntryComponent().setItem(new Reference(ConditionContributingToDeath.getId())));
    	contents.add(causeOfDeathPathway);
    	
    	ConditionContributingToDeath conditionContributingToDeath = new ConditionContributingToDeath();
    	conditionContributingToDeath.setCode(new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","324007","Plaster ulcer")).setText("Plaster ulcer"));
    	contents.add(conditionContributingToDeath);
    	
    	DeathCertificateReference deathCertificateReference = new DeathCertificateReference(DocumentReferenceStatus.CURRENT);
    	deathCertificateReference.setSubject(decedentReference);
    	deathCertificateReference.setIndexed(rightNow);
    	deathCertificateReference.addAuthor(certifierReference);
    	deathCertificateReference.addContent();
    	contents.add(deathCertificateReference);
    	
    	DeathCertification deathCertification = new DeathCertification();
    	deathCertification.setPerformed(new DateTimeType(rightNow));
    	deathCertificate.addEvent(deathCertification);
    	contents.add(deathCertification);
    	
    	DeathDate deathDate = new DeathDate(rightNow);
    	deathDate.setSubject(decedentReference);
    	contents.add(deathDate);
    	
    	CodeableConcept deathLocationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/v3/RoleCode","wi","Wing"));
    	CodeableConcept physicalLocationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/location-physical-type","HOSP","Hospital"));
    	Address hospitalAddress = new Address().addLine("80 Jesse Hill Jr Dr SE").setCity("Atlanta")
    			.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.WORK);
    	DeathLocation deathLocation = new DeathLocation("Grady Hospital", "Grady Hospital of Atlanta",deathLocationType,hospitalAddress,deathLocationType);
    	contents.add(deathLocation);
    	
    	HumanName pronouncerName = new HumanName().setFamily("Bladerslad").addGiven("Bernard");
    	CodeableConcept qualifierCode = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/v2/0360/2.7","MD","Doctor of Medicine"));
    	DeathPronouncementPerformer deathPronouncementPerformer = new DeathPronouncementPerformer(pronouncerName,"1",qualifierCode);
    	contents.add(deathPronouncementPerformer);
    	
    	DecedentAge decedentAge = new DecedentAge();
    	decedentAge.setValue(new Quantity(79).setUnit("a"));
    	contents.add(decedentAge);
    	
    	CodeableConcept dispositionCode = new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","449971000124106","Burial"));
    	DecedentDispositionMethod decedentDispostionMethod = new DecedentDispositionMethod(dispositionCode);
    	decedentDispostionMethod.setSubject(decedentReference);
    	decedentDispostionMethod.addPerformer(certifierReference);
    	contents.add(decedentDispostionMethod);
    	
    	CodeableConcept industryCode = new CodeableConcept().addCoding(new Coding("http://loinc.org","21844-6",""));
    	CodeableConcept occupationCode = new CodeableConcept().addCoding(new Coding("http://loinc.org","21847-9",""));
    	DecedentEmploymentHistory decedentEmploymentHistory = new DecedentEmploymentHistory(yesCode,industryCode,occupationCode);
    	decedentEmploymentHistory.setSubject(decedentReference);
    	contents.add(decedentEmploymentHistory);
    	
    	DecedentPregnancy decedentPregnancy = new DecedentPregnancy(noCode);
    	decedentPregnancy.setSubject(decedentReference);
    	contents.add(decedentPregnancy);
    	
    	CodeableConcept transportationRoleCode = new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","1","Vechicle driver"));
    	DecedentTransportationRole decedentTransportationRole = new DecedentTransportationRole(transportationRoleCode);
    	decedentTransportationRole.setSubject(decedentReference);
    	contents.add(decedentTransportationRole);
    	
    	DispositionLocation dispositionLocation = new DispositionLocation(hospitalAddress);
    	contents.add(dispositionLocation);
    	
    	ExaminerContacted examinerContacted = new ExaminerContacted(true);
    	examinerContacted.setSubject(decedentReference);
    	contents.add(examinerContacted);
    	
    	FuneralHome funeralHome = new FuneralHome("Home Bodies Funeral Services", hospitalAddress);
    	contents.add(funeralHome);
    	
    	Mortician mortician = new Mortician(pronouncerName,"1",qualifierCode);
    	contents.add(mortician);
    	
    	CodeableConcept doctorRole = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/practitioner-role","doctor","Doctor"));
    	FuneralHomeDirector funeralHomeDirector = new FuneralHomeDirector(doctorRole);
    	funeralHomeDirector.setPractitioner(new Reference(mortician.getId()));
    	funeralHomeDirector.setOrganization(new Reference(funeralHome.getId()));
    	contents.add(funeralHomeDirector);
    	
    	InjuryIncident injuryIncident = new InjuryIncident(decedent, "Head", noCode, noCode);
    	contents.add(injuryIncident);
    	
    	InjuryLocation injuryLocation = new InjuryLocation();
    	injuryLocation.setName("Hospital");
    	injuryLocation.setDescription("Gracie Hospital");
    	injuryLocation.setType(new CodeableConcept().addCoding(new Coding().setCode("HOSP").setSystem("http://hl7.org/fhir/ValueSet/v3-ServiceDeliveryLocationRoleType")));
    	injuryLocation.setPhysicalType(new CodeableConcept().addCoding(new Coding().setCode("ro").setSystem("http://hl7.org/fhir/ValueSet/location-physical-type")));
    	injuryLocation.setAddress(decedentsHome);
    	deathCertificate.setSubject(decedentReference);
    	contents.add(injuryLocation);
    	
    	CodeableConcept organizationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/ValueSet/organization-type","dept","Hospital Department"));
    	InterestedParty interestedParty = new InterestedParty("54673-2",true,organizationType,"Grady Hospital Associates",hospitalAddress);
    	contents.add(interestedParty);
    	
    	CodeableConcept manner = new CodeableConcept().addCoding(new Coding("http://www.hl7.org/fhir/stu3/valueset-MannerTypeVS","7878000","Accident"));
    	MannerOfDeath mannerOfDeath = new MannerOfDeath(manner,decedent,certifier);
    	contents.add(mannerOfDeath);
    	
    	TobaccoUseContributedToDeath tobaccoUseContributedToDeath = new TobaccoUseContributedToDeath(false);
    	tobaccoUseContributedToDeath.setSubject(decedentReference);
    	contents.add(tobaccoUseContributedToDeath);
    	
    	for(Resource resource:contents) {
    		CommonUtil.addSection(deathCertificate, resource);
    		CommonUtil.addBundleEntry(deathCertificateDocument,resource);
    	}
    	
    	String encoded = FhirContext.forDstu3().newJsonParser().encodeResourceToString(deathCertificateDocument);
    	System.out.println(encoded);
    	assertTrue( true );
    }
}