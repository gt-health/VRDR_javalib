# VRDR_javalib
Java library implementation of the VRDR fhir standard http://hl7.org/fhir/us/vrdr/
# Info
This project uses the hapi-fhir java libraries extensively to create it's representation. It is recommended to have a strong understanding of the resource extension section of the hapi-fhir library before diving into the code. Info can be found here. https://hapifhir.io/hapi-fhir/docs/model/custom_structures.html

This project is made up of 2 major components.
* ```edu.gatech.VRDR.model``` Contains all the custom resources needed for the VRDR guide.
* ```edu.gatech.VRDR.model.util``` Contains utility methods like custom codes and static definitions per resources.

You can refer to the ```src/test``` directory for an in-depth unit test example on how to construct a full EDRS record, and serialize it to JSON
