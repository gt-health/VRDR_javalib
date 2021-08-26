package edu.gatech.chai.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class DeathDateUtil {
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.loincSystemUrl, "81956-5", "Date+time of death"));
	public static final ObservationStatus status = ObservationStatus.FINAL;
	public static final String patientLocationExtensionURL = "http://hl7.org/fhir/us/vrdr/StructureDefinition/Observation-Location";
	public static final CodeableConcept componentDatePronouncedDeadCode = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.loincSystemUrl, "80616-6", "Date and time pronounced dead [US Standard Certificate of Death]"));
	public static final CodeableConcept method = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.snomedSystemUrl, "414135002", "Estimated"));
}