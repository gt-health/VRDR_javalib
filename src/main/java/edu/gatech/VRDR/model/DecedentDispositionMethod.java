package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentDispositionMethodUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/VRDR-Decedent-Disposition-Method")
public class DecedentDispositionMethod extends Observation {
	public DecedentDispositionMethod() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentDispositionMethodUtil.status);
		setCode(DecedentDispositionMethodUtil.code);
	}
	public DecedentDispositionMethod(CodeableConcept value) {
		this();
		setValue(value);
	}
}
