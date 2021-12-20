package com.andersonbraz.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Ticket {
	
	Integer id;
	Event event;
	String name;
	Date date;
	String code;
	Double price;
	Boolean discount;

}
