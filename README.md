# multiProducerConsumer


Spring Stream Application with Kafka Binders.

The application hosts multipe Producer and Consumers to communicate with Kafka topics .
The solution is a alternative for Mainframe workflow , hence leading to high throughput and low latency.


To build jar file : mvn clean install -X


Spring Cloud Stream is a framework for building message-driven microservice applications. Spring Cloud Stream builds upon Spring Boot to create standalone, production-grade Spring applications, and uses Spring Integration to provide connectivity to message brokers. It provides opinionated configuration of middleware from several vendors, introducing the concepts of persistent publish-subscribe semantics, consumer groups, and partitions.



The @EnableBinding annotation takes one or more interfaces as parameters (in this case, the parameter is a single Sink interface). An interface declares input and/or output channels. Spring Cloud Stream provides the interfaces Source, Sink, and Processor; you can also define your own interfaces.


The @Input annotation identifies an input channel, through which received messages enter the application; the @Output annotation identifies an output channel, through which published messages leave the application. The @Input and @Output annotations can take a channel name as a parameter; if a name is not provided

The @StreamListener annotation is modeled after other Spring Messaging annotations (such as @MessageMapping, @JmsListener, @RabbitListener, etc.) 


