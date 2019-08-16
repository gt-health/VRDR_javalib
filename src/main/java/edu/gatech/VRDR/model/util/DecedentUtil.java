package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;

public class DecedentUtil {
	public static final String raceExtensionURL = "http://www.hl7.org/fhir/us/core/StructureDefinition/us-core-race";
	public static final String raceSystem = "urn:oid:2.16.840.1.113883.6.238";
	public static final String ethnicityExtensionURL = "http://www.hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity";
	public static final String ethnicitySystem = "urn:oid:2.16.840.1.113883.6.238";
	public static final String birthSexExtensionURL = "http://www.hl7.org/fhir/us/core/StructureDefinition/us-core-birthsex";
	public static final String birthSexValueSetURL = "http://www.hl7.org/fhir/us/core/ValueSet/us-core-birthsex";
	public static final String birthPlaceExtensionURL = "http://www.hl7.org/fhir/StructureDefinition/birthPlace";
	public static final String addressWithCityLimitsIndicatorExtensionURL = "http://www.hl7.org/fhir/us/vrdr/StructureDefinition/Within-City-Limits-Indicator";
	public static final CodeableConcept identifierTypeFixedValue = new CodeableConcept().addCoding(new Coding().setCode("BR").setDisplay("Social Beneficiary Identifier"));
	public static final String identifierSystem = "urn:oid:2.16.840.1.113883.4.1";
}