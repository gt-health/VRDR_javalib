package edu.gatech.VRDR.model.util;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.ListResource;

public class CauseOfDeathPathwayUtil {
	public static final ListResource.ListStatus status = ListResource.ListStatus.CURRENT;
	public static final ListResource.ListMode mode = ListResource.ListMode.SNAPSHOT;
	public static final CodeableConcept orderedByCodeFixedValue = new CodeableConcept()
			.addCoding(new Coding("http://hl7.org/fhir/ValueSet/list-order", "priority", "Sorted by Priority"));
}
