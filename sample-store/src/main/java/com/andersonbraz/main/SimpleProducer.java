package com.andersonbraz.main;

import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.andersonbraz.model.Event;
import com.andersonbraz.model.Ticket;
import com.andersonbraz.utils.RandomDateUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SimpleProducer {

	private static final Random RANDOM = new Random(System.currentTimeMillis());
	private static final String KAFKA_TOPIC = "TESTE-TOPICO-COMUM";

	public static void main(String[] args) {

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		for(int i = 0; i <= 999; i++) {
			
			Ticket ticket = Ticket.builder() 
	                .id(Math.abs(RANDOM.nextInt()))
	                .code(UUID.randomUUID().toString())
	                .name(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase())	                
	                .event(Event.randomEvent())
	                .discount(RANDOM.nextBoolean())
	                .date(RandomDateUtils.randomFutureDate())
	                .build();
			
			final String values = gson.toJson(ticket).toString();
	
			KafkaProducer<String, String> producer = new KafkaProducer<>(getProperties());
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(KAFKA_TOPIC, values);
			
			producer.send(record);
			producer.close();
		}	

	}

	private static Properties getProperties() {

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		return properties;

	}

}
