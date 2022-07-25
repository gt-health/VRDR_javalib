package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Identifier;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-cause-of-death-coded-content-bundle")
public class CauseOfDeathCodedContentBundle extends Bundle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1775205638319513588L;

	public CauseOfDeathCodedContentBundle() {
		super();
		CommonUtil.initResource(this);
		this.setType(BundleType.COLLECTION);
	}
	
	public CauseOfDeathCodedContentBundle addAuxilaryStateIdentifier1 (String value) {
		return addAuxilaryStateIdentifier("http://hl7.org/fhir/us/vrdr/StructureDefinition/AuxiliaryStateIdentifier1", value);
	}
	
	public CauseOfDeathCodedContentBundle addAuxilaryStateIdentifier2 (String value) {
		return addAuxilaryStateIdentifier("http://hl7.org/fhir/us/vrdr/StructureDefinition/AuxiliaryStateIdentifier2", value);
	}
	
	public CauseOfDeathCodedContentBundle addAuxilaryStateIdentifier(String system, String value) {
		if(value.length() > 6) {
			throw new IllegalArgumentException("AuxilaryStateIdentifier"+value+" is too long, must be 6 characters or less.");
		}
		Identifier identifier = new Identifier();
		identifier.setSystem(system);
		identifier.setValue(value);
		setIdentifier(identifier);
		return this;
	}
	
}