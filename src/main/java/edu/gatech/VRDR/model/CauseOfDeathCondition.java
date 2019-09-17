package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Condition;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Cause-Of-Death-Condition")
public class CauseOfDeathCondition extends Condition {
	public CauseOfDeathCondition() {
		super();
		CommonUtil.initResource(this);
	}
}