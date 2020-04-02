package edu.gatech.VRDR.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Composition.SectionComponent;
import org.hl7.fhir.dstu3.model.DomainResource;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Resource;

import edu.gatech.VRDR.model.DeathCertificate;
import edu.gatech.VRDR.model.DeathCertificateDocument;

public class CommonUtil {
	public static String basicBooleanHL7System = "http://hl7.org/CodeSystem/v2-0136";
	public static String nullFlavorHL7System = "http://hl7.org/fhir/v3/NullFlavor";
	public static CodeableConcept noCode = new CodeableConcept().addCoding(new Coding(basicBooleanHL7System,"N","No"));
	public static CodeableConcept yesCode = new CodeableConcept().addCoding(new Coding(basicBooleanHL7System,"Y","Yes"));
	public static CodeableConcept unknownCode = new CodeableConcept().addCoding(new Coding(nullFlavorHL7System,"UNK","unknown"));
	public static String deathReportingIdentifierTypeSystem = "2.16.840.1.114222.4.11.7382";
	public static CodeableConcept deathCertificateIdCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"DC","Death Certificate Id"));
	public static CodeableConcept deathCertificateFileNumberCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"DCFN","Death Certificate File Number"));
	public static CodeableConcept deathCertificateLicenseNumberCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"LN","Death Certificate License Number"));
	public static CodeableConcept nationalProviderIdentifierCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"NPI","National provider identifier"));
	public static CodeableConcept stateRegistryIdCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"SR","State Registry ID"));
	public static CodeableConcept SocialSecurityNumberCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"SS","Social Security Number"));
	public static List<CodeableConcept> deathReportingIdentifierTypeCodes = new ArrayList<CodeableConcept>(Arrays.asList(deathCertificateIdCode,deathCertificateFileNumberCode,deathCertificateLicenseNumberCode,
			nationalProviderIdentifierCode,stateRegistryIdCode,SocialSecurityNumberCode));
	
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
	
	public static DeathCertificate addSectionEntry(DeathCertificate deathCertificate,Resource resource) {
		if(deathCertificate.getSection() != null && !deathCertificate.getSection().isEmpty()) {
			deathCertificate.addSection(new SectionComponent());
		}
		SectionComponent sectionComponent = deathCertificate.getSectionFirstRep();
		sectionComponent.addEntry(new Reference(resource.getId()));
		return deathCertificate;
	}
	
	public static CodeableConcept findConceptFromCollectionUsingSimpleString(String key,List<CodeableConcept> collection) {
		for(CodeableConcept conceptIter:collection) {
			Coding coding = conceptIter.getCodingFirstRep();
			if(coding.getCode().equalsIgnoreCase(key) || coding.getDisplay().equalsIgnoreCase(key)) {
				return conceptIter;
			}
		}
		return null;
	}
}