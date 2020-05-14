package edu.gatech.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentTransportationRoleUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Transportation-Role")
public class DecedentTransportationRole extends Observation {
	public DecedentTransportationRole() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentTransportationRoleUtil.status);
		setCode(DecedentTransportationRoleUtil.code);
	}
	public DecedentTransportationRole(CodeableConcept value) {
		this();
		setValue(value);
	}
}