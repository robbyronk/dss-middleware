package org.cru.give.validators;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.cru.give.webservices.model.GiftDetails;


public class ValidateGift
{
	@Inject ValidateFrequency validateFrequency;
	
	List<ValidationError> validationErrors = new ArrayList<ValidationError>();
	
	public String validate(GiftDetails gift) throws IOException
	{
		ValidationError frequencyValidationError = validateFrequency.validate(gift);
		if(frequencyValidationError != null) validationErrors.add(frequencyValidationError);

		return serializeErrors();
	}
	
	private String serializeErrors() throws IOException
	{
		if(validationErrors.isEmpty()) return null;

		 JsonFactory f = new JsonFactory();
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 
		 JsonGenerator g = f.createJsonGenerator(out);
		 g.writeStartObject();
		 g.writeArrayFieldStart("fields");
		 g.writeStartArray();

		 for(ValidationError error : validationErrors)
		 {
			 g.writeStartObject();
			 g.writeFieldName("field-name");
			 g.writeString(error.getFieldName());
			 g.writeFieldName("error-message");
			 g.writeString(error.getError().message);
			 g.writeEndObject();
		 }
		 g.writeEndArray();
		 
		 g.close();
		 
		 validationErrors.clear();
		 
		 return out.toString();
		 
	}
}
