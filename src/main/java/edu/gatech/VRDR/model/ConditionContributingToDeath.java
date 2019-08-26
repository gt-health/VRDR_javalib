package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Condition;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Condition Contributing To Death", profile = "http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Condition-Contributintg-To-Death")
public class ConditionContributingToDeath extends Condition {
	public ConditionContributingToDeath() {
		super();
	}
}
