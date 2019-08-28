package edu.gatech.VRDR.model.util;

import java.util.UUID;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.DomainResource;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.Composition.SectionComponent;

import edu.gatech.VRDR.model.DeathCertificate;
import edu.gatech.VRDR.model.DeathCertificateDocument;

public class CommonUtil {
	public static Extension getExtension(DomainResource resource, String url) {
		for (Extension extension : resource.getExtension()) {
			if (extension.getUrl().equals(url)) {
				return extension;
			}
		}
		return null;
	}

	public static void initResource(Resource resource) {
		resource.setId(new IdType(UUID.randomUUID().toString()));
	}
	
	public static Bundle addBundleEntry(DeathCertificateDocument deathCertificateDocument, Resource resource) {
		deathCertificateDocument.addEntry().setResource(resource).setFullUrl(resource.getId());
		return deathCertificateDocument;
	}
	
	public static DeathCertificate addSection(DeathCertificate deathCertificate,Resource resource) {
		deathCertificate.addSection(new SectionComponent().addEntry(new Reference(resource.getId())));
		return deathCertificate;
	}
}