package com.andersonbraz.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Event {
	
	PALESTRA(1),
	SHOW(2),
	CONVENCAO(3),
	AMOSTRA(4);
	
	@Getter
	private final Integer code;
	
	private static final List<Event> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	public static Event randomEvent() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
}
