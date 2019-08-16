package edu.gatech.VRDR.model;

import java.util.UUID;

import org.hl7.fhir.dstu3.model.IdType;
import org.hl7.fhir.dstu3.model.Procedure;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DeathCertificationUtil;

@ResourceDef(name="Procedure", profile="http://www.hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certification")
public class DeathCertification extends Procedure{

	public DeathCertification() {
		super();
		CommonUtil.initResource(this);
		setStatus(ProcedureStatus.COMPLETED);
		setCategory(DeathCertificationUtil.categoryFixedValue);
		setCode(DeathCertificationUtil.codeFixedValue);
	}
	
}
