package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Practitioner;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Practitioner", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-mortician")
public class Mortician extends Practitioner {
	public Mortician() {
		super();
		CommonUtil.initResource(this);
	}
	public Mortician(HumanName name, String qualificationIdentifier, CodeableConcept qualificationCode) {
		this();
		addName(name);
		PractitionerQualificationComponent component = new PractitionerQualificationComponent();
		component.addIdentifier(new Identifier().setValue(qualificationIdentifier));
		component.setCode(qualificationCode);
		addQualification(component);
	}
}
