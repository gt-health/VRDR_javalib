package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.Location;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Location", profile = "http://www.hl7.org/fhir/us/StructureDefinition/VRDR-Disposition-Location")
public class DispositionLocation extends Location {
	public DispositionLocation() {
		super();
		CommonUtil.initResource(this);
	}
	public DispositionLocation(Address address) {
		this();
		setAddress(address);
	}
}
