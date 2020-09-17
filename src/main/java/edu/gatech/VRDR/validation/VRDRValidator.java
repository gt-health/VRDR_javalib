package edu.gatech.VRDR.validation;

import org.hl7.fhir.r4.model.Patient;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.IValidatorModule;
import ca.uhn.fhir.validation.SchemaBaseValidator;
import ca.uhn.fhir.validation.SingleValidationMessage;
import ca.uhn.fhir.validation.ValidationResult;
import edu.gatech.VRDR.context.VRDRFhirContext;

public class VRDRValidator {
	public static void testValidation() {
		FhirContext ctx = new VRDRFhirContext().getCtx();
		
		FhirValidator validator = ctx.newValidator();
		IValidatorModule module1 = new SchemaBaseValidator(ctx);
		validator.registerValidatorModule(module1);
		Patient resource = new Patient();
		ValidationResult result = validator.validateWithResult(resource);
		// The result object now contains the validation results
		for (SingleValidationMessage next : result.getMessages()) {
		   System.out.println(next.getLocationString() + " " + next.getMessage());
		}
	}
	
	public static void testSampleBundle() {
		FhirContext ctx = new VRDRFhirContext().getCtx();
		FhirValidator validator = ctx.newValidator();
		IValidatorModule module1 = new SchemaBaseValidator(ctx);
		validator.registerValidatorModule(module1);
		
	}
}
