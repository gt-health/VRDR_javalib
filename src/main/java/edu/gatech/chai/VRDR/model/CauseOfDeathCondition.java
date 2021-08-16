package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CauseOfDeathConditionUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Condition", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Cause-Of-Death-Condition")
public class CauseOfDeathCondition extends Condition {
	public CauseOfDeathCondition() {
		super();
		CommonUtil.initResource(this);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
	}
	
	public CauseOfDeathCondition(Decedent decedent) {
		super();
		CommonUtil.initResource(this);
		this.addCategory(CauseOfDeathConditionUtil.causeOfDeathConditionCategory);
		setDecedent(decedent);
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
	
	public Condition setClinicalStatus(String clinicalStatus) {
		CodeableConcept clinicalStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(clinicalStatus, CauseOfDeathConditionUtil.conditionClinicalStatusSet);
		this.setClinicalStatus(clinicalStatusCC);
		return this;
	}
	
	public Condition setVerificationStatus(String verificationStatus) {
		CodeableConcept verificationStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(verificationStatus, CauseOfDeathConditionUtil.verificationStatusSet);
		this.setVerificationStatus(verificationStatusCC);
		return this;
	}
	
	/*public Condition setCategory(String category) {
		CodeableConcept categoryCC = CommonUtil.findConceptFromCollectionUsingSimpleString(category, CauseOfDeathConditionUtil.categorySet);
		this.setVerificationStatus(categoryCC);
		return this;
	}*/
	
}