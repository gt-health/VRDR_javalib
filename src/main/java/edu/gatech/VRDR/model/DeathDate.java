package edu.gatech.VRDR.model;

import java.util.Date;

import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DeathDateUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Date")
public class DeathDate extends Observation {

	public DeathDate() {
		super();
		CommonUtil.initResource(this);
		setCode(DeathDateUtil.code);
		setStatus(DeathDateUtil.status);
	}

	public DeathDate(Date effectiveDateTime,Date datePronouncedDead) {
		this();
		setEffective(new DateTimeType(effectiveDateTime));
		addDatePronouncedDead(new DateTimeType(datePronouncedDead));
	}

	public void addPatientLocationExtension(Location location) {
		Extension extension = new Extension(DeathDateUtil.patientLocationExtensionURL);
		Reference reference = new Reference(location.getId());
		extension.setValue(reference);
		this.addExtension(extension);
	}

	public Extension getPatientLocationExtension() {
		return CommonUtil.getExtension(this, DeathDateUtil.patientLocationExtensionURL);
	}

	public void addEstimatedMethod() {
		setMethod(DeathDateUtil.method);
	}
	
	public void addDatePronouncedDead(DateTimeType dtType) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DeathDateUtil.componentDatePronouncedDeadCode);
		component.setValue(dtType);
		addComponent(component);
	}
}
