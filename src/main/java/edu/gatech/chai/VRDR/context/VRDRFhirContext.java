package edu.gatech.chai.VRDR.context;

import ca.uhn.fhir.context.FhirContext;
import edu.gatech.chai.VRDR.model.AutopsyPerformedIndicator;
import edu.gatech.chai.VRDR.model.BirthRecordIdentifier;
import edu.gatech.chai.VRDR.model.CauseOfDeathCondition;
import edu.gatech.chai.VRDR.model.CauseOfDeathPathway;
import edu.gatech.chai.VRDR.model.Certifier;
import edu.gatech.chai.VRDR.model.ConditionContributingToDeath;
import edu.gatech.chai.VRDR.model.DeathCertificate;
import edu.gatech.chai.VRDR.model.DeathCertificateDocument;
import edu.gatech.chai.VRDR.model.DeathCertificateReference;
import edu.gatech.chai.VRDR.model.DeathCertification;
import edu.gatech.chai.VRDR.model.DeathDate;
import edu.gatech.chai.VRDR.model.DeathLocation;
import edu.gatech.chai.VRDR.model.DeathPronouncementPerformer;
import edu.gatech.chai.VRDR.model.Decedent;
import edu.gatech.chai.VRDR.model.DecedentAge;
import edu.gatech.chai.VRDR.model.DecedentDispositionMethod;
import edu.gatech.chai.VRDR.model.DecedentEducationLevel;
import edu.gatech.chai.VRDR.model.DecedentFather;
import edu.gatech.chai.VRDR.model.DecedentMother;
import edu.gatech.chai.VRDR.model.DecedentPregnancy;
import edu.gatech.chai.VRDR.model.DecedentSpouse;
import edu.gatech.chai.VRDR.model.DecedentTransportationRole;
import edu.gatech.chai.VRDR.model.DecedentUsualWork;
import edu.gatech.chai.VRDR.model.DispositionLocation;
import edu.gatech.chai.VRDR.model.ExaminerContacted;
import edu.gatech.chai.VRDR.model.FuneralHome;
import edu.gatech.chai.VRDR.model.FuneralServiceLicensee;
import edu.gatech.chai.VRDR.model.InjuryIncident;
import edu.gatech.chai.VRDR.model.InjuryLocation;
import edu.gatech.chai.VRDR.model.InterestedParty;
import edu.gatech.chai.VRDR.model.MannerOfDeath;
import edu.gatech.chai.VRDR.model.Mortician;
import edu.gatech.chai.VRDR.model.TobaccoUseContributedToDeath;

public class VRDRFhirContext {
	FhirContext ctx;

	public VRDRFhirContext() {
		ctx = FhirContext.forR4();
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Autopsy-Performed-Indicator",
				AutopsyPerformedIndicator.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Birth-Record-Identifier",
				BirthRecordIdentifier.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Cause-Of-Death-Condition",
				CauseOfDeathCondition.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Cause-of-Death-Pathway",
				CauseOfDeathPathway.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Certifier",
				Certifier.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Condition-Contributing-To-Death",
				ConditionContributingToDeath.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate",
				DeathCertificate.class);
		ctx.setDefaultTypeForProfile(
				"http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate-Document",
				DeathCertificateDocument.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate-Reference",
				DeathCertificateReference.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certification",
				DeathCertification.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Date",
				DeathDate.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Location",
				DeathLocation.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Pronouncement-Performer",
				DeathPronouncementPerformer.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent",
				Decedent.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Age",
				DecedentAge.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Disposition-Method",
				DecedentDispositionMethod.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Education-Level",
				DecedentEducationLevel.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Usual-Work",
				DecedentUsualWork.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Father",
				DecedentFather.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Mother",
				DecedentMother.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Pregnancy",
				DecedentPregnancy.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Spouse",
				DecedentSpouse.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Decedent-Transportation-Role",
				DecedentTransportationRole.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Disposition-Location",
				DispositionLocation.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Examiner-Contacted",
				ExaminerContacted.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Funeral-Home",
				FuneralHome.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR_FuneralServiceLicensee",
				FuneralServiceLicensee.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Injury-Incident",
				InjuryIncident.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Injury-Location",
				InjuryLocation.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Interested-Party",
				InterestedParty.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Manner-of-Death",
				MannerOfDeath.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Mortician",
				Mortician.class);
		ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Tobacco-Use-Contributed-To-Death",
				TobaccoUseContributedToDeath.class);
	}

	public FhirContext getCtx() {
		return ctx;
	}

	public void setCtx(FhirContext ctx) {
		this.ctx = ctx;
	}

}
