package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentUtil;

@ResourceDef(name = "Patient", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-decedent")
public class Decedent extends Patient {

	public Decedent() {
		super();
		CommonUtil.initResource(this);
	}

	public Extension getRace() {
		return CommonUtil.getExtension(this, DecedentUtil.raceExtensionURL);
	}

	public Extension addRace(String raceString) {
		Extension baseRaceExtension = getRace();
		if(baseRaceExtension == null) {
			baseRaceExtension = new Extension();
			baseRaceExtension.setUrl(DecedentUtil.raceExtensionURL);
			this.addExtension(baseRaceExtension);
		}
		for(String raceUrl: DecedentUtil.raceNVSSSet) {
			if(raceUrl.contains(raceString)) {
				Extension specificRaceExtension = new Extension();
				specificRaceExtension.setUrl(raceUrl);
				if(raceUrl.contains("Literal")) { //Literal subtype urls use strings, not booleans
					specificRaceExtension.setValue(new StringType(raceString));
				}
				else {
					specificRaceExtension.setValue(new BooleanType(true));
				}
				baseRaceExtension.addExtension(specificRaceExtension);
				return baseRaceExtension;
			}
		}
		return baseRaceExtension;
	}
	
	public Extension getEthnicity() {
		return CommonUtil.getExtension(this, DecedentUtil.ethnicityExtensionURL);
	}
	
	public Extension addEthnicity(String ethnicityString) {
		return addEthnicity (ethnicityString, "yes");
	}
	
	public Extension addEthnicity(String ethnicityString, String yesNoUnknown) {
		Extension baseEthnicityExtension = getEthnicity();
		if(baseEthnicityExtension == null) {
			baseEthnicityExtension = new Extension();
			baseEthnicityExtension.setUrl(DecedentUtil.ethnicityExtensionURL);
			this.addExtension(baseEthnicityExtension);
		}
		for(String ethnicityUrl: DecedentUtil.ethnicityNVSSSet) {
			if(ethnicityUrl.contains(ethnicityString)) {
				Extension specificRaceExtension = new Extension();
				specificRaceExtension.setUrl(ethnicityUrl);
				if(ethnicityUrl.contains("Literal")) { //Literal subtype urls use strings, not booleans
					specificRaceExtension.setValue(new StringType(ethnicityString));
				}
				else {
					CodeableConcept yesNoUnknownCodeableConcept = CommonUtil.findConceptFromCollectionUsingSimpleString(yesNoUnknown, CommonUtil.yesNoUnknownSet);
					specificRaceExtension.setValue(yesNoUnknownCodeableConcept);
				}
				baseEthnicityExtension.addExtension(specificRaceExtension);
				return baseEthnicityExtension;
			}
		}
		return baseEthnicityExtension;
	}

	public Extension getSexAtDeath() {
		return CommonUtil.getExtension(this, DecedentUtil.sexAtDeathExtensionURL);
	}

	public Extension setSexAtDeath(String value) {
		CodeableConcept ccSAD = CommonUtil.findConceptFromCollectionUsingSimpleString(value, DecedentUtil.sexAtDeathSet);
		return setSexAtDeath(ccSAD);
	}
	
	public Extension setSexAtDeath(CodeableConcept value) {
		Extension extension = getSexAtDeath();
		if (extension == null) {
			extension = new Extension(DecedentUtil.sexAtDeathExtensionURL);
		}
		extension.setValue(value);
		this.addExtension(extension);
		return extension;
	}
	
	public Extension getSpouseAlive() {
		return CommonUtil.getExtension(this, DecedentUtil.spouseAliveExtensionURL);
	}

	public Extension setSpouseAlive(String value) {
		CodeableConcept ccSAD = CommonUtil.findConceptFromCollectionUsingSimpleString(value, DecedentUtil.spouseAliveSet);
		return setSpouseAlive(ccSAD);
	}
	
	public Extension setSpouseAlive(CodeableConcept value) {
		Extension extension = getSpouseAlive();
		if (extension == null) {
			extension = new Extension(DecedentUtil.spouseAliveExtensionURL);
		}
		extension.setValue(value);
		this.addExtension(extension);
		return extension;
	}

	public Extension getBirthPlace() {
		return CommonUtil.getExtension(this, DecedentUtil.birthPlaceExtensionURL);
	}

	public Extension setBirthPlace(Address address) {
		Extension extension = getBirthPlace();
		if (extension != null) {
			extension.setValue(address);
			return extension;
		}
		return addBirthPlace(address);
	}

	public Extension addBirthPlace(Address address) {
		Extension extension = new Extension(DecedentUtil.birthPlaceExtensionURL);
		extension.setValue(address);
		this.addExtension(extension);
		return extension;
	}

	public Identifier addSSNIdentifier(String value) {
		Identifier identifier = new Identifier();
		identifier.setType(DecedentUtil.identifierTypeFixedValue);
		identifier.setValue(value);
		identifier.setSystem(DecedentUtil.identifierSystem);
		addIdentifier(identifier);
		return identifier;
	}
	
	public Decedent setMaritalStatus(String maritalStatus) {
		CodeableConcept maritalStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(maritalStatus, DecedentUtil.maritalStatusSet);
		this.setMaritalStatus(maritalStatusCC);
		return this;
	}
	
	public Decedent setMaritalStatus(String maritalStatus, CodeableConcept bypassEditFlag) {
		CodeableConcept maritalStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(maritalStatus, DecedentUtil.maritalStatusSet);
		maritalStatusCC = maritalStatusCC.copy();
		if(bypassEditFlag != null) {
			Extension extension = new Extension();
			extension.setUrl(maritalStatus);
		}
		this.setMaritalStatus(maritalStatusCC);
		return this;
	}
	
	public Decedent addPartialBirthDateExtension(IntegerType year,String yearDataAbsentReason, IntegerType month,String monthDataAbsentReason,
			IntegerType day,String dayDataAbsentReason) {
		if(this.birthDate == null) {
			this.birthDate = new DateType();
		}
		Extension baseExtension = addPartialBirthDateBaseExtension();
		addPartialDateYear(baseExtension,year,yearDataAbsentReason);
		addPartialDateMonth(baseExtension,month,monthDataAbsentReason);
		addPartialDateDay(baseExtension,day,dayDataAbsentReason);
		this.birthDate.addExtension(baseExtension);
		return this;
	}
	
	private Extension addPartialBirthDateBaseExtension() {
		Extension baseExtension = new Extension(CommonUtil.partialDatePartAbsentReasonURL);
		return baseExtension;
	}
	
	private Decedent addPartialDateYear(Extension baseExtension, IntegerType year,String dataAbsentReason) {
		if(dataAbsentReason != null && !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateYearAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(year != null && !year.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateYearURL,year));
		}
		return this;
	}
	
	private Decedent addPartialDateMonth(Extension baseExtension, IntegerType month,String dataAbsentReason) {
		if(dataAbsentReason != null && !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateMonthAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(month != null && !month.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateMonthURL,month));
		}
		return this;
	}
	
	private Decedent addPartialDateDay(Extension baseExtension, IntegerType day,String dataAbsentReason) {
		if(dataAbsentReason != null || !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateDayAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(day != null && !day.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateDayURL,day));
		}
		return this;
	}
	//TODO: Add handler for informant mapping
}
