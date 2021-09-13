package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Location;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathLocationUtil;

@ResourceDef(name = "Location", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Location")
public class DeathLocation extends Location {
	public DeathLocation() {
		super();
		CommonUtil.initResource(this);
	}
	public DeathLocation(String name, String jurisdicitionId, String description, CodeableConcept type, Address address,
			CodeableConcept physicalType) {
		this();
		setName(name);
		addJurisdictionIdExtension(jurisdicitionId);
		setDescription(description);
		addType(type);
		setAddress(address);
		setPhysicalType(physicalType);
	}
	
	public DeathLocation addJurisdictionIdExtension(String jurisdicitionId) {
		Extension extension = new Extension(DeathLocationUtil.locationJurisdictionIdExtension);
		extension.setValue(CommonUtil.findConceptFromCollectionUsingSimpleString(jurisdicitionId, CommonUtil.locationJurisdictionalConceptSet));
		this.addExtension(extension);
		return this;
	}
}