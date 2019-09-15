package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Condition;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Condition-Contributing-To-Death")
public class ConditionContributingToDeath extends Condition {
	public ConditionContributingToDeath() {
		super();
		CommonUtil.initResource(this);
	}
}
