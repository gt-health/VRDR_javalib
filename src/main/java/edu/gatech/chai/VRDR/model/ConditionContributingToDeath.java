package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CauseOfDeathConditionUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.ConditionContributingToDeathUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Condition-Contributing-To-Death")
public class ConditionContributingToDeath extends Condition {
	public ConditionContributingToDeath() {
		super();
		CommonUtil.initResource(this);
		this.addCategory(ConditionContributingToDeathUtil.conditionContributingToDeathCategory);
	}
	
	public ConditionContributingToDeath(Decedent decedent) {
		super();
		CommonUtil.initResource(this);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setDecedent(decedent);
	}
	
	public ConditionContributingToDeath(Certifier certifier) {
		super();
		CommonUtil.initResource(this);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setCertifier(certifier);
	}
	
	public ConditionContributingToDeath(Decedent decedent,  Certifier certifier) {
		super();
		CommonUtil.initResource(this);
		setDecedent(decedent);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setCertifier(certifier);
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