package edu.gatech.chai.VRDR.model.util;

import java.util.Arrays;
import java.util.HashSet;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class ConditionContributingToDeathUtil {
	public static final String conditionalClinicalSystemUrl = "http://terminology.hl7.org/CodeSystem/condition-clinical";
	public static final String verificationSystemUrl = "http://terminology.hl7.org/CodeSystem/condition-ver-status";
	public static final String categorySystemUrl = "http://hl7.org/fhir/us/core/ValueSet/us-core-condition-category";
	public static final HashSet<CodeableConcept> conditionClinicalStatusSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(conditionalClinicalSystemUrl,"active","Active")),
			new CodeableConcept().addCoding(new Coding(conditionalClinicalSystemUrl,"recurrence","Recurrence")),
			new CodeableConcept().addCoding(new Coding(conditionalClinicalSystemUrl,"relapse","Relapse")),
			new CodeableConcept().addCoding(new Coding(conditionalClinicalSystemUrl,"inactive","Inactive")),
			new CodeableConcept().addCoding(new Coding(conditionalClinicalSystemUrl,"remission","Remission")),
			new CodeableConcept().addCoding(new Coding(conditionalClinicalSystemUrl,"resolved","Resolved"))));
	public static final HashSet<CodeableConcept> verificationStatusSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(verificationSystemUrl,"unconfirmed","Unconfirmed")),
			new CodeableConcept().addCoding(new Coding(verificationSystemUrl,"provisional","Provisional")),
			new CodeableConcept().addCoding(new Coding(verificationSystemUrl,"differential","Differential")),
			new CodeableConcept().addCoding(new Coding(verificationSystemUrl,"confirmed","Confirmed")),
			new CodeableConcept().addCoding(new Coding(verificationSystemUrl,"refuted","Refuted")),
			new CodeableConcept().addCoding(new Coding(verificationSystemUrl,"entered-in-error","Entered-in-Error"))));
	/*public static final HashSet<CodeableConcept> categorySet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(categorySystemUrl,"problem-list-item","Problem List Item")),
			new CodeableConcept().addCoding(new Coding(categorySystemUrl,"encounter-diagnosis","Encounter Diagnosis")),
			new CodeableConcept().addCoding(new Coding(categorySystemUrl,"health-concern","Health Concern"))));*/
	public static final CodeableConcept conditionContributingToDeathCategory = new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl, "16100001", "Death Diagnosis"));
}
