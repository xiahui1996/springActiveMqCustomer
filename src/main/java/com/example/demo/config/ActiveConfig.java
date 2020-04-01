package com.example.demo.config;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
public class ActiveConfig {

	
	@Bean("JmsListenerContainerFactory")
	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(ConnectionFactory connectionFactory){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		//设置连接
		factory.setConnectionFactory(connectionFactory);
		//关闭事务
		factory.setSessionTransacted(false);
		//修改事务模式
		//1:自动模式
		//factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
		
		//手动确定
		factory.setSessionAcknowledgeMode(4);
		
		
		return factory;
	}
	
}
