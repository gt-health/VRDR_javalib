package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;

public class DeathCertificationUtil {
	public static final CodeableConcept categoryFixedValue = new CodeableConcept().addCoding(new Coding().setCode("103693007"));
	public static final CodeableConcept codeFixedValue = new CodeableConcept().addCoding(new Coding().setCode("308646001")); 
}
