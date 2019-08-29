package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.TobaccoUseContributedToDeathUtil;

@ResourceDef(name = "Observation", profile = "http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Tobacco-Use-Contributed-To-Death")
public class TobaccoUseContributedToDeath extends Observation {
	public TobaccoUseContributedToDeath() {
		super();
		CommonUtil.initResource(this);
	}
	
	public TobaccoUseContributedToDeath(boolean value) {
		this();
		setStatus(TobaccoUseContributedToDeathUtil.status);
		setCode(TobaccoUseContributedToDeathUtil.code);
		setValue(new BooleanType(value));
	}
}