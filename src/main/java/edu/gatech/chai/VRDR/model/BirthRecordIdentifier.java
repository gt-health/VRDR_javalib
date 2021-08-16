package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.BirthRecordIdentifierUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-BirthRecordIdentifier")
public class BirthRecordIdentifier extends Observation {

	public BirthRecordIdentifier() {
		super();
		CommonUtil.initResource(this);
	}
	
	public BirthRecordIdentifier(String value, CodeableConcept birthState,
			DateTimeType birthYear) {
		this();
		setStatus(BirthRecordIdentifierUtil.status);
		setCode(BirthRecordIdentifierUtil.code);
		setValue(new StringType(value));
		addBirthState(birthState);
		addBirthYear(birthYear);
	}

	public CodeableConcept getBirthState() {
		for (ObservationComponentComponent component : getComponent()) {
			if (component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthStateCode)) {
				return component.getValueCodeableConcept();
			}
		}
		return null;
	}

	public void setBirthState(CodeableConcept birthState) {
		for (ObservationComponentComponent component : getComponent()) {
			if (component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthStateCode)) {
				component.setValue(birthState);
				return;
			}
		}
		addBirthState(birthState);
	}

	public DateTimeType getBirthYear() {
		for (ObservationComponentComponent component : getComponent()) {
			if (component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthYearCode)) {
				return component.getValueDateTimeType();
			}
		}
		return null;
	}

	public void setBirthYear(DateTimeType birthYear) {
		for (ObservationComponentComponent component : getComponent()) {
			if (component.getCode().equalsShallow(BirthRecordIdentifierUtil.componentBirthYearCode)) {
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

	private void addBirthYear(DateTimeType birthYear) {
		ObservationComponentComponent birthYearComponent = new ObservationComponentComponent();
		birthYearComponent.setCode(BirthRecordIdentifierUtil.componentBirthYearCode);
		birthYearComponent.setValue(birthYear);
		addComponent(birthYearComponent);
	}
	
	public BirthRecordIdentifier setDataAbsentReason(String dataAbsentReason) {
		this.setDataAbsentReason(CommonUtil.findConceptFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonConceptSet));
		return this;
	}
}
