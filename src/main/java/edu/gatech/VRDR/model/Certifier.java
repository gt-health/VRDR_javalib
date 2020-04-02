package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Practitioner;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Practitioner", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Certifier")
public class Certifier extends Practitioner {

	public Certifier() {
		super();
		CommonUtil.initResource(this);
	}

	public PractitionerQualificationComponent addQualification(String identifier, String type,String title) {
		CodeableConcept identifierTypeCodeableConcept = CommonUtil.findConceptFromCollectionUsingSimpleString(type, CommonUtil.deathReportingIdentifierTypeCodes);
		PractitionerQualificationComponent component = new PractitionerQualificationComponent(identifierTypeCodeableConcept);
		component.setCode(new CodeableConcept().addCoding(new Coding("http://www.hl7.org/fhir/v2/0360/2.7",title,"")));
		component.addIdentifier(new Identifier().setValue(identifier));
		addQualification(component);
		return component;
	}
}