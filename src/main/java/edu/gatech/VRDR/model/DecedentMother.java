package edu.gatech.VRDR.model;

import org.hl7.fhir.r4.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentMotherUtil;

@ResourceDef(name = "RelatedPerson", profile = "http://hl7.org/fhir/us/vrdr/VRDR-Decedent-Mother")
public class DecedentMother extends RelatedPerson {
	public DecedentMother() {
		super();
		CommonUtil.initResource(this);
		addRelationship(DecedentMotherUtil.code);
	}
}