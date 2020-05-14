package edu.gatech.VRDR.model;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DeathCertificationUtil;

@ResourceDef(name = "Procedure", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certification")
public class DeathCertification extends Procedure {

	public DeathCertification() {
		super();
		CommonUtil.initResource(this);
		setStatus(ProcedureStatus.COMPLETED);
		setCategory(DeathCertificationUtil.categoryFixedValue);
		setCode(DeathCertificationUtil.codeFixedValue);
	}
	
	public DeathCertification(Date performed) {
		this();
		this.setPerformed(new DateTimeType(performed));
	}
	
	public void addPerformer(Certifier certifier, CodeableConcept function) {
		ProcedurePerformerComponent procedurePerformerComponent = new ProcedurePerformerComponent();
		procedurePerformerComponent.setActor(new Reference(certifier.getId()));
		procedurePerformerComponent.setFunction(function);
		this.addPerformer(procedurePerformerComponent);
	}

}