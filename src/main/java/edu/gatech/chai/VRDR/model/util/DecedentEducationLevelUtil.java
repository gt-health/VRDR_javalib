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
	public static final CodeableConcept VALUE_8THGRADE = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1448", "8th grade or less"));
	public static final CodeableConcept VALUE_12THGRADE = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1449", "9th through 12th grade; no diploma"));
	public static final CodeableConcept VALUE_HIGHSCHOOL = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1450", "High School Graduate or GED Completed"));
	public static final CodeableConcept VALUE_SOMECOLLEGE = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1451", "Some college credit, but not degree"));
	public static final CodeableConcept VALUE_ASSOCIATE = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1452", "Associate Degree"));
	public static final CodeableConcept VALUE_BACHELORS = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1453", "Bachelor's Degree"));
	public static final CodeableConcept VALUE_MASTERS = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1454", "Master's Degree"));
	public static final CodeableConcept VALUE_DOCTORATE = new CodeableConcept().addCoding(new Coding(codeValueSystem,"PHC1455", "Doctorate Degree or Professional Degree"));
	public static final HashSet<CodeableConcept> valueSet = new HashSet<>(Arrays.asList(
			VALUE_8THGRADE,VALUE_12THGRADE,VALUE_HIGHSCHOOL,VALUE_SOMECOLLEGE,VALUE_ASSOCIATE,VALUE_BACHELORS,
			VALUE_MASTERS,VALUE_DOCTORATE,CommonUtil.unknownCode));
}
