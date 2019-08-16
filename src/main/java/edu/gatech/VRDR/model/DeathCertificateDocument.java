package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Bundle;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name="Bundle", profile="http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate-Document")
public class DeathCertificateDocument extends Bundle{
	
	public DeathCertificateDocument() {
		super();
		CommonUtil.initResource(this);
		setType(BundleType.DOCUMENT);
	}
}