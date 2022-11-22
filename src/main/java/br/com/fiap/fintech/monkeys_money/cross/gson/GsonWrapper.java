package br.com.fiap.fintech.monkeys_money.cross.gson;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonWrapper {
	
	public GsonWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public Gson of() {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
    	gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
    	gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
    	gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
    	gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

    	return gsonBuilder.setPrettyPrinting().create();
    	
	}

}
