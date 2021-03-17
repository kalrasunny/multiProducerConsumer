package com.spring.kafka.demo.multiProducerConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import com.spring.kafka.demo.processors.MessageProcessor;

@EnableBinding(MessageProcessor.class)
@SpringBootApplication
public class MultiProducerConsumerApplication {


	
	private MessageProcessor processor;

	public static void main(String[] args) {
		SpringApplication.run(MultiProducerConsumerApplication.class, args);
	}
	
	@StreamListener(MessageProcessor.CONSUMER_ONE)
	public void consumeTopicOne(String val) {
	    if (val.contains("ONE")) {
	        processor.producerOne().send(MessageBuilder
	                .withPayload("Message to topic 2 from producer of consumer one")
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	    } else {
	        processor.producerError().send(MessageBuilder
	                .withPayload("Error message to error topic from producer of consumer one")
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	    }
	}
	
	@StreamListener(MessageProcessor.CONSUMER_TWO)
	public void consumeTopicTwo(String val) {
		if (val.contains("TWO")) {
	        processor.producerTwo().send(MessageBuilder
	                .withPayload("Message to topic 3 from producer of consumer two")
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	    } else {
	        processor.producerError().send(MessageBuilder
	                .withPayload("Error message to error topic from producer of consumer two")
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	    }
	}
	
	@StreamListener(MessageProcessor.CONSUMER_ERROR)
	public void consumeTopicError(String val) {
		
		
		System.out.println("Received Error message -->"+val);
	}

}
