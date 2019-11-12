package edu.gatech.VRDR.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;

public class DecedentDispositionMethodUtil {
	public static final Observation.ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept().addCoding(
			new Coding().setSystem("http://loinc.org").setCode("80905-3").setDisplay("Body disposition method"));
	public static final String codeValueSystem = "2.16.840.1.114222.4.11.7379";
	public static final CodeableConcept VALUE_DONATEDCODE = new CodeableConcept().addCoding(new Coding().setCode("449951000124101").setSystem(codeValueSystem).setDisplay("Donation"));
	public static final CodeableConcept VALUE_BURIALCODE = new CodeableConcept().addCoding(new Coding().setCode("449971000124106").setSystem(codeValueSystem).setDisplay("Burial"));
	public static final CodeableConcept VALUE_CREMATIONCODE = new CodeableConcept().addCoding(new Coding().setCode("449961000124104").setSystem(codeValueSystem).setDisplay("Cremation"));
	public static final CodeableConcept VALUE_REMOVALFROMSTATECODE = new CodeableConcept().addCoding(new Coding().setCode("449931000124108").setSystem(codeValueSystem).setDisplay("Removal from state"));
	public static final CodeableConcept VALUE_HOSPITALDISPOSITIONCODE = new CodeableConcept().addCoding(new Coding().setCode("373066001").setSystem(codeValueSystem).setDisplay("Hospital Disposition"));
	public static List<CodeableConcept> valueCodesetList = new ArrayList<CodeableConcept>(Arrays.asList(VALUE_DONATEDCODE,VALUE_BURIALCODE,VALUE_CREMATIONCODE,VALUE_REMOVALFROMSTATECODE,VALUE_HOSPITALDISPOSITIONCODE));
}