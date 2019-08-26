package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.DecedentSpouseUtil;

@ResourceDef(name = "Decedent Spouse", profile = "http://www.hl7.org/fhir/us/vrdr/VRDR-Decedent-Spouse")
public class DecedentSpouse extends RelatedPerson {
	public DecedentSpouse() {
		setRelationship(DecedentSpouseUtil.code);
	}
}