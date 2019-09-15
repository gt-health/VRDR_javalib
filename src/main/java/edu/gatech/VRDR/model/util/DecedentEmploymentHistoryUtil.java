package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;

public class DecedentEmploymentHistoryUtil {
	public static final Observation.ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding().setSystem("http://loinc.org").setCode("74165-2"));
	public static final CodeableConcept componentMilitaryServiceCode = new CodeableConcept()
			.addCoding(new Coding().setSystem("http://loinc.org").setCode("55280-2"));
	public static final CodeableConcept componentUsualIndustryCode = new CodeableConcept()
			.addCoding(new Coding().setSystem("http://loinc.org").setCode("21844-6"));
	public static final CodeableConcept componentUsualOccupationCode = new CodeableConcept()
			.addCoding(new Coding().setSystem("http://loinc.org").setCode("21847-9"));
}