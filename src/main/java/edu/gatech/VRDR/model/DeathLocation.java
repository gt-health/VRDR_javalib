package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Location;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Death Location", profile = "http://www.hl7.org/fhir/us/vrdr/StructureDefinition/@ResourceDef(name=\"Death Certificate Reference\", profile=\"http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Location")
public class DeathLocation extends Location {
	public DeathLocation(String name, String description, CodeableConcept type, Address address,
			CodeableConcept physicalType) {
		setName(name);
		setDescription(description);
		setType(type);
		setAddress(address);
		setPhysicalType(physicalType);
	}
}
