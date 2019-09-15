package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.ListResource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CauseOfDeathPathwayUtil;
import edu.gatech.VRDR.model.util.CommonUtil;

@ResourceDef(name = "List", profile = "http://hl7.org/fhir/us/vrdr/VRDR-Cause-of-Death-Pathway")
public class CauseOfDeathPathway extends ListResource {
	public CauseOfDeathPathway() {
		super();
		CommonUtil.initResource(this);
		setStatus(CauseOfDeathPathwayUtil.status);
		setMode(CauseOfDeathPathwayUtil.mode);
		setOrderedBy(CauseOfDeathPathwayUtil.orderedByCodeFixedValue);
	}
}
