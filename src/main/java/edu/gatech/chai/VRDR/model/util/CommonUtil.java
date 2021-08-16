package edu.gatech.chai.VRDR.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Composition.SectionComponent;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;

import edu.gatech.chai.VRDR.model.DeathCertificate;
import edu.gatech.chai.VRDR.model.DeathCertificateDocument;

public class CommonUtil {
	public static String basicBooleanHL7System = "http://hl7.org/CodeSystem/v2-0136";
	public static String nullFlavorHL7System = "http://hl7.org/fhir/v3/NullFlavor";
	public static String snomedSystemUrl = "http://snomed.info/sct";
	public static String loincSystemUrl = "http://loinc.org";
	public static String withinCityLimitsIndicatorUrl = "http://hl7.org/fhir/us/vrdr/StructureDefinition/Within-City-Limits-Indicator";
	public static String locationJurisdictionUrl = "FIPS 5-2 (State)";
	public static String dataAbsentReasonUrl = "http://terminology.hl7.org/CodeSystem/data-absent-reason";
	public static final String partialDatePartAbsentReasonURL = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Partial-date-part-absent-reason";
	public static final String partialDateDateYearURL = "date-year";
	public static final String partialDateDateYearAbsentReasonURL = "year-absent-reason";
	public static final String partialDateDateMonthURL = "date-month";
	public static final String partialDateDateMonthAbsentReasonURL = "month-absent-reason";
	public static final String partialDateDateDayURL = "date-day";
	public static final String partialDateDateDayAbsentReasonURL = "day-absent-reason";
	public static CodeableConcept noCode = new CodeableConcept().addCoding(new Coding(basicBooleanHL7System,"N","No"));
	public static CodeableConcept yesCode = new CodeableConcept().addCoding(new Coding(basicBooleanHL7System,"Y","Yes"));
	public static CodeableConcept unknownCode = new CodeableConcept().addCoding(new Coding(nullFlavorHL7System,"UNK","unknown"));
	public static CodeableConcept otherCode = new CodeableConcept().addCoding(new Coding(nullFlavorHL7System,"OTH","other"));
	public static CodeableConcept notApplicableCode = new CodeableConcept().addCoding(new Coding(nullFlavorHL7System,"NA","not applicable"));
	public static CodeableConcept notAskedCode = new CodeableConcept().addCoding(new Coding(nullFlavorHL7System,"NASK","not asked"));
	public static String deathReportingIdentifierTypeSystem = "urn:oid:2.16.840.1.114222.4.11.7382";
	public static CodeableConcept deathCertificateIdCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"DC","Death Certificate Id"));
	public static CodeableConcept deathCertificateFileNumberCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"DCFN","Death Certificate File Number"));
	public static CodeableConcept deathCertificateLicenseNumberCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"LN","Death Certificate License Number"));
	public static CodeableConcept nationalProviderIdentifierCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"NPI","National provider identifier"));
	public static CodeableConcept stateRegistryIdCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"SR","State Registry ID"));
	public static CodeableConcept SocialSecurityNumberCode = new CodeableConcept().addCoding(new Coding(deathReportingIdentifierTypeSystem,"SS","Social Security Number"));
	public static List<CodeableConcept> deathReportingIdentifierTypeCodes = new ArrayList<CodeableConcept>(Arrays.asList(deathCertificateIdCode,deathCertificateFileNumberCode,deathCertificateLicenseNumberCode,
			nationalProviderIdentifierCode,stateRegistryIdCode,SocialSecurityNumberCode));
	public static final HashSet<CodeableConcept> certifierTypeSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"455381000124109","Medical Examiner/Coroner")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"434641000124105","Physician certifed and pronounced death certificate")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.snomedSystemUrl,"434651000124107","Physician certified death certificate"))));
	public static final HashSet<CodeableConcept> yesNoUnknownSet = new HashSet<>(Arrays.asList(yesCode,noCode,unknownCode));
	public static final HashSet<CodeableConcept> yesNoNASet = new HashSet<>(Arrays.asList(yesCode,noCode,notApplicableCode));
	public static final HashSet<CodeType> dataAbsentReasonCodeSet = new HashSet<>(Arrays.asList(
			new CodeType("unknown"),
			new CodeType("asked-unknown"),
			new CodeType("not-asked"),
			new CodeType("asked-declined"),
			new CodeType("masked"),
			new CodeType("not-applicable"),
			new CodeType("unsupported"),
			new CodeType("as-text"),
			new CodeType("error"),
			new CodeType("not-a-number"),
			new CodeType("negative-infinity"),
			new CodeType("positive-infinity"),
			new CodeType("not-performed"),
			new CodeType("not-permitted")));
	public static final HashSet<CodeableConcept> dataAbsentReasonConceptSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"unknown","Unknown")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"asked-unknown","Asked But Unknown")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"not-asked", "Not Asked")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"asked-declined", "Asked By Declined")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"masked", "Masked")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"not-applicable", "Not Applicable")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"unsupported", "Unsuppported")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"as-text", "As Text")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"error", "Error")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"not-a-number", "Not a Number (NaN)")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"negative-infinity", "Negative infinifty (NINF)")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"positive-infinity", "Positive Inifinity (PINF)")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"not-performed", "Not Performed")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.dataAbsentReasonUrl,"not-permitted", "Not Permitted"))));
	public static final HashSet<CodeableConcept> locationJurisdictionalConceptSet = new HashSet<>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"AL","Alabama")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"AK","Alaska")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"AR", "Arkansas")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"AS", "American Samoa")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl, "AZ", "Arizona")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"CA", "California")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"CO", "Colorado")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"CT", "Connecticut")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"DC", "District of Columbia")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"DE", "Delaware")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"FL", "Florida")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"GA", "Georgia")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"GU", "Guam")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"HI", "Hawaii")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"IA", "Iowa")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"ID", "Idaho")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"IL", "Illinois")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"IN", "Indiana")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"KS", "Kansas")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"LA", "Louisiana")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MA", "Massachusetts")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MD", "Maryland")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"ME", "Maine")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MI", "Michigan")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MN", "Minnesota")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MO", "Missouri")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MP", "Northern Mariana Islands")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MS", "Mississippi")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"MT", "Montana")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"NC", "North Carolina")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"ND", "North Dekota")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"NE", "Nebraska")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"NH", "New Hampshire")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"NJ", "New Jersey")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"NM", "New Mexico")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"NV", "Nevada")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"NY", "New York")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"OH", "Ohio")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"OK", "Oklahoma")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"OR", "Oregon")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"PA", "Pennsylvania")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"PR", "Puerto Rico")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"RI", "Rhode Island")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"SC", "South Carolina")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"SD", "South Dakota")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"TN", "Tennessee")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"TX", "Texas")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"UT", "Utah")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"VA", "Virginia")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"VI", "U.S. Virgin Islands")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"VT", "Vermont")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"WA", "Washington")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"WI", "Wisconsin")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"WV", "West Virginia")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"WY", "Wyoming")),
			new CodeableConcept().addCoding(new Coding(CommonUtil.locationJurisdictionUrl,"YC", "New York City"))));
	public static Extension getExtension(DomainResource resource, String url) {
		for (Extension extension : resource.getExtension()) {
			if (extension.getUrl().equals(url)) {
				return extension;
			}
		}
		return null;
	}

	public static void initResource(Resource resource) {
		//setUUID(resource);
	}
	
	public static void setUUID(Resource resource) {
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
	
	public static CodeableConcept findConceptFromCollectionUsingSimpleString(String key,Collection<CodeableConcept> collection) {
		for(CodeableConcept conceptIter:collection) {
			Coding coding = conceptIter.getCodingFirstRep();
			if(coding.getCode().equalsIgnoreCase(key) || coding.getDisplay().equalsIgnoreCase(key)) {
				return conceptIter;
			}
		}
		return null;
	}
	
	public static CodeType findCodeFromCollectionUsingSimpleString(String key,Collection<CodeType> collection) {
		for(CodeType conceptIter:collection) {
			if(conceptIter.getValue().equalsIgnoreCase(key)) {
				return conceptIter;
			}
		}
		return null;
	}
	
	public static Address addCityLimitsIndicator(CodeableConcept indicator,Address address) {
		Extension extension = new Extension();
		extension.setUrl(withinCityLimitsIndicatorUrl);
		extension.setValue(indicator);
		address.addExtension(extension);
		return address;
	}
	
	public static Address addCityLimitsIndicator(String indicator,Address address) {
		CodeableConcept ccIndicator = findConceptFromCollectionUsingSimpleString(indicator, yesNoUnknownSet);
		return addCityLimitsIndicator(ccIndicator, address);
	}
}