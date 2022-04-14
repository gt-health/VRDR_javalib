package edu.gatech.chai.VRDR.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class InputRaceAndEthnicityUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(new Coding("", "inputraceandethnicity", "Input Race and Ethnicity"));
	public static Set<String> raceSystemStrings = new HashSet<String>(Arrays.asList(
			"White", "BlackOrAfricanAmerican","AmericanIndianOrAlsakNative","AsianIndian","Chinese","Filipino","Japanese","Korean","Vietnamese","OtherAsian","NativeHawaiian","GuamanianOrChamorro","Samoan","OtherPacificIslander","OtherRace"));
	public static Set<String> ethnicitySystemStrings = new HashSet<String>(Arrays.asList(
			"HispanicPuertoRican", "HispanicCuban","HispanicOther","SecondOtherAsianLiteral","FirstOtherPacificIslanderLiteral","SecondOtherPacificIslanderLiteral","FirstOtherRaceLiteral","SecondOtherRaceLiteral"));
	public static Set<String> raceEthnicityLiteralSystemStrings = new HashSet<String>(Arrays.asList(
			"FirstAmericanIndianOrAlaskaNativeLiteral", "SecondAmericanIndianOrAlaskaNativeLiteral","FirstOtherAsianLiteral","SecondOtherAsianLiteral","FirstOtherPacificIslanderLiteral","SecondOtherPacificIslanderLiteral","FirstOtherRaceLiteral","SecondOtherRaceLiteral","HispanicLiteral"));
	public static Set<CodeableConcept> raceMissingValueReasonList = new HashSet<CodeableConcept>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(CommonUtil.missingValueReasonUrl,"R","Refused")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.missingValueReasonUrl,"S","Sought, but unknown")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.missingValueReasonUrl,"C","Not obtainable"))
			));
}