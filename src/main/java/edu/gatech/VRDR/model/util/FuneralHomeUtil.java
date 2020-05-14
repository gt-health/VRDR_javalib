package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;

public class FuneralHomeUtil {
	public static final CodeableConcept type = new CodeableConcept()
			.addCoding(new Coding().setCode("bus").setDisplay("Non-Healthcare Business or Corporation"));
}