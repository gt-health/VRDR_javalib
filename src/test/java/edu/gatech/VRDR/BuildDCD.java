package edu.gatech.VRDR;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.ListResource.ListEntryComponent;
import org.hl7.fhir.r4.model.MessageHeader;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.UriType;

import edu.gatech.chai.VRDR.model.AutopsyPerformedIndicator;
import edu.gatech.chai.VRDR.model.BirthRecordIdentifier;
import edu.gatech.chai.VRDR.model.CauseOfDeathCondition;
import edu.gatech.chai.VRDR.model.CauseOfDeathPathway;
import edu.gatech.chai.VRDR.model.Certifier;
import edu.gatech.chai.VRDR.model.ConditionContributingToDeath;
import edu.gatech.chai.VRDR.model.DeathCertificate;
import edu.gatech.chai.VRDR.model.DeathCertificateDocument;
import edu.gatech.chai.VRDR.model.DeathCertificateReference;
import edu.gatech.chai.VRDR.model.DeathCertification;
import edu.gatech.chai.VRDR.model.DeathDate;
import edu.gatech.chai.VRDR.model.DeathLocation;
import edu.gatech.chai.VRDR.model.DeathPronouncementPerformer;
import edu.gatech.chai.VRDR.model.Decedent;
import edu.gatech.chai.VRDR.model.DecedentAge;
import edu.gatech.chai.VRDR.model.DecedentDispositionMethod;
import edu.gatech.chai.VRDR.model.DecedentEducationLevel;
import edu.gatech.chai.VRDR.model.DecedentFather;
import edu.gatech.chai.VRDR.model.DecedentMilitaryService;
import edu.gatech.chai.VRDR.model.DecedentMother;
import edu.gatech.chai.VRDR.model.DecedentPregnancy;
import edu.gatech.chai.VRDR.model.DecedentSpouse;
import edu.gatech.chai.VRDR.model.DecedentTransportationRole;
import edu.gatech.chai.VRDR.model.DecedentUsualWork;
import edu.gatech.chai.VRDR.model.DispositionLocation;
import edu.gatech.chai.VRDR.model.ExaminerContacted;
import edu.gatech.chai.VRDR.model.FuneralHome;
import edu.gatech.chai.VRDR.model.FuneralServiceLicensee;
import edu.gatech.chai.VRDR.model.InjuryIncident;
import edu.gatech.chai.VRDR.model.InjuryLocation;
import edu.gatech.chai.VRDR.model.InterestedParty;
import edu.gatech.chai.VRDR.model.MannerOfDeath;
import edu.gatech.chai.VRDR.model.Mortician;
import edu.gatech.chai.VRDR.model.TobaccoUseContributedToDeath;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentUtil;

public class BuildDCD {
	public static DeathCertificateDocument buildExampleDeathCertificateDocument() {
    	//DeathCertificateDocument contains the top-level item that represents the entire bundle
    	DeathCertificateDocument deathCertificateDocument = new DeathCertificateDocument();
    	initResourceForTesting(deathCertificateDocument);
    	deathCertificateDocument.setIdentifier(new Identifier().setValue("123"));
    	//DeathCertificate is the main fhir resource that contains sectional references to everything else
    	DeathCertificate deathCertificate = new DeathCertificate();
    	initResourceForTesting(deathCertificate);
    	deathCertificateDocument.addEntry(new BundleEntryComponent().setResource(deathCertificate));
    	//Every subsequent resource must be added to a contents section
    	List<Resource> contents = new ArrayList<Resource>();
    	//Decedent
    	Decedent decedent = new Decedent();
    	initResourceForTesting(decedent);
    	Address decedentsHome = new Address().addLine("1808 Stroop Hill Road").setCity("Atlanta")
		.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.HOME);
    	Extension withinCityLimits = new Extension();
		withinCityLimits.setUrl(DecedentUtil.addressWithinCityLimitsIndicatorExtensionURL);
		withinCityLimits.setValue(new BooleanType(true));
		decedentsHome.addExtension(withinCityLimits);
    	decedent.setGender(AdministrativeGender.MALE);
    	decedent.setRace("2106-3", "", "White");
    	decedent.setEthnicity("", "", "");
    	decedent.setBirthSex("M", "Male");
    	decedent.setBirthPlace(decedentsHome);
    	decedent.addIdentifier("1AN2BN3DE45");
    	decedent.addName(new HumanName().setFamily("Wright").addGiven("Vivien Lee").setUse(NameUse.OFFICIAL));
    	Reference decedentReference = new Reference(decedent.getId());
    	deathCertificate.setSubject(decedentReference);
    	contents.add(decedent);
    	//Certifier
    	Certifier certifier = new Certifier();
    	initResourceForTesting(certifier);
    	certifier.addName(new HumanName().setFamily("Black").addGiven("Jim").setUse(NameUse.OFFICIAL));
    	certifier.addAddress(new Address().addLine("44 South Street").setCity("Bird in Hand")
    			.setState("PA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.WORK));
    	certifier.addQualification("12345","Medical Examiner/Coroner");
    	Calendar myCalendar = Calendar.getInstance();
    	myCalendar.set(2021, 2, 11);
    	Date today = myCalendar.getTime();
    	deathCertificate.addAttester(certifier,today);
    	Reference certifierReference = new Reference(certifier.getId());
    	contents.add(certifier);
    	
    	CodeableConcept gaState = new CodeableConcept().addCoding(new Coding("","32","Georgia"));
    	DateTimeType birthYear = new DateTimeType("1935");
    	BirthRecordIdentifier birthRecordIdentifier = new BirthRecordIdentifier("June 3rd 1935",gaState,birthYear);
		initResourceForTesting(birthRecordIdentifier);
    	birthRecordIdentifier.setSubject(decedentReference);
    	contents.add(birthRecordIdentifier);
    	//DecedentEducationLevel
    	DecedentEducationLevel decedentEducationLevel = new DecedentEducationLevel("Bachelor's Degree");
    	initResourceForTesting(decedentEducationLevel);
    	decedentEducationLevel.setValue(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/ValueSet/v3-EducationLevel","BD","College or baccalaureate degree complete")));
    	decedentEducationLevel.setSubject(decedentReference);
    	contents.add(decedentEducationLevel);
    	//RelatedPersons resources
    	DecedentFather decedentFather = new DecedentFather();
    	initResourceForTesting(decedentFather);
    	decedentFather.addName(new HumanName().setFamily("Baden").addGiven("George"));
    	decedentFather.setPatient(decedentReference);
    	contents.add(decedentFather);
    	
    	DecedentMother decedentMother = new DecedentMother();
    	initResourceForTesting(decedentMother);
    	decedentMother.addName(new HumanName().setFamily("Baden").addGiven("Beatrice"));
    	decedentMother.setPatient(decedentReference);
    	contents.add(decedentMother);
    	
    	DecedentSpouse decedentSpouse = new DecedentSpouse();
    	initResourceForTesting(decedentSpouse);
    	decedentSpouse.addName(new HumanName().setFamily("Baden").addGiven("Teresa"));
    	decedentSpouse.setPatient(decedentReference);
    	contents.add(decedentSpouse);
    	//AutopsyPerformedIndicator: first string is autopsyPerformed, 2nd is resultsAvailable
    	AutopsyPerformedIndicator autopsyPerformedIndicator = new AutopsyPerformedIndicator("No","No");
    	initResourceForTesting(autopsyPerformedIndicator);
    	autopsyPerformedIndicator.setSubject(decedentReference);
    	contents.add(autopsyPerformedIndicator);
    	//CauseOfDeathCondition
    	CauseOfDeathCondition causeOfDeathCondition = new CauseOfDeathCondition();
    	initResourceForTesting(causeOfDeathCondition);
    	causeOfDeathCondition.setDecedent(decedent);
    	causeOfDeathCondition.setAsserter(certifierReference);
    	causeOfDeathCondition.setCode(new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","42343007","Congestive heart failure (disorder)")));
    	contents.add(causeOfDeathCondition);
    	//ConditionContributingToDeath
    	ConditionContributingToDeath conditionContributingToDeath = new ConditionContributingToDeath();
    	initResourceForTesting(conditionContributingToDeath);
    	conditionContributingToDeath.setSubject(decedentReference);
    	conditionContributingToDeath.setAsserter(certifierReference);
    	conditionContributingToDeath.setCode(new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","241006","Epilepsia partialis continua")));
    	contents.add(conditionContributingToDeath);
    	//CauseOfDeathPathway: this defines the cause of death pathway, it's a chain BEGINNING with the CauseOfDeathCondition
    	CauseOfDeathPathway causeOfDeathPathway = new CauseOfDeathPathway();
    	initResourceForTesting(causeOfDeathPathway);
    	causeOfDeathPathway.setSource(certifierReference);
    	causeOfDeathPathway.addEntry(new ListEntryComponent().setItem(new Reference(causeOfDeathCondition.getId())));
    	contents.add(causeOfDeathPathway);
    	//DeathCertificateReference: use if you have an attachment you can link as a file reference to the death certificate
    	DeathCertificateReference deathCertificateReference = new DeathCertificateReference(DocumentReferenceStatus.CURRENT);
		initResourceForTesting(deathCertificateReference);
    	deathCertificateReference.setSubject(decedentReference);
    	deathCertificateReference.setDate(today);
    	deathCertificateReference.addAuthor(certifierReference);
    	deathCertificateReference.addDeathCertificateURL("https://www.examplemecfilestore.com/some/filepath/to/thisdocument.pdf");
    	contents.add(deathCertificateReference);
    	//DeathCertification: represent the event of certification
    	DeathCertification deathCertification = new DeathCertification();
    	initResourceForTesting(deathCertification);
    	deathCertification.setPerformed(new DateTimeType(today));
		deathCertification.addPerformer(certifier, "Medical Examiner/Coroner");
    	deathCertificate.addEvent(deathCertification);
    	contents.add(deathCertification);
    	//DeathDate
    	DeathDate deathDate = new DeathDate(today,today);
    	initResourceForTesting(deathDate);
    	deathDate.setSubject(decedentReference);
    	contents.add(deathDate);
    	//DeathLocation
    	CodeableConcept deathLocationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/v3/RoleCode","wi","Wing"));
    	CodeableConcept physicalLocationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/location-physical-type","HOSP","Hospital"));
    	Address hospitalAddress = new Address().addLine("80 Jesse Hill Jr Dr SE").setCity("Atlanta")
    			.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.WORK);
    	DeathLocation deathLocation = new DeathLocation("Grady Hospital", "Grady Hospital of Atlanta",deathLocationType,hospitalAddress,physicalLocationType);
    	initResourceForTesting(deathLocation);
    	contents.add(deathLocation);
    	deathDate.addPatientLocationExtension(deathLocation);
    	//DeathPronouncementPerformer
    	HumanName pronouncerName = new HumanName().setFamily("Bladerslad").addGiven("Bernard");
    	CodeableConcept qualifierCode = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/v2/0360/2.7","MD","Doctor of Medicine"));
    	DeathPronouncementPerformer deathPronouncementPerformer = new DeathPronouncementPerformer(pronouncerName,"1",qualifierCode);
    	initResourceForTesting(deathPronouncementPerformer);
    	contents.add(deathPronouncementPerformer);
    	//DecedentAge
    	DecedentAge decedentAge = new DecedentAge();
		initResourceForTesting(decedentAge);
    	decedentAge.setValue(new Quantity(79).setUnit("a"));
    	contents.add(decedentAge);
    	//DecedentDispositionMethod
    	DecedentDispositionMethod decedentDispostionMethod = new DecedentDispositionMethod("Burial");
    	decedentDispostionMethod.setSubject(decedentReference);
    	decedentDispostionMethod.addPerformer(certifierReference);
    	initResourceForTesting(decedentDispostionMethod);
    	contents.add(decedentDispostionMethod);
    	//DecedentUsualWork
    	CodeableConcept occupationCode = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.114222.4.5.314","1330","Agricultural engineers"));
    	CodeableConcept industryCode = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.114222.4.5.315","2180","Agricultural chemical manufacturing"));
    	Integer occupationYears = new Integer(15);
    	DecedentUsualWork decedentUsualWork = new DecedentUsualWork(occupationCode,industryCode,occupationYears);
    	decedentUsualWork.setSubject(decedentReference);
    	initResourceForTesting(decedentUsualWork);
    	contents.add(decedentUsualWork);
    	//DecedentMilitaryService 
    	DecedentMilitaryService decedentMilitaryService = new DecedentMilitaryService(CommonUtil.yesCode);
    	decedentMilitaryService.setSubject(decedentReference);
    	initResourceForTesting(decedentMilitaryService);
    	contents.add(decedentUsualWork);
    	//DecedentPregnancy
    	DecedentPregnancy decedentPregnancy = new DecedentPregnancy("No");
    	decedentPregnancy.setSubject(decedentReference);
    	initResourceForTesting(decedentPregnancy);
    	contents.add(decedentPregnancy);
    	//DecedentTransportationRole
    	DecedentTransportationRole decedentTransportationRole = new DecedentTransportationRole("Driver/Operator");
    	decedentTransportationRole.setSubject(decedentReference);
    	initResourceForTesting(decedentTransportationRole);
    	contents.add(decedentTransportationRole);
    	//DispositionLocation
    	DispositionLocation dispositionLocation = new DispositionLocation(hospitalAddress);
    	initResourceForTesting(dispositionLocation);
    	contents.add(dispositionLocation);
    	//ExaminerContacted
    	ExaminerContacted examinerContacted = new ExaminerContacted(true);
    	examinerContacted.setSubject(decedentReference);
    	initResourceForTesting(examinerContacted);
    	contents.add(examinerContacted);
    	//FuneralHome
    	FuneralHome funeralHome = new FuneralHome("Home Bodies Funeral Services", hospitalAddress);
    	initResourceForTesting(funeralHome);
    	contents.add(funeralHome);
    	//Mortician
    	Mortician mortician = new Mortician(pronouncerName,"1",qualifierCode);
    	initResourceForTesting(mortician);
    	contents.add(mortician);
    	//FuneralServiceLicensee
    	CodeableConcept doctorRole = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/practitioner-role","doctor","Doctor"));
    	FuneralServiceLicensee funeralServiceLicensee = new FuneralServiceLicensee(doctorRole);
    	funeralServiceLicensee.setPractitioner(new Reference(mortician.getId()));
    	funeralServiceLicensee.setOrganization(new Reference(funeralHome.getId()));
    	initResourceForTesting(funeralServiceLicensee);
    	contents.add(funeralServiceLicensee);
    	//InjuryIncident
    	InjuryIncident injuryIncident = new InjuryIncident(decedent, "Home", "No", "No");
    	initResourceForTesting(injuryIncident);
    	contents.add(injuryIncident);
    	//InjuryLocation
    	InjuryLocation injuryLocation = new InjuryLocation();
    	injuryLocation.setName("Hospital");
    	injuryLocation.setDescription("Gracie Hospital");
    	injuryLocation.addType(new CodeableConcept().addCoding(new Coding().setCode("HOSP").setSystem("http://hl7.org/fhir/ValueSet/v3-ServiceDeliveryLocationRoleType")));
    	injuryLocation.setPhysicalType(new CodeableConcept().addCoding(new Coding().setCode("ro").setSystem("http://hl7.org/fhir/ValueSet/location-physical-type")));
    	injuryLocation.setAddress(decedentsHome);
    	initResourceForTesting(injuryLocation);
    	contents.add(injuryLocation);
    	//InterestedParty
    	CodeableConcept organizationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/ValueSet/organization-type","dept","Hospital Department"));
    	InterestedParty interestedParty = new InterestedParty("54673-2",true,organizationType,"Grady Hospital Associates",hospitalAddress);
    	initResourceForTesting(interestedParty);
    	contents.add(interestedParty);
    	//MannerOfDeath
    	MannerOfDeath mannerOfDeath = new MannerOfDeath("Accidental death",decedent,certifier);
    	initResourceForTesting(mannerOfDeath);
    	contents.add(mannerOfDeath);
    	//TobaccoUseContributedToDeath
    	TobaccoUseContributedToDeath tobaccoUseContributedToDeath = new TobaccoUseContributedToDeath("Yes");
    	tobaccoUseContributedToDeath.setSubject(decedentReference);
    	initResourceForTesting(tobaccoUseContributedToDeath);
    	contents.add(tobaccoUseContributedToDeath);
    	
    	for(Resource resource:contents) {
    		CommonUtil.addSectionEntry(deathCertificate, resource);
    		CommonUtil.addBundleEntry(deathCertificateDocument,resource);
    	}
    	return deathCertificateDocument;
	}
	
	private static void initResourceForTesting(Resource resource) {
		CommonUtil.setUUID(resource);
	}
}
