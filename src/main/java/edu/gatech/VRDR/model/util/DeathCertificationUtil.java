package edu.gatech.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class DeathCertificationUtil {
	public static final CodeableConcept categoryFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("103693007").setSystem("http://snomed.info/sct"));
	public static final CodeableConcept codeFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("308646001"));
}
