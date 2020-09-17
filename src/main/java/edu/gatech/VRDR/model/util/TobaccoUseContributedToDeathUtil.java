package edu.gatech.VRDR.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class TobaccoUseContributedToDeathUtil {
	public static final ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding().setSystem("http://loinc.org").setCode("69443-0"));
	public static final String codeValueSystem = "2.16.840.1.114222.4.11.6004";
	public static final CodeableConcept VALUE_YESCODE = new CodeableConcept().addCoding(new Coding().setCode("373066001").setSystem(codeValueSystem).setDisplay("Yes"));
	public static final CodeableConcept VALUE_NOCODE = new CodeableConcept().addCoding(new Coding().setCode("373067005").setSystem(codeValueSystem).setDisplay("No"));
	public static final CodeableConcept VALUE_PROBABLECODE = new CodeableConcept().addCoding(new Coding().setCode("2931005").setSystem(codeValueSystem).setDisplay("Probable diagnosis"));
	public static final CodeableConcept VALUE_UNKNOWNCODE = new CodeableConcept().addCoding(new Coding().setCode("UNK").setSystem(codeValueSystem).setDisplay("Unknown"));
	public static final CodeableConcept VALUE_NOTASKEDCODE = new CodeableConcept().addCoding(new Coding().setCode("373066001").setSystem(codeValueSystem).setDisplay("not asked"));
	public static List<CodeableConcept> valueCodesetList = new ArrayList<CodeableConcept>(Arrays.asList(VALUE_YESCODE,VALUE_NOCODE,VALUE_PROBABLECODE,VALUE_UNKNOWNCODE,VALUE_NOTASKEDCODE));
}