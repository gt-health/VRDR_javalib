package edu.gatech.VRDR.model;

import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Cause-Of-Death-Condition")
public class CauseOfDeathCondition extends Condition {
	public CauseOfDeathCondition() {
		super();
		CommonUtil.initResource(this);
	}
	
	public void setDecedent(Decedent decedent) {
		Reference reference = new Reference(decedent.getId());
		this.subject = reference;
	}
	
	public void setSubject(Decedent decedent) {
		setDecedent(decedent);
	}
	
	public Reference getDecedent() {
		return subject;
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