package edu.gatech.chai.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class DecedentUtil {
	public static final String raceExtensionURL = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-race";
	public static final String raceSystem = "urn:oid:2.16.840.1.113883.6.238";
	public static final String ethnicityExtensionURL = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity";
	public static final String ethnicitySystem = "urn:oid:2.16.840.1.113883.6.238";
	public static final String birthSexExtensionURL = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-birthsex";
	public static final String birthSexValueSetURL = "http://hl7.org/fhir/us/core/ValueSet/us-core-birthsex";
	public static final String birthPlaceExtensionURL = "http://hl7.org/fhir/StructureDefinition/birthPlace";
	public static final String addressWithinCityLimitsIndicatorExtensionURL = "http://hl7.org/fhir/us/vrdr/StructureDefinition/Within-City-Limits-Indicator";
	public static final CodeableConcept identifierTypeFixedValue = new CodeableConcept()
			.addCoding(new Coding().setCode("SB").setDisplay("Social Beneficiary Identifier"));
	public static final String identifierSystem = "http://hl7.org/fhir/sid/us-ssn";
}