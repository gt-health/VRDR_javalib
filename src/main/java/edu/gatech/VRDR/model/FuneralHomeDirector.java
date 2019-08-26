package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.PractitionerRole;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Funeral Home Director", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Funeral-Home-Director")
public class FuneralHomeDirector extends PractitionerRole {
	public FuneralHomeDirector(CodeableConcept code) {
		addCode(code);
	}
}