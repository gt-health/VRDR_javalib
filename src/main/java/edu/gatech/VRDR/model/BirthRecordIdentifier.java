package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.BirthRecordIdentifierUtil;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name="BirthRecordIdentifier", profile="http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Birth-Record-Identifier")
public class BirthRecordIdentifier extends Observation{
	
	public BirthRecordIdentifier(Decedent subject, StringType value,CodeableConcept birthState,CodeableConcept birthYear) {
		super();
		CommonUtil.initResource(this);
		setStatus(BirthRecordIdentifierUtil.status);
		setCode(BirthRecordIdentifierUtil.code);
		setSubject(new Reference(subject));
		setValue(value);
		addBirthState(birthState);
		addBirthYear(birthYear);
	}
	
	public CodeableConcept getBirthState() {
		for(ObservationComponentComponent component:getComponent()) {
			if(component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthStateCode)) {
				return component.getValueCodeableConcept();
			}
		}
		return null;
	}
	
	public void setBirthState(CodeableConcept birthState) {
		for(ObservationComponentComponent component:getComponent()) {
			if(component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthStateCode)) {
				component.setValue(birthState);
				return;
			}
		}
		addBirthState(birthState);
	}
	
	public CodeableConcept getBirthYear() {
		for(ObservationComponentComponent component:getComponent()) {
			if(component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthYearCode)) {
				return component.getValueCodeableConcept();
			}
		}
		return null;
	}
	
	public void setBirthYear(CodeableConcept birthYear) {
		for(ObservationComponentComponent component:getComponent()) {
			if(component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthYearCode)) {
				component.setValue(birthYear);
				return;
			}
		}
		addBirthYear(birthYear);
	}
	
	private void addBirthState(CodeableConcept birthState) {
		ObservationComponentComponent birthStateComponent = new ObservationComponentComponent();
		birthStateComponent.setCode(BirthRecordIdentifierUtil.componentBirthStateCode);
		birthStateComponent.setValue(birthState);
		addComponent(birthStateComponent);
	}
	
	private void addBirthYear(CodeableConcept birthYear) {
		ObservationComponentComponent birthYearComponent = new ObservationComponentComponent();
		birthYearComponent.setCode(BirthRecordIdentifierUtil.componentBirthYearCode);
		birthYearComponent.setValue(birthYear);
		addComponent(birthYearComponent);
	}
}
