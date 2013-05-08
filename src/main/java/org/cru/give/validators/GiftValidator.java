package org.cru.give.validators;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.cru.give.webservices.model.GiftDetails;

public class GiftValidator
{
	@Inject ValidateFrequency validateFrequency;
	@Inject StartDateValidator validateStartDate;
	
	List<ValidationError> validationErrors = new ArrayList<ValidationError>();
	
	public void validateInputIfNecessary(GiftDetails gift, org.jboss.resteasy.spi.HttpResponse response) throws IOException
	{
		if(!gift.isValidate()) return;
		
		String errors = validate(gift);
		if(errors != null)
		{
			response.sendError(400,errors);
		}
	}
	
	public String validate(GiftDetails gift) throws IOException
	{
		ValidationError frequencyValidationError = validateFrequency.validate(gift);
		if(frequencyValidationError != null) validationErrors.add(frequencyValidationError);

		ValidationError startDateValidationError = validateStartDate.validate(gift);
		if(startDateValidationError != null) validationErrors.add(startDateValidationError);
		
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
			 g.writeFieldName("general-error-message");
			 g.writeString(error.getError().message);
			 g.writeFieldName("specific-error-message");
			 g.writeString(error.getCustomErrorMessage());
			 g.writeEndObject();
		 }
		 g.writeEndArray();
		 
		 g.close();
		 
		 validationErrors.clear();
		 
		 return out.toString();
		 
	}
}
