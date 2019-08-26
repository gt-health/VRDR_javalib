package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.DecedentAgeUtil;

@ResourceDef(name = "Decedent Age", profile = "http://www.hl7.org/fhir/us/vrdr/decedentAge")
public class DecedentAge extends Observation {
	public DecedentAge() {
		setStatus(DecedentAgeUtil.status);
		setCode(DecedentAgeUtil.code);
	}
}
