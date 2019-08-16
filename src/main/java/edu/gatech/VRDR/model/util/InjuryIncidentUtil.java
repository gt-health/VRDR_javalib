package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;

public class InjuryIncidentUtil {
	public static final ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.113883.3.290.2.1.19","11374-6","Injury incident description"));
	public static final CodeableConcept componentPlaceofInjuryCode = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.113883.6.1","69450-5","Place of injury"));
	public static final CodeableConcept componentInjuryAtWorkCode = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.113883.6.1","69448-9","Did death result from injury at work"));
	public static final CodeableConcept componentInjuryLeadingToDeathVechicleCode = new CodeableConcept().addCoding(new Coding("urn:oid:2.16.840.1.113883.6.1","69450-5","Injury leading to death associated with transportation event"));
}