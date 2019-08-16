package edu.gatech.VRDR.model;

import java.util.ArrayList;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.MannerOfDeathUtil;

@ResourceDef(name="Location", profile="http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Manner-of-Death")
public class MannerOfDeath extends Observation{

	public MannerOfDeath() {
		super();
		CommonUtil.initResource(this);
	}
	
	public MannerOfDeath(CodeableConcept manner,Decedent decedent, Certifier certifier) {
		this();
		setStatus(MannerOfDeathUtil.status);
		setCode(MannerOfDeathUtil.code);
		setValue(manner);
		setSubject(new Reference(decedent));
		this.addPerformer(new Reference(certifier));
	}
}
