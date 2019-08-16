package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;

public class MannerOfDeathUtil {
	public static final ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept().addCoding(new Coding("http://loinc.org","69449-7","Manner of death"));
}