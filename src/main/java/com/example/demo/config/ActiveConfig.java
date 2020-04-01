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
		//��������
		factory.setConnectionFactory(connectionFactory);
		//�ر�����
		factory.setSessionTransacted(false);
		//�޸�����ģʽ
		//1:�Զ�ģʽ
		//factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
		
		//�ֶ�ȷ��
		factory.setSessionAcknowledgeMode(4);
		
		
		return factory;
	}
	
}
