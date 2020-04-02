package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.PractitionerRole;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "PractitionerRole", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR_FuneralServiceLicensee")
public class FuneralServiceLicensee extends PractitionerRole {
	public FuneralServiceLicensee() {
		super();
		//NOTE: Specifically not including id and meta tags from commonutil initresources
		//Been exempted from the profile
		//CommonUtil.initResource(this);
	}
	public FuneralServiceLicensee(CodeableConcept code) {
		this();
		addCode(code);
	}
}