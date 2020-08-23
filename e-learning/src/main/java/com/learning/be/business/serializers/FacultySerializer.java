package com.learning.be.business.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.learning.be.business.dto.FacultyDto;

public class FacultySerializer extends StdSerializer<FacultyDto> {

	private static final long serialVersionUID = -9091258072914356178L;

	public FacultySerializer() {
        this(null);
    }
  
    public FacultySerializer(Class<FacultyDto> t) {
        super(t);
    }
	
	@Override
	public void serialize(FacultyDto value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
//		jgen.writeStartObject();
//		jgen.writeNumberField("id", value.getId());
//		jgen.writeStringField("timestamp", value.getTimestamp().toString());
//		jgen.writeStringField("name", value.getName());
//		jgen.writeObjec
		
		
	}

}
