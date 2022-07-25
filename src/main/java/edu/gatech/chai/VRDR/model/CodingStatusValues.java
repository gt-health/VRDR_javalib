package edu.gatech.chai.VRDR.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CodingStatusValuesUtil;
import edu.gatech.chai.VRDR.model.util.CommonUtil;

@ResourceDef(name = "Parameters", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-coding-status-values")
public class CodingStatusValues extends Parameters {

	public CodingStatusValues() {
		super();
		CommonUtil.initResource(this);
	}
	
	public Parameters addShipmentNumber(String value) {
		return addParameter("shipmentNumber",value);
	}
	
	public Parameters addReceiptDate(String value) {
		return addParameter("receiptDate",value);
	}
	
	public Parameters addCoderStatus(String value) {
		return addParameter("coderStatus",value);
	}
	
	public Parameters addIntentionalReject(String value) {
		CodeableConcept ccValue = CommonUtil.findConceptFromCollectionUsingSimpleString(value, CodingStatusValuesUtil.intentionalRejectValueset); 
		return addParameter("intentionalReject",ccValue);
	}
	
	public Parameters addAcmeSystemReject(String value) {
		CodeableConcept ccValue = CommonUtil.findConceptFromCollectionUsingSimpleString(value, CodingStatusValuesUtil.intentionalRejectValueset); 
		return addParameter("acmeSystemReject",ccValue);
	}
	
	public Parameters addTransaxConversion(String value) {
		CodeableConcept ccValue = CommonUtil.findConceptFromCollectionUsingSimpleString(value, CodingStatusValuesUtil.intentionalRejectValueset); 
		return addParameter("transaxConversion",ccValue);
	}
	
	public Parameters addParameter(String name, String value) {
		ParametersParameterComponent ppc = new ParametersParameterComponent();
		ppc.setName(name);
		ppc.setValue(new StringType(value));
		this.addParameter(ppc);
		return this;
	}
	
	public Parameters addParameter(String name, CodeableConcept value) {
		ParametersParameterComponent ppc = new ParametersParameterComponent();
		ppc.setName(name);
		ppc.setValue(value);
		this.addParameter(ppc);
		return this;
	}
}