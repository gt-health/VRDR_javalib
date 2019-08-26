package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.DecedentFatherUtil;

@ResourceDef(name = "Decedent Father", profile = "http://www.hl7.org/fhir/us/vrdr/VRDR-Decedent-Father")
public class DecedentFather extends RelatedPerson {
	public DecedentFather() {
		setRelationship(DecedentFatherUtil.code);
	}
}
