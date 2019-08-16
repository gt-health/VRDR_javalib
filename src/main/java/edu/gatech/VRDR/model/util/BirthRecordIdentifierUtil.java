package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;

public class BirthRecordIdentifierUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.113883.6.290","BR",""));
	public static final CodeableConcept componentBirthStateCode = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.113883.6.1","21842-0",""));
	public static final String componentBirthStateValueCodeableConceptSystem = "ISO 3166-1";
	public static final CodeableConcept componentBirthYearCode = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.113883.6.290","21112-8",""));
	public static final ObservationStatus status = Observation.ObservationStatus.FINAL;
}