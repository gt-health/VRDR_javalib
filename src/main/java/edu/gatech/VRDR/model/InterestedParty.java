package edu.gatech.VRDR.model;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Organization", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Interested-Party")
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