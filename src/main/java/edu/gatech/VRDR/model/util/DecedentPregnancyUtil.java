package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;

public class DecedentPregnancyUtil {
	public static final Observation.ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding().setSystem("http://loinc.org").setCode("69442-2")
					.setDisplay("Timing of recent pregnancy in relation to death"));
	public static final String codeValueSystem = "2.16.840.1.114222.4.11.6003";
	public static final CodeableConcept VALUE_NOCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1260").setSystem(codeValueSystem).setDisplay("Not pregnant within past year"));
	public static final CodeableConcept VALUE_YESCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1261").setSystem(codeValueSystem).setDisplay("Pregnant at the time of death"));
	public static final CodeableConcept VALUE_42DAYSCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1262").setSystem(codeValueSystem).setDisplay("Not pregnant, but pregnant within 42 days of death"));
	public static final CodeableConcept VALUE_1YEARCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1263").setSystem(codeValueSystem).setDisplay("Not pregnant, but pregnant 43 days to 1 year before death"));
	public static final CodeableConcept VALUE_UNKNOWNCODE = new CodeableConcept().addCoding(new Coding().setCode("PHC1264").setSystem(codeValueSystem).setDisplay("Unknown if pregnant within the past year"));
	public static final CodeableConcept VALUE_NACODE = new CodeableConcept().addCoding(new Coding().setCode("NA").setSystem(codeValueSystem).setDisplay("Not Applicable"));
}