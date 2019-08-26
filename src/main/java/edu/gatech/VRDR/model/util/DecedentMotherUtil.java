package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;

public class DecedentMotherUtil {
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v3-RoleCode", "MTH", "mother"));
}