package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Organization;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Organization", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Interested-Party")
public class InterestedParty extends Organization {
	public InterestedParty() {
		super();
		CommonUtil.initResource(this);
	}
	public InterestedParty(String identifier, boolean active, CodeableConcept type, String name, Address address) {
		this();
		addIdentifier(new Identifier().setValue(identifier));
		setActive(active);
		addType(type);
		setName(name);
		addAddress(address);
	}
}