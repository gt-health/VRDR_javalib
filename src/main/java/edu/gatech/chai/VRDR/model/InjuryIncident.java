package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathDateUtil;
import edu.gatech.chai.VRDR.model.util.InjuryIncidentUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-injury-incident")
public class InjuryIncident extends Observation {

	public InjuryIncident() {
		super();
		CommonUtil.initResource(this);
		setStatus(InjuryIncidentUtil.status);
		setCode(InjuryIncidentUtil.code);
	}

	public InjuryIncident(Decedent decendent, String placeOfInjury, String injuredAtWorkBoolean,
			String transportationRelationship) {
		this();
		addPlaceOfInjuryComponent(placeOfInjury);
		addInjuredAtWorkComponent(injuredAtWorkBoolean);
		addTransportationEventIndicatorComponent(transportationRelationship);
	}
	
	public InjuryIncident(Decedent decendent, CodeableConcept placeOfInjury, CodeableConcept injuredAtWorkBoolean,
			CodeableConcept transportationRelationship) {
		this();
		addPlaceOfInjuryComponent(placeOfInjury);
		addInjuredAtWorkComponent(injuredAtWorkBoolean);
		addTransportationEventIndicatorComponent(transportationRelationship);
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
	
	public void addPlaceOfInjuryComponent(String placeOfInjury) {
		CodeableConcept placeOfInjuryCode = CommonUtil.findConceptFromCollectionUsingSimpleString(placeOfInjury, InjuryIncidentUtil.placeOfInjuryValueSet);
		addPlaceOfInjuryComponent(placeOfInjuryCode);
	}

	public void addInjuredAtWorkComponent(String injuredAtWork) {
		CodeableConcept injuredAtWorkCode = CommonUtil.findConceptFromCollectionUsingSimpleString(injuredAtWork, CommonUtil.yesNoNASet);
		addInjuredAtWorkComponent(injuredAtWorkCode);
	}

	public void addTransportationEventIndicatorComponent(String transportationRelationship) {
		CodeableConcept transportationEventIndicatorCode = CommonUtil.findConceptFromCollectionUsingSimpleString(transportationRelationship, CommonUtil.yesNoUnknownSet);
		addTransportationEventIndicatorComponent(transportationEventIndicatorCode);
	}

	public void addPlaceOfInjuryComponent(CodeableConcept placeOfInjury) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(InjuryIncidentUtil.componentPlaceofInjuryCode);
		component.setValue(placeOfInjury);
		addComponent(component);
	}

	public void addInjuredAtWorkComponent(CodeableConcept injuredAtWorkBoolean) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(InjuryIncidentUtil.componentInjuryAtWorkCode);
		component.setValue(injuredAtWorkBoolean);
		addComponent(component);
	}

	public void addTransportationEventIndicatorComponent(CodeableConcept transportationRelationship) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(InjuryIncidentUtil.componentTransportationEventIndicator);
		component.setValue(transportationRelationship);
		addComponent(component);
	}
}