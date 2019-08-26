package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.DecedentEducationLevelUtil;

@ResourceDef(name = "Decedent Education Level", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Decedent-Education-Level")
public class DecedentEducationLevel extends Observation {
	public DecedentEducationLevel() {
		setStatus(DecedentEducationLevelUtil.status);
		setCode(DecedentEducationLevelUtil.code);
	}
}
