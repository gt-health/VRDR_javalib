package edu.gatech.VRDR.model;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DecedentEducationLevelUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Education-Level")
public class DecedentEducationLevel extends Observation {
	public DecedentEducationLevel() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentEducationLevelUtil.status);
		setCode(DecedentEducationLevelUtil.code);
	}
}
