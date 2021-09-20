package edu.gatech.chai.VRDR.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import ca.uhn.fhir.model.primitive.CodeDt;

public class DecedentUtil {
	public static final String raceExtensionURL = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-race";
	public static final String raceSystem = "urn:oid:2.16.840.1.113883.6.238";
	public static final String ethnicityExtensionURL = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity";
	public static final String ethnicitySystem = "urn:oid:2.16.840.1.113883.6.238";
	public static final String birthSexExtensionURL = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-birthsex";
	public static final String birthSexValueSetURL = "http://hl7.org/fhir/us/core/ValueSet/us-core-birthsex";
	public static final String birthPlaceExtensionURL = "http://hl7.org/fhir/StructureDefinition/patient-birthPlace";
	public static final String maritalStatusURL = "urn:oid:2.16.840.1.113883.12.2";
	public static final String addressWithinCityLimitsIndicatorExtensionURL = "http://hl7.org/fhir/us/vrdr/StructureDefinition/Within-City-Limits-Indicator";
	public static final CodeableConcept identifierTypeFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("SB").setDisplay("Social Beneficiary Identifier"));
	public static final String identifierSystem = "http://hl7.org/fhir/sid/us-ssn";
	
	public static final CodeDt genderValueMale = new CodeDt("male");
	public static final CodeDt genderValueFemale = new CodeDt("female");
	public static final CodeDt genderValueUnknown = new CodeDt("female");
	public static final HashSet<CodeableConcept> maritalStatusSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(maritalStatusURL,"M","Married")),
			new CodeableConcept().addCoding(new Coding(maritalStatusURL,"A","Seperated")),
			new CodeableConcept().addCoding(new Coding(maritalStatusURL,"W","Widowed")),
			new CodeableConcept().addCoding(new Coding(maritalStatusURL,"D","Divorced")),
			new CodeableConcept().addCoding(new Coding(maritalStatusURL,"S","Single")),
			new CodeableConcept().addCoding(new Coding(maritalStatusURL,"U","Unknown"))));
	
	public static Set<CodeDt> genderCodesetList = new HashSet<CodeDt>(Arrays.asList(
			genderValueMale,genderValueFemale,genderValueUnknown));
	
	
}