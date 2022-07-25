package edu.gatech.chai.VRDR.model;

import java.math.BigDecimal;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentUsualWorkUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-decedent-usual-work")
public class DecedentUsualWork extends Observation {
	public DecedentUsualWork() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentUsualWorkUtil.status);
		setCode(DecedentUsualWorkUtil.code);
	}
	
	public DecedentUsualWork(CodeableConcept usualWork, CodeableConcept usualIndustryValue, Integer occupationYears) {
		this();
		setValue(usualWork);
		addUsualIndustry(usualIndustryValue);
		addUsualOccupationDuration(occupationYears);
	}
	
	
	public void addUsualIndustry(CodeableConcept usualIndustryValue) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DecedentUsualWorkUtil.componentUsualIndustryCode);
		component.setValue(usualIndustryValue);
		addComponent(component);
	}
	
	public void addUsualOccupationDuration(Integer years) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DecedentUsualWorkUtil.componentUsualOccupationDuraction);
		Quantity yearsQuantity = new Quantity();
		yearsQuantity.setCode("a");
		yearsQuantity.setSystem("http://unitsofmeasure.org");
		yearsQuantity.setValue(new BigDecimal(years));
		component.setValue(yearsQuantity);
		addComponent(component);
	}
}