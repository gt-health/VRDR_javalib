package edu.gatech.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class BirthRecordIdentifierUtil {
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding("http://hl7.org/fhir/v2/0203", "BR", ""));
	public static final CodeableConcept componentBirthStateCode = new CodeableConcept()
			.addCoding(new Coding("http://loinc.org", "21842-0", ""));
	public static final String componentBirthStateValueCodeableConceptSystem = "urn:iso:std:iso:3166:-2";
	public static final CodeableConcept componentBirthYearCode = new CodeableConcept()
			.addCoding(new Coding("http://loinc.org", "80904-6", "Birth Year"));
	public static final ObservationStatus status = Observation.ObservationStatus.FINAL;
}