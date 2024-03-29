package edu.gatech.chai.VRDR.model.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class DecedentPregnancyStatusUtil {
	public static final Observation.ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding().setSystem(CommonUtil.loincSystemUrl).setCode("69442-2")
					.setDisplay("Timing of recent pregnancy in relation to death"));
	public static final String codeValueSystem = "http://hl7.org/fhir/us/vrdr/CodeSystem/vrdr-pregnancy-status-cs";
	public static final CodeableConcept VALUE_NOCODE = new CodeableConcept().addCoding(new Coding().setCode("1").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Not pregnant within past year"));
	public static final CodeableConcept VALUE_YESCODE = new CodeableConcept().addCoding(new Coding().setCode("2").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Pregnant at the time of death"));
	public static final CodeableConcept VALUE_42DAYSCODE = new CodeableConcept().addCoding(new Coding().setCode("3").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Not pregnant, but pregnant within 42 days of death"));
	public static final CodeableConcept VALUE_1YEARCODE = new CodeableConcept().addCoding(new Coding().setCode("4").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Not pregnant, but pregnant 43 days to 1 year before death"));
	public static final CodeableConcept VALUE_UNKNOWNCODE = new CodeableConcept().addCoding(new Coding().setCode("9").setSystem(CommonUtil.snomedSystemUrl).setDisplay("Unknown if pregnant within the past year"));
	public static final HashSet<CodeableConcept> valueSet = new HashSet<>(Arrays.asList(
			VALUE_NOCODE,VALUE_YESCODE,VALUE_42DAYSCODE,VALUE_1YEARCODE,VALUE_UNKNOWNCODE,CommonUtil.notApplicableCode));
}