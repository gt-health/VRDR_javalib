package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.Location;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DeathDateUtil;
import edu.gatech.VRDR.model.util.InjuryIncidentUtil;

@ResourceDef(name = "InjuryIncident", profile = "http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Injury-Incident")
public class InjuryIncident extends Observation {

	public InjuryIncident() {
		super();
		CommonUtil.initResource(this);
	}

	public InjuryIncident(Decedent decendent, String placeOfInjury, CodeableConcept injuredAtWorkBoolean,
			CodeableConcept transportationRelationship) {
		this();
		setStatus(InjuryIncidentUtil.status);
		setCode(InjuryIncidentUtil.code);
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

	public void addPlaceOfInjuryComponent(String placeOfInjury) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(InjuryIncidentUtil.componentPlaceofInjuryCode);
		component.setValue(new StringType(placeOfInjury));
	}

	public void getPlaceOfInjuryComponent(String placeOfInjury) {

	}

	public void addInjuredAtWorkBooleanComponent(CodeableConcept injuredAtWorkBoolean) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(InjuryIncidentUtil.componentInjuryAtWorkCode);
		component.setValue(injuredAtWorkBoolean);
	}

	public void addtransportationRelationshipComponent(CodeableConcept transportationRelationship) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(InjuryIncidentUtil.componentInjuryLeadingToDeathVechicleCode);
		component.setValue(transportationRelationship);
	}
}