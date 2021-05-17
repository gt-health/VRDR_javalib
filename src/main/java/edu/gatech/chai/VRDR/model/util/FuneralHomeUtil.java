package edu.gatech.chai.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class FuneralHomeUtil {
	public static final CodeableConcept type = new CodeableConcept()
			.addCoding(new Coding().setSystem("http://terminology.hl7.org/CodeSystem/organization-type").setCode("bus").setDisplay("Non-Healthcare Business or Corporation"));
}