package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Composition;
import org.hl7.fhir.dstu3.model.Composition.CompositionStatus;

public class DeathCertificateUtil {
	public static final CompositionStatus status = CompositionStatus.FINAL;  
	public static final CodeableConcept typeFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("64297-5").setSystem("http://loinc.org"));
	public static final Composition.CompositionAttestationMode attesterMode = Composition.CompositionAttestationMode.LEGAL;
	public static final CodeableConcept eventCodeFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("308646001").setSystem("http://snomed.info/sct").setDisplay("Death certification (procedure)"));
}
