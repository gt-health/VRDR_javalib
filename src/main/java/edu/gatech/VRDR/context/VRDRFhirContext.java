package edu.gatech.VRDR.context;

import ca.uhn.fhir.context.FhirContext;
import edu.gatech.VRDR.model.BirthRecordIdentifier;
import edu.gatech.VRDR.model.Certifier;
import edu.gatech.VRDR.model.DeathCertificate;
import edu.gatech.VRDR.model.DeathCertificateDocument;
import edu.gatech.VRDR.model.Decedent;
import edu.gatech.VRDR.model.InjuryLocation;

public class VRDRFhirContext {
	FhirContext ctx;

	public VRDRFhirContext() {
		ctx = FhirContext.forDstu3();
		ctx.setDefaultTypeForProfile("http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Birth-Record-Identifier",
				BirthRecordIdentifier.class);
		ctx.setDefaultTypeForProfile("http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Certifier",
				Certifier.class);
		ctx.setDefaultTypeForProfile("http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate",
				DeathCertificate.class);
		ctx.setDefaultTypeForProfile(
				"http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate-Document",
				DeathCertificateDocument.class);
		ctx.setDefaultTypeForProfile("http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent",
				Decedent.class);
		ctx.setDefaultTypeForProfile("http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Injury-Location",
				InjuryLocation.class);
	}

	public FhirContext getCtx() {
		return ctx;
	}

	public void setCtx(FhirContext ctx) {
		this.ctx = ctx;
	}

}
