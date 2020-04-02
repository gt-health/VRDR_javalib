package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentEmploymentHistoryUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Employment-History")
public class DecedentEmploymentHistory extends Observation {
	public DecedentEmploymentHistory() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentEmploymentHistoryUtil.status);
		setCode(DecedentEmploymentHistoryUtil.code);
	}
	public DecedentEmploymentHistory(CodeableConcept militaryServiceValue, CodeableConcept usualIndustryValue,
			CodeableConcept usualOccupationValue) {
		this();
		addMilitaryService(militaryServiceValue);
		addUsualIndustry(usualIndustryValue);
		addUsualOccupation(usualOccupationValue);
	}
	
	public void addMilitaryService(CodeableConcept militaryServiceValue) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DecedentEmploymentHistoryUtil.componentMilitaryServiceCode);
		component.setValue(militaryServiceValue);
		addComponent(component);
	}
	
	public void addUsualIndustry(CodeableConcept usualIndustryValue) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DecedentEmploymentHistoryUtil.componentUsualIndustryCode);
		component.setValue(usualIndustryValue);
		addComponent(component);
	}
	
	public void addUsualOccupation(CodeableConcept usualOccupationValue) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DecedentEmploymentHistoryUtil.componentUsualOccupationCode);
		component.setValue(usualOccupationValue);
		addComponent(component);
	}
}