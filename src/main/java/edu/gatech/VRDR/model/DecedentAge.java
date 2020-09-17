package edu.gatech.VRDR.model;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentAgeUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Age")
public class DecedentAge extends Observation {
	public DecedentAge() {
		CommonUtil.initResource(this);
		setStatus(DecedentAgeUtil.status);
		setCode(DecedentAgeUtil.code);
	}
}