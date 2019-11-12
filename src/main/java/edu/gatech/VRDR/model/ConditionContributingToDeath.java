package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Condition;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Condition-Contributing-To-Death")
public class ConditionContributingToDeath extends Condition {
	public ConditionContributingToDeath() {
		super();
		CommonUtil.initResource(this);
	}
	
	public void setCertifier(Certifier certifier) {
		Reference reference = new Reference(certifier.getId());
		this.asserter = reference;
	}
	public void setAsserter(Certifier certifier) {
		setCertifier(certifier);
	}
	
	public Reference getCertifier() {
		return asserter;
	}
}