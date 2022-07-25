package edu.gatech.chai.VRDR.model.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class CodedRaceAndEthnicityUtil {
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding("", "codedraceandethnicity", "Coded Race and Ethnicity"));
	public static final CodeableConcept firstEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "FirstEditedCode", "FirstEditedCode"));
	public static final CodeableConcept secondEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "SecondEditedCode", "SecondEditedCode"));
	public static final CodeableConcept thirdEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "ThirdEditedCode", "ThirdEditedCode"));
	public static final CodeableConcept fourthEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "FourthEditedCode", "FourthEditedCode"));
	public static final CodeableConcept fifthEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "FifthEditedCode", "FifthEditedCode"));
	public static final CodeableConcept sixthEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "SixthEditedCode", "SixthEditedCode"));
	public static final CodeableConcept seventhEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "SeventhEditedCode", "SeventhEditedCode"));
	public static final CodeableConcept eigthEditedCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "EigthEditedCode", "EigthEditedCode"));
	public static final CodeableConcept firstAmericanIndianCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "FirstAmericanIndianCode", "FirstAmericanIndianCode"));
	public static final CodeableConcept secondAmericanIndianCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "SecondAmericanIndianCode", "SecondAmericanIndianCode"));
	public static final CodeableConcept firstOtherAsianCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "FirstOtherAsianCode", "FirstOtherAsianCode"));
	public static final CodeableConcept secondOtherAsianCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "SecondOtherAsianCode", "SecondOtherAsianCode"));
	public static final CodeableConcept firstOtherPacificIslanderCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "FirstOtherPacificIslanderCode", "FirstOtherPacificIslanderCode"));
	public static final CodeableConcept secondOtherPacificIslanderCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "SecondOtherPacificIslanderCode", "SecondOtherPacificIslanderCode"));
	public static final CodeableConcept firstOtherRaceComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "FirstOtherRaceComponentCode", "FirstOtherRaceComponentCode"));
	public static final CodeableConcept secondOtherRaceComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "SecondOtherRaceComponentCode", "SecondOtherRaceComponentCode"));
	public static final CodeableConcept raceRecode40ComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "RaceRecode40", "RaceRecode40"));
	public static final CodeableConcept hispanicCodeComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "HispanicCode", "HispanicCode"));
	public static final CodeableConcept hispanicCodeForLiteralComponentCode = new CodeableConcept()
			.addCoding(new Coding("", "HispanicCodeForLiteral", "HispanicCodeForLiteral"));
	public static Set<CodeableConcept> valueCodesetList = new HashSet<CodeableConcept>(Arrays.asList(
			firstEditedCodeComponentCode,secondEditedCodeComponentCode,thirdEditedCodeComponentCode,fourthEditedCodeComponentCode,
			fifthEditedCodeComponentCode,sixthEditedCodeComponentCode,seventhEditedCodeComponentCode,eigthEditedCodeComponentCode,
			firstAmericanIndianCodeComponentCode,secondAmericanIndianCodeComponentCode,firstOtherAsianCodeComponentCode,
			secondOtherAsianCodeComponentCode,firstOtherPacificIslanderCodeComponentCode,secondOtherPacificIslanderCodeComponentCode,
			firstOtherRaceComponentCode,secondOtherRaceComponentCode,raceRecode40ComponentCode,hispanicCodeComponentCode,
			hispanicCodeForLiteralComponentCode));
}