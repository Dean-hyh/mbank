<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:context="http://www.springframework.org/schema/context" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:amq="http://activemq.apache.org/schema/core"
	xmlns:jms="http://www.springframework.org/schema/jms"
	xsi:schemaLocation="http://www.springframework.org/schema/beans   
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context   
		http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/jms
		http://www.springframework.org/schema/jms/spring-jms.xsd">

	<context:component-scan base-package="com.ms.credit.service"/>

    <!-- 真正可以产生Connection的ConnectionFactory，由对应的 JMS服务厂商提供-->
	<bean id="targetConnectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
	    <property name="brokerURL" value="tcp://127.0.0.1:61616"/>
	</bean>
    <!-- Spring用于管理真正的ConnectionFactory的ConnectionFactory -->  
	<bean id="connectionFactory" class="org.springframework.jms.connection.SingleConnectionFactory">  
	<!-- 目标ConnectionFactory对应真实的可以产生JMS Connection的ConnectionFactory -->  
	    <property name="targetConnectionFactory" ref="targetConnectionFactory"/>  
	</bean>  

    <!--这个是队列目的地，点对点的文本信息-->
	<bean id="queueText" class="org.apache.activemq.command.ActiveMQQueue">
		<!--消息在队列中的名字，即消息的目的地-->
		<constructor-arg value="announceEmail_queue"/>
	</bean>

	<!-- Spring提供的JMS工具类，它可以进行消息发送等 -->
	<bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
		<!-- 这个connectionFactory对应的是我们定义的Spring提供的那个ConnectionFactory对象 -->
		<property name="connectionFactory" ref="connectionFactory"/>
	</bean>

</beans>
