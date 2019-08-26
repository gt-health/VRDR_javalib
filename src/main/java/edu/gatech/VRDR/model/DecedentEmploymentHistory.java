package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.DecedentEmploymentHistoryUtil;

@ResourceDef(name = "Decedent Employment History", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Employment-History")
public class DecedentEmploymentHistory extends Observation {
	public DecedentEmploymentHistory(CodeableConcept militaryServiceValue, CodeableConcept usualIndustryValue,
			CodeableConcept usualOccupationValue) {
		super();
		setStatus(DecedentEmploymentHistoryUtil.status);
		setCode(DecedentEmploymentHistoryUtil.code);
		addComponent().setCode(militaryServiceValue);
		addComponent().setCode(usualIndustryValue);
		addComponent().setCode(usualOccupationValue);
	}
}
