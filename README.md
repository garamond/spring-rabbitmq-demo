# Spring Integration over RabbitMQ demo

This simple application is a demonstration of running Spring Integration communication over RabbitMQ with minimal XML configuration.

Features:

 * The configuration of Spring Integration is isolated and done with JavaConfig annotations (inside the `IntegrationTestConfig` class)
 * XML configuration is limited to the basic "plumbing": channel definitions, Spring AMQP and RabbitMQ (in `rabbitmq-config.xml`)

## Getting started

Requirements:

 * Maven 3 stack
 * Running RabbitMQ service on localhost

To verify the result, run:

	mvn test
	
## Explanation

This is what happens in the `IntegrationTest` test:

An instance of `TestEntity` gets passed to the interface method `TestService#process` (proxied by Spring), pushed through the Spring Integration plumbing over the Spring AMQP adapters onto RabbitMQ; from there it passes up the same stack to a "service activator" bean. An output value is determined and sent back through the same mechanism; it pops out of the proxied interface and gets compared to the input.

	TestEntity 
	--> TestService#process 
	 <--> Spring Integration gateway
	  <--> AQMP adapter
 	   <--> RabbitMQ
  	    <--> AQMP adapter
	     <--> Spring Integration service activator
	      <--> TestServiceImpl#process

## Notes

 * Defaults are used whenever possible.
 * Read the comments.