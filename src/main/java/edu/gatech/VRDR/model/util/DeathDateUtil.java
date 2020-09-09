package edu.gatech.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class DeathDateUtil {
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding("http://loinc.org", "81956-5", "Date and time of death"));
	public static final ObservationStatus status = ObservationStatus.FINAL;
	public static final String patientLocationExtensionURL = "http://hl7.org/fhir/us/vrdr/StructureDefinition/Observation-Location";
	public static final CodeableConcept componentDatePronouncedDeadCode = new CodeableConcept()
			.addCoding(new Coding("http://loinc.org", "81616-6", "Date and time pronounced dead"));
	public static final CodeableConcept method = new CodeableConcept()
			.addCoding(new Coding("urn:oid:2.16.840.1.113883.6.96", "414135002", "Estimated"));
}