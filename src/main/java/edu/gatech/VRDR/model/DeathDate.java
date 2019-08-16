package edu.gatech.VRDR.model;

import java.util.Date;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.Location;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DeathDateUtil;

@ResourceDef(name="DeathDate", profile="http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Date")
public class DeathDate extends Observation{
	
	public DeathDate() {
		super();
		CommonUtil.initResource(this);
	}
	public DeathDate(Date dateTime) {
		this();
		setValue(new DateTimeType(dateTime));
	}
	
	public void addPatientLocationExtension(Location location) {
		Extension extension = new Extension(DeathDateUtil.patientLocationExtensionURL);
		Reference reference = new Reference(location);
		extension.setValue(reference);
		this.addExtension(extension);
	}
	
	public Extension getPatientLocationExtension() {
		return CommonUtil.getExtension(this, DeathDateUtil.patientLocationExtensionURL);
	}
	
	public void addEstimatedMethod() {
		setMethod(DeathDateUtil.method);
	}
}
