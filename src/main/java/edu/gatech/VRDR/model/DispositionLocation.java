package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.Location;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Disposition Location", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Disposition-Location")
public class DispositionLocation extends Location {
	public DispositionLocation(Address address) {
		super();
		setAddress(address);
	}
}
