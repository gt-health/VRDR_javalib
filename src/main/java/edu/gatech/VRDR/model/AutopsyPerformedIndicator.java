package edu.gatech.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.AutopsyPerformedIdentifierUtil;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Autopsy-Performed-Indicator")
public class AutopsyPerformedIndicator extends Observation {

	public AutopsyPerformedIndicator() {
		super();
		CommonUtil.initResource(this);
		setStatus(AutopsyPerformedIdentifierUtil.status);
		setCode(AutopsyPerformedIdentifierUtil.code);
	}
	
	public AutopsyPerformedIndicator(boolean autopsyPerformed) {
		this();
		CodeableConcept autopsyPerformedConcept = autopsyPerformed ? CommonUtil.yesCode : CommonUtil.noCode;
		setValue(autopsyPerformedConcept);
	}

	public AutopsyPerformedIndicator(boolean autopsyPerformed,boolean resultsAvailable) {
		this(autopsyPerformed);
		CodeableConcept autopsyResultsAvailableConcept = resultsAvailable ? CommonUtil.yesCode : CommonUtil.noCode;
		addAutopsyResultsAvailableComponent(autopsyResultsAvailableConcept);
	}
	
	public AutopsyPerformedIndicator(CodeableConcept autopsyPerformed) {
		this();
		setValue(autopsyPerformed);
	}
	
	public AutopsyPerformedIndicator(CodeableConcept autopsyPerformed,CodeableConcept resultsAvailable) {
		this(autopsyPerformed);
		addAutopsyResultsAvailableComponent(resultsAvailable);
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