package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.AutopsyPerformedIdentifierUtil;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Autopsy-Performed-Indicator")
public class AutopsyPerformedIndicator extends Observation {

	public AutopsyPerformedIndicator() {
		super();
		CommonUtil.initResource(this);
		setStatus(AutopsyPerformedIdentifierUtil.status);
		setCode(AutopsyPerformedIdentifierUtil.code);
	}

	public AutopsyPerformedIndicator(CodeableConcept value) {
		this();
		addAutopsyResultsAvailableComponent(value);
	}

	public void setDecedent(Decedent decedent) {
		Reference reference = new Reference(decedent.getId());
		setSubject(reference);
	}

	public Reference getDecedent() {
		return getSubject();
	}

	public void addAutopsyResultsAvailableComponent(CodeableConcept concept) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(AutopsyPerformedIdentifierUtil.componentAutopsyResultsAvailableCode);
		component.setValue(concept);
		addComponent(component);
	}

}