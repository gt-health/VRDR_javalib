package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentTransportationRoleUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-decedent-transportation-role")
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
	
	public DecedentTransportationRole(String value) {
		this();
		setValue(value);
	}
	
	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, DecedentTransportationRoleUtil.valueCodesetList);
		if(concept != null) {
			setValue(concept);
		}
	}
}