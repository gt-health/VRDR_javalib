package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.PractitionerRole;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "PractitionerRole", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR_FuneralServiceLicensee")
public class FuneralServiceLicensee extends PractitionerRole {
	public FuneralServiceLicensee() {
		super();
		CommonUtil.initResource(this);
	}
	public FuneralServiceLicensee(CodeableConcept code) {
		this();
		addCode(code);
	}
}