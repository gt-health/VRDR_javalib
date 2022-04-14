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
import edu.gatech.chai.VRDR.model.util.RecordAxisCauseOfDeathUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-record-axis-cause-of-death")
public class RecordAxisCauseOfDeath extends Observation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1775205638319513588L;

	public RecordAxisCauseOfDeath() {
		super();
		CommonUtil.initResource(this);
		this.setCode(RecordAxisCauseOfDeathUtil.code);
	}
	
	public RecordAxisCauseOfDeath(Decedent decedent) {
		this();
		setSubject(new Reference(decedent));
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