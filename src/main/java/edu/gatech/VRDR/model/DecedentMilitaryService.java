package edu.gatech.VRDR.model;

import java.math.BigDecimal;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentMilitaryServiceUtil;
import edu.gatech.VRDR.model.util.DecedentUsualWorkUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Military-Service")
public class DecedentMilitaryService extends Observation {
	public DecedentMilitaryService() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentMilitaryServiceUtil.status);
		setCode(DecedentMilitaryServiceUtil.code);
	}
	public DecedentMilitaryService(CodeableConcept yesNoCode) {
		this();
		this.setValue(yesNoCode);
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