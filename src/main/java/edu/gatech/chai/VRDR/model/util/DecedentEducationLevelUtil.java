package edu.gatech.chai.VRDR.model.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class DecedentEducationLevelUtil {
	public static final ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.loincSystemUrl, "80913-7", "Highest level of education [US Standard Certificate of Death]s"));
	public static final String codeValueSystem = "urn:oid:2.16.840.1.114222.4.5.274";
	private static final String educationLevelV3SystemUrl = "http://terminology.hl7.org/CodeSystem/v3-EducationLevel";
	private static final String educationLevelV2SystemUrl = "http://terminology.hl7.org/CodeSystem/v2-0360";
	public static final CodeableConcept VALUE_8THGRADE = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1448", "8th grade or less"));
	public static final CodeableConcept VALUE_12THGRADE = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1449", "9th through 12th grade; no diploma"));
	public static final CodeableConcept VALUE_HIGHSCHOOL = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1450", "High School Graduate or GED Completed"));
	public static final CodeableConcept VALUE_SOMECOLLEGE = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1451", "Some college credit, but not degree"));
	public static final CodeableConcept VALUE_ASSOCIATE = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1452", "Associate Degree"));
	public static final CodeableConcept VALUE_BACHELORS = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1453", "Bachelor's Degree"));
	public static final CodeableConcept VALUE_MASTERS = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1454", "Master's Degree"));
	public static final CodeableConcept VALUE_DOCTORATE = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"PHC1455", "Doctorate Degree or Professional Degree"));
	
	public static final HashSet<CodeableConcept> valueSet = new HashSet<CodeableConcept>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(educationLevelV3SystemUrl,"ELEM","Elementary School")),
			new CodeableConcept().addCoding(new Coding(educationLevelV3SystemUrl,"SEC","Some secondary or high school education")),
			new CodeableConcept().addCoding(new Coding(educationLevelV3SystemUrl,"HS","High School or secondary school degree complete")),
			new CodeableConcept().addCoding(new Coding(educationLevelV3SystemUrl,"SCOL","Some College education")),
			new CodeableConcept().addCoding(new Coding(educationLevelV2SystemUrl,"AA","Associate's or technical degree complete")),
			new CodeableConcept().addCoding(new Coding(educationLevelV2SystemUrl,"BA","Bachelor's degree")),
			new CodeableConcept().addCoding(new Coding(educationLevelV2SystemUrl,"MA","Master's degree")),
			new CodeableConcept().addCoding(new Coding(educationLevelV3SystemUrl,"POSTG","Doctoral or post graduate education")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.nullFlavorHL7System,"UNK","Unknown"))));
}
