package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentMotherUtil;

@ResourceDef(name = "RelatedPerson", profile = "http://hl7.org/fhir/us/vrdr/vrdr-decedent-mother")
public class DecedentMother extends RelatedPerson {
	public DecedentMother() {
		super();
		CommonUtil.initResource(this);
		addRelationship(DecedentMotherUtil.code);
	}
}