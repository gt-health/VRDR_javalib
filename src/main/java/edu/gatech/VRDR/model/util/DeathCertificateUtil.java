package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Composition;

public class DeathCertificateUtil {
	public static final CodeableConcept typeFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("64297-5").setSystem("http://loinc.org"));
	public static final Composition.CompositionAttestationMode attesterMode = Composition.CompositionAttestationMode.LEGAL;
	public static final CodeableConcept eventCodeFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("103693007").setSystem("http://snomed.info/sct"));
}
