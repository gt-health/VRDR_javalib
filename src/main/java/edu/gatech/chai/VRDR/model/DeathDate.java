package edu.gatech.chai.VRDR.model;

import java.util.Date;

import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Location;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.VRDR.model.util.CommonUtil;
import edu.gatech.chai.VRDR.model.util.DeathDateUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-death-date")
public class DeathDate extends Observation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493914021771207783L;

	public DeathDate() {
		super();
		CommonUtil.initResource(this);
		setCode(DeathDateUtil.code);
		setStatus(DeathDateUtil.status);
	}

	public DeathDate(Date effectiveDateTime,Date datePronouncedDead) {
		this();
		setEffective(new DateTimeType(effectiveDateTime));
		addDatePronouncedDead(new DateTimeType(datePronouncedDead));
	}

	public void addPatientLocationExtension(Location location) {
		Extension extension = new Extension(DeathDateUtil.patientLocationExtensionURL);
		Reference reference = new Reference(location.getId());
		extension.setValue(reference);
		this.addExtension(extension);
	}

	public Extension getPatientLocationExtension() {
		return CommonUtil.getExtension(this, DeathDateUtil.patientLocationExtensionURL);
	}

	public void addEstimatedMethod() {
		setMethod(DeathDateUtil.method);
	}
	
	public void addDatePronouncedDead(DateTimeType dtType) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DeathDateUtil.componentDatePronouncedDeadCode);
		component.setValue(dtType);
		addComponent(component);
	}
	
	public DeathDate addPartialDateExtension(IntegerType year,String yearDataAbsentReason, IntegerType month,String monthDataAbsentReason,
			IntegerType day,String dayDataAbsentReason) {
		if(this.value == null) {
			this.value = new DateTimeType(); //Assuming a datetime value if uninitiated
		}
		Extension baseExtension = addPartialDateBaseExtension();
		addPartialDateYear(baseExtension,year,yearDataAbsentReason);
		addPartialDateMonth(baseExtension,month,monthDataAbsentReason);
		addPartialDateDay(baseExtension,day,dayDataAbsentReason);
		this.value.addExtension(baseExtension);
		return this;
	}
	
	private Extension addPartialDateBaseExtension() {
		Extension baseExtension = new Extension(CommonUtil.partialDatePartAbsentReasonURL);
		return baseExtension;
	}
	
	private DeathDate addPartialDateYear(Extension baseExtension, IntegerType year,String dataAbsentReason) {
		if(dataAbsentReason != null && !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateYearAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(year != null && !year.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateYearURL,year));
		}
		return this;
	}
	
	private DeathDate addPartialDateMonth(Extension baseExtension, IntegerType month,String dataAbsentReason) {
		if(dataAbsentReason != null && !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateMonthAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(month != null && !month.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateMonthURL,month));
		}
		return this;
	}
	
	private DeathDate addPartialDateDay(Extension baseExtension, IntegerType day,String dataAbsentReason) {
		if(dataAbsentReason != null || !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateDayAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(day != null && !day.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateDayURL,day));
		}
		return this;
	}
}
