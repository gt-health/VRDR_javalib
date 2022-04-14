package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentEducationLevelUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-decedent-education-level")
public class DecedentEducationLevel extends Observation {
	public DecedentEducationLevel() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentEducationLevelUtil.status);
		setCode(DecedentEducationLevelUtil.code);
	}
	
	public DecedentEducationLevel(String code) {
		this();
		setValue(code);
	}
	
	public DecedentEducationLevel(String code, String display) {
		this();
		setValue(code,display);
	}
	
	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, DecedentEducationLevelUtil.valueSet);
		if(concept != null) {
			setValue(concept);
		}
	}
	
	public void setValue(String code, String display) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, DecedentEducationLevelUtil.valueSet);
		if(concept == null) {
			concept = CommonUtil.findConceptFromCollectionUsingSimpleString(display, DecedentEducationLevelUtil.valueSet);
		}
		if(concept != null) {
			setValue(concept);
		}
	}
}
