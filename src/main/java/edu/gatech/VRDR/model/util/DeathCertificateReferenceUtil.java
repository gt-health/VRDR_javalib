package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;

public class DeathCertificateReferenceUtil {
	public static final CodeableConcept type = new CodeableConcept()
			.addCoding(new Coding().setCode("64297-5").setSystem("http://loinc.org"));
}
