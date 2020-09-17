package edu.gatech.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class AutopsyPerformedIndicatorUtil {
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding("http://loinc.org", "85699-7", "Autopsy was performed"));
	public static final CodeableConcept componentAutopsyResultsAvailableCode = new CodeableConcept()
			.addCoding(new Coding("http://loinc.org", "69436-4", "Autopsy results available"));
	public static final ObservationStatus status = Observation.ObservationStatus.FINAL;
}
