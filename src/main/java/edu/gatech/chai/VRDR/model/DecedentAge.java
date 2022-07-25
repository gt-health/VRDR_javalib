package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DecedentAgeUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-decedent-age")
public class DecedentAge extends Observation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7680111116236062577L;

	public DecedentAge() {
		super();
	}
	
	public DecedentAge(Reference subject) {
		super();
		CommonUtil.initResource(this);
		super.setStatus(DecedentAgeUtil.status);
		super.setCode(DecedentAgeUtil.code);
		super.setSubject(subject);
	}
	
	public DecedentAge setDataAbsentReason(String dataAbsentReason) {
		super.setDataAbsentReason(CommonUtil.findConceptFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonConceptSet));
		return this;
	}
	
	public DecedentAge(Quantity quantity) {
		super();
		CommonUtil.initResource(this);
		super.setStatus(DecedentAgeUtil.status);
		super.setCode(DecedentAgeUtil.code);
		if(quantity.getCode() == null || !DecedentAgeUtil.values.contains(quantity.getCode())) {
			throw new FHIRException("DecedentAge: Quantity expects a Code of:"+
					DecedentAgeUtil.values);
		}
		super.setValue(quantity);
	}
}