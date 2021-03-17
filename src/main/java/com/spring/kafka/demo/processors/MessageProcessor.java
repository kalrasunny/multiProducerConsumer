package com.spring.kafka.demo.processors;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageProcessor {
	
	String PRODUCER_ONE = "PRODUCER_ONE";
	String PRODUCER_TWO = "PRODUCER_TWO";
	String PRODUCER_ERROR = "PRODUCER_ERROR";
	String CONSUMER_ONE = "CONSUMER_ONE";
	String CONSUMER_TWO = "CONSUMER_TWO";
	String CONSUMER_ERROR = "CONSUMER_ERROR";

	  	@Input(CONSUMER_ONE)
	    SubscribableChannel consumerOne();
	  
	  	@Input(CONSUMER_TWO)
	    SubscribableChannel consumerTwo();
	  	
	  	@Input(CONSUMER_ERROR)
	    SubscribableChannel consumerError();

	    @Output(PRODUCER_ONE)
	    MessageChannel producerOne();

	    @Output(PRODUCER_TWO)
	    MessageChannel producerTwo();
	    
	    @Output(PRODUCER_ERROR)
	    MessageChannel producerError();
}
