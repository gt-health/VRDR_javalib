package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.DecedentDispositionMethodUtil;

@ResourceDef(name = "Decedent Disposition Method", profile = "http://www.hl7.org/fhir/us/vrdr/VRDR-Decedent-Disposition-Method")
public class DecedentDispositionMethod extends Observation {
	public DecedentDispositionMethod(CodeableConcept value) {
		setStatus(DecedentDispositionMethodUtil.status);
		setCode(DecedentDispositionMethodUtil.code);
		setValue(value);
	}
}
