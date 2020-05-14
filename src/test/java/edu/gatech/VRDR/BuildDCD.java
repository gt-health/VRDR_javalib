package edu.gatech.VRDR;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.ListResource.ListEntryComponent;
import org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;

import edu.gatech.VRDR.model.AutopsyPerformedIndicator;
import edu.gatech.VRDR.model.BirthRecordIdentifier;
import edu.gatech.VRDR.model.CauseOfDeathCondition;
import edu.gatech.VRDR.model.CauseOfDeathPathway;
import edu.gatech.VRDR.model.Certifier;
import edu.gatech.VRDR.model.ConditionContributingToDeath;
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
import edu.gatech.VRDR.model.FuneralServiceLicensee;
import edu.gatech.VRDR.model.InjuryIncident;
import edu.gatech.VRDR.model.InjuryLocation;
import edu.gatech.VRDR.model.InterestedParty;
import edu.gatech.VRDR.model.MannerOfDeath;
import edu.gatech.VRDR.model.Mortician;
import edu.gatech.VRDR.model.TobaccoUseContributedToDeath;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentUtil;

public class BuildDCD {
	public static DeathCertificateDocument buildExampleDeathCertificateDocument() {
		//Useful Yes/No codeableconcept
    	//Normally, these would live in util/CommonUtil but,
    	//Demonstrated here in case you need to create your own custom codes
    	CodeableConcept noCode = new CodeableConcept().addCoding(new Coding("http://terminology.www.hl7.org/CodeSystem/v2-0136","N","No"));
    	CodeableConcept yesCode = new CodeableConcept().addCoding(new Coding("http://terminology.www.hl7.org/CodeSystem/v2-0136","Y","Yes"));
    	//DeathCertificateDocument contains the top-level item that represents the entire bundle
    	DeathCertificateDocument deathCertificateDocument = new DeathCertificateDocument();
    	deathCertificateDocument.setIdentifier(new Identifier().setValue("123"));
    	//DeathCertificate is the main fhir resource that contains sectional references to everything else
    	DeathCertificate deathCertificate = new DeathCertificate();
    	deathCertificateDocument.addEntry(new BundleEntryComponent().setResource(deathCertificate));
    	//Every subsequent resource must be added to a contents section
    	List<Resource> contents = new ArrayList<Resource>();
    	contents.add(deathCertificate);
    	//Decedent
    	Address decedentsHome = new Address().addLine("1808 Stroop Hill Road").setCity("Atlanta")
		.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.HOME);
    	Extension withinCityLimits = new Extension();
		withinCityLimits.setUrl(DecedentUtil.addressWithinCityLimitsIndicatorExtensionURL);
		withinCityLimits.setValue(new BooleanType(true));
		decedentsHome.addExtension(withinCityLimits);
    	Decedent decedent = new Decedent();
    	decedent.setGender(AdministrativeGender.MALE);
    	decedent.setRace("2106-3", "", "White");
    	decedent.setEthnicity("", "", "");
    	decedent.setBirthSex("M", "Male");
    	decedent.setBirthPlace(decedentsHome);
    	decedent.addIdentifier("1AN2BN3DE45");
    	decedent.addName(new HumanName().setFamily("Cleaveland").addGiven("Grover").setUse(NameUse.OFFICIAL));
    	decedent.setMaritalStatus(new CodeableConcept().addCoding(new Coding().setCode("S").setSystem("http://hl7.org/fhir/v3/MaritalStatus")));
    	Reference decedentReference = new Reference(decedent.getId());
    	deathCertificate.setSubject(decedentReference);
    	contents.add(decedent);
    	//Certifier
    	Certifier certifier = new Certifier();
    	certifier.addName(new HumanName().setFamily("Baden").addGiven("Michael").setUse(NameUse.OFFICIAL));
    	certifier.addAddress(new Address().addLine("256 Mount Olive Road").setCity("Atlata")
    			.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.WORK));
    	certifier.addQualification("12345","National provider identifier","MD");
    	Date rightNow = new Date();
    	deathCertificate.addAttester(certifier,rightNow);
    	Reference certifierReference = new Reference(certifier.getId());
    	contents.add(certifier);
    	
    	CodeableConcept gaState = new CodeableConcept().addCoding(new Coding("","32","Georgia"));
    	DateTimeType birthYear = new DateTimeType("1935-01-01");
    	BirthRecordIdentifier birthRecordIdentifier = new BirthRecordIdentifier("June 3rd 1935",gaState,birthYear);
    	birthRecordIdentifier.setSubject(decedentReference);
    	contents.add(birthRecordIdentifier);
    	//DecedentEducationLevel
    	//TODO: Make it easy to reference this Education level by string
    	DecedentEducationLevel decedentEducationLevel = new DecedentEducationLevel();
    	decedentEducationLevel.setValue(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/ValueSet/v3-EducationLevel","BD","College or baccalaureate degree complete")));
    	decedentEducationLevel.setSubject(decedentReference);
    	contents.add(decedentEducationLevel);
    	//RelatedPersons resources
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
    	//AutopsyPerformedIndicator: first bool is autopsyPerformed, 2nd is resultsAvailable
    	AutopsyPerformedIndicator autopsyPerformedIndicator = new AutopsyPerformedIndicator(false,false);
    	autopsyPerformedIndicator.setSubject(decedentReference);
    	contents.add(autopsyPerformedIndicator);
    	//CauseOfDeathCondition
    	CauseOfDeathCondition causeOfDeathCondition = new CauseOfDeathCondition();
    	causeOfDeathCondition.setSubject(decedentReference);
    	causeOfDeathCondition.setAsserter(certifierReference);
    	causeOfDeathCondition.setCode(new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","42343007","Congestive heart failure (disorder)")));
    	//ConditionContributingToDeath
    	ConditionContributingToDeath conditionContributingToDeath = new ConditionContributingToDeath();
    	conditionContributingToDeath.setSubject(decedentReference);
    	conditionContributingToDeath.setAsserter(certifierReference);
    	conditionContributingToDeath.setCode(new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","241006","Epilepsia partialis continua")));
    	contents.add(conditionContributingToDeath);
    	//CauseOfDeathPathway: this defines the cause of death pathway, it's a chain BEGINNING with the CauseOfDeathCondition
    	//Other CauseOfDeathPathways can link to other CauseOfDeathPathways, creating a chain
    	CauseOfDeathPathway causeOfDeathPathway = new CauseOfDeathPathway();
    	causeOfDeathPathway.setSource(certifierReference);
    	causeOfDeathPathway.addEntry(new ListEntryComponent().setItem(new Reference(causeOfDeathCondition.getId())));
    	causeOfDeathPathway.getEntry().add(new ListEntryComponent().setItem(new Reference(conditionContributingToDeath.getId())));
    	contents.add(causeOfDeathPathway);
    	//DeathCertificateReference: use if you have an attachment you can link as a file reference to the death certificate
    	DeathCertificateReference deathCertificateReference = new DeathCertificateReference(DocumentReferenceStatus.CURRENT);
    	deathCertificateReference.setSubject(decedentReference);
    	deathCertificateReference.setDate(rightNow);
    	deathCertificateReference.addAuthor(certifierReference);
    	deathCertificateReference.addDeathCertificateURL("https://www.examplemecfilestore.com/some/filepath/to/thisdocument.pdf");
    	contents.add(deathCertificateReference);
    	//DeathCertification: represent the event of certification
    	DeathCertification deathCertification = new DeathCertification();
    	deathCertification.setPerformed(new DateTimeType(rightNow));
		CodeableConcept certifierTypeCode = new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","440051000124108","Medical Examiner"));
		deathCertification.addPerformer(certifier, certifierTypeCode);
    	deathCertificate.addEvent(deathCertification);
    	contents.add(deathCertification);
    	//DeathDate
    	DeathDate deathDate = new DeathDate(rightNow,rightNow);
    	deathDate.setSubject(decedentReference);
    	contents.add(deathDate);
    	//DeathLocation
    	CodeableConcept deathLocationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/v3/RoleCode","wi","Wing"));
    	CodeableConcept physicalLocationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/location-physical-type","HOSP","Hospital"));
    	Address hospitalAddress = new Address().addLine("80 Jesse Hill Jr Dr SE").setCity("Atlanta")
    			.setState("GA").setPostalCode("30303").setCountry("USA").setUse(AddressUse.WORK);
    	DeathLocation deathLocation = new DeathLocation("Grady Hospital", "Grady Hospital of Atlanta",deathLocationType,hospitalAddress,deathLocationType);
    	contents.add(deathLocation);
    	deathDate.addPatientLocationExtension(deathLocation);
    	//DeathPronouncementPerformer
    	HumanName pronouncerName = new HumanName().setFamily("Bladerslad").addGiven("Bernard");
    	CodeableConcept qualifierCode = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/v2/0360/2.7","MD","Doctor of Medicine"));
    	DeathPronouncementPerformer deathPronouncementPerformer = new DeathPronouncementPerformer(pronouncerName,"1",qualifierCode);
    	contents.add(deathPronouncementPerformer);
    	//DecedentAge
    	DecedentAge decedentAge = new DecedentAge();
    	decedentAge.setValue(new Quantity(79).setUnit("a"));
    	contents.add(decedentAge);
    	//DecedentDispositionMethod
    	DecedentDispositionMethod decedentDispostionMethod = new DecedentDispositionMethod("Burial");
    	decedentDispostionMethod.setSubject(decedentReference);
    	decedentDispostionMethod.addPerformer(certifierReference);
    	contents.add(decedentDispostionMethod);
    	//DecedentEmploymentHistory
    	CodeableConcept industryCode = new CodeableConcept().addCoding(new Coding("http://loinc.org","21844-6",""));
    	CodeableConcept occupationCode = new CodeableConcept().addCoding(new Coding("http://loinc.org","21847-9",""));
    	DecedentEmploymentHistory decedentEmploymentHistory = new DecedentEmploymentHistory(yesCode,industryCode,occupationCode);
    	
    	decedentEmploymentHistory.setSubject(decedentReference);
    	contents.add(decedentEmploymentHistory);
    	//DecedentPregnancy
    	DecedentPregnancy decedentPregnancy = new DecedentPregnancy("No");
    	decedentPregnancy.setSubject(decedentReference);
    	contents.add(decedentPregnancy);
    	//DecedentTransportationRole
    	CodeableConcept transportationRoleCode = new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","1","Vechicle driver"));
    	DecedentTransportationRole decedentTransportationRole = new DecedentTransportationRole(transportationRoleCode);
    	decedentTransportationRole.setSubject(decedentReference);
    	contents.add(decedentTransportationRole);
    	//DispositionLocation
    	DispositionLocation dispositionLocation = new DispositionLocation(hospitalAddress);
    	contents.add(dispositionLocation);
    	//ExaminerContacted
    	ExaminerContacted examinerContacted = new ExaminerContacted(true);
    	examinerContacted.setSubject(decedentReference);
    	contents.add(examinerContacted);
    	//FuneralHome
    	FuneralHome funeralHome = new FuneralHome("Home Bodies Funeral Services", hospitalAddress);
    	contents.add(funeralHome);
    	//Mortician
    	Mortician mortician = new Mortician(pronouncerName,"1",qualifierCode);
    	contents.add(mortician);
    	//FuneralServiceLicensee
    	CodeableConcept doctorRole = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/practitioner-role","doctor","Doctor"));
    	FuneralServiceLicensee funeralServiceLicensee = new FuneralServiceLicensee(doctorRole);
    	funeralServiceLicensee.setPractitioner(new Reference(mortician.getId()));
    	funeralServiceLicensee.setOrganization(new Reference(funeralHome.getId()));
    	contents.add(funeralServiceLicensee);
    	//InjuryIncident
    	InjuryIncident injuryIncident = new InjuryIncident(decedent, "Head", noCode, noCode);
    	contents.add(injuryIncident);
    	//InjuryLocation
    	InjuryLocation injuryLocation = new InjuryLocation();
    	injuryLocation.setName("Hospital");
    	injuryLocation.setDescription("Gracie Hospital");
    	injuryLocation.addType(new CodeableConcept().addCoding(new Coding().setCode("HOSP").setSystem("http://hl7.org/fhir/ValueSet/v3-ServiceDeliveryLocationRoleType")));
    	injuryLocation.setPhysicalType(new CodeableConcept().addCoding(new Coding().setCode("ro").setSystem("http://hl7.org/fhir/ValueSet/location-physical-type")));
    	injuryLocation.setAddress(decedentsHome);
    	contents.add(injuryLocation);
    	//InterestedParty
    	CodeableConcept organizationType = new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/ValueSet/organization-type","dept","Hospital Department"));
    	InterestedParty interestedParty = new InterestedParty("54673-2",true,organizationType,"Grady Hospital Associates",hospitalAddress);
    	contents.add(interestedParty);
    	//MannerOfDeath
    	CodeableConcept manner = new CodeableConcept().addCoding(new Coding("http://www.hl7.org/fhir/stu3/valueset-MannerTypeVS","7878000","Accident"));
    	MannerOfDeath mannerOfDeath = new MannerOfDeath(manner,decedent,certifier);
    	contents.add(mannerOfDeath);
    	//TobaccoUseContributedToDeath
    	TobaccoUseContributedToDeath tobaccoUseContributedToDeath = new TobaccoUseContributedToDeath("Yes");
    	tobaccoUseContributedToDeath.setSubject(decedentReference);
    	contents.add(tobaccoUseContributedToDeath);
    	
    	for(Resource resource:contents) {
    		CommonUtil.addSectionEntry(deathCertificate, resource);
    		CommonUtil.addBundleEntry(deathCertificateDocument,resource);
    	}
    	return deathCertificateDocument;
	}
}
