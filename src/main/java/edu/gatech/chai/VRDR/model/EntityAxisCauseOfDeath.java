package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Type;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.EntityAxisCauseOfDeathUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-entity-axis-cause-of-death")
public class EntityAxisCauseOfDeath extends Observation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1775205638319513588L;

	public EntityAxisCauseOfDeath() {
		super();
		CommonUtil.initResource(this);
		this.setCode(EntityAxisCauseOfDeathUtil.code);
	}
	
	public EntityAxisCauseOfDeath(Decedent decedent) {
		this();
		setSubject(new Reference(decedent));
	}
	
	public Observation addLineNumber(int lineNumber) {
		return addComponent(EntityAxisCauseOfDeathUtil.lineNumberComponentCode,new IntegerType(lineNumber));
	}
	
	public Observation addPosition(int position) {
		return addComponent(EntityAxisCauseOfDeathUtil.positionComponentCode,new IntegerType(position));
	}
	
	public Observation addECodeIndicator(boolean eCodeIndicator) {
		return addComponent(EntityAxisCauseOfDeathUtil.positionComponentCode,new BooleanType(eCodeIndicator));
	}
	
	public Observation addComponent(CodeableConcept code, Type value) {
		ObservationComponentComponent occ = new ObservationComponentComponent();
		occ.setCode(code);
		occ.setValue(value);
		addComponent(occ);
		return this;
	}
}