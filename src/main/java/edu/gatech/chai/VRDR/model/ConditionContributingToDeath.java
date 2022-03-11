package edu.gatech.chai.VRDR.model;

import java.util.List;

import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CauseOfDeathConditionUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.ConditionContributingToDeathUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Condition-Contributing-To-Death")
public class ConditionContributingToDeath extends Observation {
	public ConditionContributingToDeath() {
		super();
		CommonUtil.initResource(this);
		this.setCode(ConditionContributingToDeathUtil.code);
	}
	
	public ConditionContributingToDeath(Decedent decedent, Certifier certifier, String value) {
		super();
		CommonUtil.initResource(this);
		this.setCode(ConditionContributingToDeathUtil.code);
		setDecedent(decedent);
		setPerformer(certifier);
		setValue(value);
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
		this.performer.add(reference);
	}
	public void setAsserter(Certifier certifier) {
		setCertifier(certifier);
	}
	public void setPerformer(Certifier certifier) {
		setCertifier(certifier);
	}
	
	public List<Reference> getCertifiers(int index) {
		return performer;
	}
	
	public List<Reference> getAsserters(int index) {
		return performer;
	}
	
	public List<Reference> getPerformers(int index) {
		return performer;
	}
	
	public Reference getCertifier(int index) {
		return performer.get(index);
	}
	
	public void setValue(StringType value) {
		if((value.getValue().length() > 240)) {
			throw new IllegalArgumentException("CauseOfDeathCondition value "+value.getValue()+" is too long, must be 240 characters or less.");
		}
		this.setValue(value);
	}
	
	public void setValue(String value) {
		setValue(new StringType(value));
	}
}