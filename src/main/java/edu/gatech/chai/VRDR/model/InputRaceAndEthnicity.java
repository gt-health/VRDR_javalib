package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.InputRaceAndEthnicityUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-input-race-and-ethnicity")
public class InputRaceAndEthnicity extends Observation {
	public InputRaceAndEthnicity() {
		this.setCode(InputRaceAndEthnicityUtil.code);
	}
	
	public InputRaceAndEthnicity(String... racesAndEthnicities) {
		for(String raceOrEth:racesAndEthnicities) {
			if(InputRaceAndEthnicityUtil.raceSystemStrings.contains(raceOrEth)) {
				addRaceComponent(raceOrEth);
			}
			else if(InputRaceAndEthnicityUtil.ethnicitySystemStrings.contains(raceOrEth)) {
				addEthnicityComponent(raceOrEth);
			}
		}
	}
	
	public void addRaceComponent(String codeName) {
		addComponent(codeName, new BooleanType(true));
	}
	
	public void addRaceComponent(String codeName, boolean value) {
		addComponent(codeName, new BooleanType(value));
	}
	
	public void addRaceComponent(String codeName, BooleanType value) {
		addComponent(codeName, value);
	}
	
	public void addEthnicityComponent(String codeName) {
		addComponent(codeName, CommonUtil.findConceptFromCollectionUsingSimpleString("Yes", CommonUtil.yesNoUnknownSet));
	}
	
	public void addEthnicityComponent(String codeName, CodeableConcept value) {
		addComponent(codeName, value);
	}
	
	public void addEthnicityLiteralComponent(String codeName, String value) {
		addComponent(codeName, new StringType(value));
	}
	
	public void addEthnicityLiteralComponent(String codeName, StringType value) {
		addComponent(codeName, value);
	}
	
	public void addMissingRaceValueReason(String value) {
		CodeableConcept mrvrCodeableConcept = CommonUtil.findConceptFromCollectionUsingSimpleString(value, InputRaceAndEthnicityUtil.raceMissingValueReasonList);
		addComponent("RACEMVR",mrvrCodeableConcept);
	}
	
	public void addComponent(String codeName, BooleanType value) {
		ObservationComponentComponent occ = addComponentCommon(codeName);
		occ.setValue(value);
	}
	
	public void addComponent(String codeName, CodeableConcept value) {
		ObservationComponentComponent occ = addComponentCommon(codeName);
		occ.setValue(value);
	}
	
	public void addComponent(String codeName, StringType value) {
		ObservationComponentComponent occ = addComponentCommon(codeName);
		occ.setValue(value);
	}
	
	private ObservationComponentComponent addComponentCommon(String codeName) {
		ObservationComponentComponent occ = new ObservationComponentComponent();
		occ.setCode(new CodeableConcept().addCoding(new Coding("",codeName,codeName)));
		return occ;
	}
	
}
