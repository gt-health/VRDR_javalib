package edu.gatech.chai.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

public class EmergingIssuesUtil {
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding().setSystem(CommonUtil.vrdrObservationCsUrl).setCode("emergingissues"));
	public static final ObservationStatus status = ObservationStatus.FINAL;
}