package edu.gatech.chai.VRDR.model.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class DeathLocationUtil {
	public static String locationJurisdictionIdExtension = "http://hl7.org/fhir/us/vrdr/StructureDefinition/Location-Jurisdiction-Id";
	public static final HashSet<CodeableConcept> placeOfDeathTypeSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"63238001","Dead on arrival at hospital")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"440081000124100","Death in home")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"440071000124103","Death in hospice")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"16983000","Death in hospital")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"450391000124102","Death in hospital-based emergency department or outpatient department (event)")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"450381000124100","Death in nursing home or long term care facility (event)")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.nullFlavorHL7System,"OTH","Other")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.nullFlavorHL7System,"UNK","Unknown"))
			));
}
