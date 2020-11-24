package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentDispositionMethodUtil;
import edu.gatech.chai.VRDR.model.util.MannerOfDeathUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Manner-of-Death")
public class MannerOfDeath extends Observation {

	public MannerOfDeath() {
		super();
		CommonUtil.initResource(this);
		setStatus(MannerOfDeathUtil.status);
		setCode(MannerOfDeathUtil.code);
	}

	public MannerOfDeath(CodeableConcept manner, Decedent decedent, Certifier certifier) {
		this();
		setValue(manner);
		setSubject(new Reference(decedent.getId()));
		this.addPerformer(new Reference(certifier.getId()));
	}
	
	public MannerOfDeath(String manner, Decedent decedent, Certifier certifier) {
		this();
		setValue(manner);
		setSubject(new Reference(decedent.getId()));
		this.addPerformer(new Reference(certifier.getId()));
	}
	
	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, MannerOfDeathUtil.valueCodesetList);
		if(concept != null) {
			setValue(concept);
		}
	}
	
	public void setValue(String code, String display) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, DecedentDispositionMethodUtil.valueCodesetList);
		if(concept == null) {
			concept = CommonUtil.findConceptFromCollectionUsingSimpleString(display, DecedentDispositionMethodUtil.valueCodesetList);
		}
		if(concept != null) {
			setValue(concept);
		}
	}
}