package edu.gatech.chai.VRDR.model;

import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CauseOfDeathConditionUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

//NOTE: While the resource name is "CauseOfDeathCondition", it actually derived from Observation
@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Cause-Of-Death-Condition")
public class CauseOfDeathCondition extends Observation {
	public CauseOfDeathCondition() {
		super();
		CommonUtil.initResource(this);
		this.setCode(CauseOfDeathConditionUtil.code);
	}
	
	public CauseOfDeathCondition(Decedent decedent, Certifier certifier, String value, Quantity interval) {
		super();
		CommonUtil.initResource(this);
		this.setCode(CauseOfDeathConditionUtil.code);
		setDecedent(decedent);
		setPerformer(certifier);
		setValue(value);
		createInterval(interval);
	}
	
	public CauseOfDeathCondition(Decedent decedent, Certifier certifier, String value, String interval) {
		super();
		CommonUtil.initResource(this);
		this.setCode(CauseOfDeathConditionUtil.code);
		setDecedent(decedent);
		setPerformer(certifier);
		setValue(value);
		createInterval(interval);
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
		if((value.getValue().length() > 120)) {
			throw new IllegalArgumentException("CauseOfDeathCondition value "+value.getValue()+" is too long, must be 120 characters or less.");
		}
		this.setValue(value);
	}
	
	public void setValue(String value) {
		setValue(new StringType(value));
	}
	
	public void createInterval(Quantity quantity) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(CauseOfDeathConditionUtil.intervalComponentCode);
		component.setValue(quantity);
		
	}
	
	public void createInterval(String string) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(CauseOfDeathConditionUtil.intervalComponentCode);
		component.setValue(new StringType(string));
		
	}
	
}