package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentTransportationRoleUtil;

@ResourceDef(name = "Observation", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Transportation-Role")
public class DecedentTransportationRole extends Observation {
	public DecedentTransportationRole(CodeableConcept value) {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentTransportationRoleUtil.status);
		setCode(DecedentTransportationRoleUtil.code);
		setValue(value);
	}
}