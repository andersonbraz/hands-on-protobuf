package com.andersonbraz.main;


import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.andersonbraz.model.Event;
import com.andersonbraz.model.protobuf.TicketProto.TicketMessage;
import com.andersonbraz.utils.RandomDateUtils;

import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;

public class ProtoProducer {
	
	private static final Random RANDOM = new Random(System.currentTimeMillis());
	private static final String KAFKA_TOPIC = "TESTE-TOPICO-PROTO";

	public static void main(String[] args) {
		
		for(int i = 0; i <= 999; i++) {

			
			TicketMessage ticket = TicketMessage.newBuilder()
					.setId(Math.abs(RANDOM.nextLong()))
					.setCode(UUID.randomUUID().toString())
				    .setName(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase())
					.setEvent(Event.randomEvent().toString())
					.setDiscount(RANDOM.nextBoolean())
					.setDate(RandomDateUtils.randomFutureDate().toString())
					.build();
	
			KafkaProducer<String, TicketMessage> producer = new KafkaProducer<>(getProperties());
			ProducerRecord<String, TicketMessage> record = new ProducerRecord<>(KAFKA_TOPIC, ticket);
	
			producer.send(record);
			producer.close();
		}

	}
	
	private static Properties getProperties() {

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class.getName());
		properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");
		
		return properties;

	}

}
