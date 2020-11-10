package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentPregnancyUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Pregnancy")
public class DecedentPregnancy extends Observation {
	public DecedentPregnancy() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentPregnancyUtil.status);
		setCode(DecedentPregnancyUtil.code);
	}
	public DecedentPregnancy(CodeableConcept value) {
		this();
		setValue(value);
	}
	
	public DecedentPregnancy(String code) {
		this();
		setValue(code);
	}
	
	public DecedentPregnancy(String code, String display) {
		this();
		setValue(code,display);
	}
	

	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, DecedentPregnancyUtil.valueSet);
		setValue(concept);
	}
	
	public void setValue(String code, String display) {
		CodeableConcept concept = new CodeableConcept().addCoding(new Coding().setCode(code).setSystem(DecedentPregnancyUtil.codeValueSystem).setDisplay(display));
		setValue(concept);
	}
}