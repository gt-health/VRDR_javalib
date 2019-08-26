package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.ListResource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CauseOfDeathPathwayUtil;

@ResourceDef(name = "Cause Of Death Pathway", profile = "http://www.hl7.org/fhir/us/vrdr/VRDR-Cause-of-Death-Pathway")
public class CauseOfDeathPathway extends ListResource {
	public CauseOfDeathPathway() {
		setStatus(CauseOfDeathPathwayUtil.status);
		setMode(CauseOfDeathPathwayUtil.mode);
		setOrderedBy(CauseOfDeathPathwayUtil.orderedByCodeFixedValue);
	}
}
