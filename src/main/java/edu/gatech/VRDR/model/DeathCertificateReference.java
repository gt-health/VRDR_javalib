package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.DocumentReference;
import org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DeathCertificateReferenceUtil;

@ResourceDef(name = "DocumentReference", profile = "http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate-Reference")
public class DeathCertificateReference extends DocumentReference {
	public DeathCertificateReference(DocumentReferenceStatus status) {
		CommonUtil.initResource(this);
		setStatus(status);
		setType(DeathCertificateReferenceUtil.type);
	}
}