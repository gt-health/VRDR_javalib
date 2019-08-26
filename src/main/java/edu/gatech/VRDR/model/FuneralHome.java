package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.Organization;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.FuneralHomeUtil;

@ResourceDef(name = "Funeral Home", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Funeral-Home")
public class FuneralHome extends Organization {
	public FuneralHome(String name, Address address) {
		super();
		addType(FuneralHomeUtil.type);
		setName(name);
		addAddress(address);
	}
}
