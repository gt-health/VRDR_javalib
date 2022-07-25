package edu.gatech.chai.VRDR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class EntityAxisCauseOfDeathUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(new Coding(CommonUtil.loincSystemUrl, "80356-9", "Cause of death entity axis code [Automated]"));
	public static final CodeableConcept lineNumberComponentCode = new CodeableConcept().addCoding(new Coding("", "lineNumber", "lineNumber"));
	public static final CodeableConcept positionComponentCode = new CodeableConcept().addCoding(new Coding("", "position", "position"));
	public static final CodeableConcept eCodeIndicatorComponentCode = new CodeableConcept().addCoding(new Coding("", "eCodeIndicator", "eCodeIndicator"));
}