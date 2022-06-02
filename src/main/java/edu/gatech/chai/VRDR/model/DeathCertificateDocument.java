package edu.gatech.chai.VRDR.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Composition.CompositionStatus;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathCertificateDocumentUtil;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-death-certificate-document")
public class DeathCertificateDocument extends Bundle {

	public DeathCertificateDocument() {
		super();
		CommonUtil.initResource(this);
		setType(BundleType.DOCUMENT);
	}
	
	public DeathCertificateDocument(CompositionStatus status, Decedent decedent, DeathCertificationProcedure deathCertificationProcedure) {
		super();
		CommonUtil.initResource(this);
		setType(BundleType.DOCUMENT);
		DeathCertificate deathCertificate = new DeathCertificate(status,decedent,deathCertificationProcedure);
		CommonUtil.initResource(deathCertificate);
		this.addEntry(new BundleEntryComponent().setResource(deathCertificate));
	}
	
	public void addAuxillaryStateIdentifier(String auxillaryStateIdentifierValue) {
		Extension extension = new Extension();
		extension.setUrl(DeathCertificateDocumentUtil.auxillaryStateIndentifierUrl);
		extension.setValue(new StringType(auxillaryStateIdentifierValue));
		this.getIdentifier().addExtension(extension);
	}
	
	public void addResource(Resource resource) {
		DeathCertificate deathCertificate = getDeathCertificate().get(0);
		deathCertificate.addResource(resource);
		this.addEntry(new BundleEntryComponent().setResource(deathCertificate));
	}
	
	//Helper Accessor methods
	
	private List<Resource> getRecords(Class<? extends Resource> type){
		List<Resource> returnList = new ArrayList<Resource>();
		for(BundleEntryComponent bec:this.getEntry()) {
			Resource resource = bec.getResource();
			if(type.isInstance(resource)) {
				returnList.add(resource);
			}
		}
		return returnList;
	}
	private <T extends Resource> List<T> castListOfRecords(List<Resource> inputList){
		List<T> outputList = inputList
			    .stream()
			    .map(e -> (T) e)
			    .collect(Collectors.toList());
		return outputList;
	}
	
	public List<AutopsyPerformedIndicator> getAutopsyPerformedIndicator(){
		List<Resource> resources = getRecords(AutopsyPerformedIndicator.class);
		return castListOfRecords(resources);
	}
	
	public List<BirthRecordIdentifier> getBirthRecordIdentifier(){
		List<Resource> resources = getRecords(BirthRecordIdentifier.class);
		return castListOfRecords(resources);
	}
	
	public List<CauseOfDeathPart1> getCauseOfDeathCondition(){
		List<Resource> resources = getRecords(CauseOfDeathPart1.class);
		return castListOfRecords(resources);
	}

	public List<CauseOfDeathPart2> getConditionContributingToDeath(){
		List<Resource> resources = getRecords(CauseOfDeathPart2.class);
		return castListOfRecords(resources);
	}

	public List<CauseOfDeathPathway> getCauseOfDeathPathway(){
		List<Resource> resources = getRecords(CauseOfDeathPathway.class);
		return castListOfRecords(resources);
	}
	
	public List<Certifier> getCertifier(){
		List<Resource> resources = getRecords(Certifier.class);
		return castListOfRecords(resources);
	}
	
	public List<DeathCertificate> getDeathCertificate(){
		List<Resource> resources = getRecords(DeathCertificate.class);
		return castListOfRecords(resources);
	}
	
	public List<DeathCertificateReference> getDeathCertificateReference(){
		List<Resource> resources = getRecords(DeathCertificateReference.class);
		return castListOfRecords(resources);
	}
	
	public List<DeathCertificationProcedure> getDeathCertificationProcedure(){
		List<Resource> resources = getRecords(DeathCertificationProcedure.class);
		return castListOfRecords(resources);
	}
	
	public List<DeathDate> getDeathDate(){
		List<Resource> resources = getRecords(DeathDate.class);
		return castListOfRecords(resources);
	}
	
	public List<DeathLocation> getDeathLocation(){
		List<Resource> resources = getRecords(DeathLocation.class);
		return castListOfRecords(resources);
	}
	
	public List<DeathPronouncementPerformer> getDeathPronouncementPerformer(){
		List<Resource> resources = getRecords(DeathPronouncementPerformer.class);
		return castListOfRecords(resources);
	}
	
	public List<Decedent> getDecedent(){
		List<Resource> resources = getRecords(Decedent.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentAge> getDecedentAge(){
		List<Resource> resources = getRecords(DecedentAge.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentDispositionMethod> getDecedentDispositionMethod(){
		List<Resource> resources = getRecords(DecedentDispositionMethod.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentEducationLevel> getDecedentEducationLevel(){
		List<Resource> resources = getRecords(DecedentEducationLevel.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentFather> getDecedentFather(){
		List<Resource> resources = getRecords(DecedentFather.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentMilitaryService> getDecedentMilitaryService(){
		List<Resource> resources = getRecords(DecedentMilitaryService.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentMother> getDecedentMother(){
		List<Resource> resources = getRecords(DecedentMother.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentPregnancyStatus> getDecedentPregnancy(){
		List<Resource> resources = getRecords(DecedentPregnancyStatus.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentSpouse> getDecedentSpouse(){
		List<Resource> resources = getRecords(DecedentSpouse.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentTransportationRole> getDecedentTransportationRole(){
		List<Resource> resources = getRecords(DecedentTransportationRole.class);
		return castListOfRecords(resources);
	}
	
	public List<DecedentUsualWork> getDecedentUsualWork(){
		List<Resource> resources = getRecords(DecedentUsualWork.class);
		return castListOfRecords(resources);
	}
	
	public List<DispositionLocation> getDispositionLocation(){
		List<Resource> resources = getRecords(DispositionLocation.class);
		return castListOfRecords(resources);
	}
	
	public List<ExaminerContacted> getExaminerContacted(){
		List<Resource> resources = getRecords(ExaminerContacted.class);
		return castListOfRecords(resources);
	}
	
	public List<FuneralHome> getFuneralHome(){
		List<Resource> resources = getRecords(FuneralHome.class);
		return castListOfRecords(resources);
	}
	
	public List<FuneralServiceLicensee> getFuneralServiceLicensee(){
		List<Resource> resources = getRecords(FuneralServiceLicensee.class);
		return castListOfRecords(resources);
	}
	
	public List<InjuryIncident> getInjuryIncident(){
		List<Resource> resources = getRecords(InjuryIncident.class);
		return castListOfRecords(resources);
	}
	
	public List<InjuryLocation> getInjuryLocation(){
		List<Resource> resources = getRecords(InjuryLocation.class);
		return castListOfRecords(resources);
	}
	
	public List<InterestedParty> getInterestedParty(){
		List<Resource> resources = getRecords(InterestedParty.class);
		return castListOfRecords(resources);
	}
	
	public List<MannerOfDeath> getMannerOfDeath(){
		List<Resource> resources = getRecords(MannerOfDeath.class);
		return castListOfRecords(resources);
	}
	
	public List<Mortician> getMortician(){
		List<Resource> resources = getRecords(Mortician.class);
		return castListOfRecords(resources);
	}
	
	public List<TobaccoUseContributedToDeath> getTobaccoUseContributedToDeath(){
		List<Resource> resources = getRecords(TobaccoUseContributedToDeath.class);
		return castListOfRecords(resources);
	}
}