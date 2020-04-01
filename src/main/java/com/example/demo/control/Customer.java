package com.example.demo.control;

import java.io.FileOutputStream;
import java.util.Date;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class Customer {

	 /*@Autowired
	 private JmsMessagingTemplate jmsMessagingTemplate;*/
	
	//String���͵Ľ���
	/*  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
	  @SendTo("SQueue")
	   public String handleMessage(Message message) throws JMSException {
		  TextMessage textMessage =(TextMessage) message;
		  
	        System.out.println("�ɹ�����Name" + textMessage.getText());
	       //�ֶ�ǩ��
	       textMessage.acknowledge();
	        return "�ɹ�����Name" + textMessage.getText();
	   }*/
	  
	  
	////Map���͵Ľ���
	  /*@JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
	  @SendTo("SQueue")
	   public String handleMessage(Message message) throws JMSException {
		  MapMessage mapMessage =(MapMessage) message;
		  
	        System.out.println("�ɹ�����Name" + mapMessage.getString("name"));
	        System.out.println("�ɹ�����Name" + mapMessage.getInt("age"));
	       //�ֶ�ǩ��
	        mapMessage.acknowledge();
	        return "�ɹ�����Name" +mapMessage.getString("name");
	   }*/
	  
	  
	  //�������ͽ���
	  
	////Map���͵Ľ���
	/*	  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
		  @SendTo("SQueue")
		   public String handleMessage(Message message) throws JMSException {
			  ObjectMessage objectmessage =(ObjectMessage) message;
			  
			    User user=(User) objectmessage.getObject();

			    System.out.println("�ɹ�����Name" + user.getName());
		        System.out.println("�ɹ�����Name" + user.getAge());
		       //�ֶ�ǩ��
		        objectmessage.acknowledge();
		        return "�ɹ�����Name" +user.getName();
		   }
		  */
		  
		
		  
			////�ֽ������͵Ľ���
				/*  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
			    @SendTo("SQueue")
				   public String handleMessage(Message message) throws JMSException {
					
					 long begin = System.currentTimeMillis();
					 
					 BytesMessage bytesmessage =(BytesMessage) message;
					  
					  System.out.println("�ļ���"+bytesmessage.getBodyLength());
					  //1:������������
					  byte[] buffer = new byte[(int) bytesmessage.getBodyLength()];
					  try {
					  //���ֽ���Ϣд�뵽����������
					 bytesmessage.readBytes(buffer);
					//���������
					// FileOutputStream outputStream = new FileOutputStream("E:/photo/test2.jpg");
					 FileOutputStream outputStream = new FileOutputStream("F:/HYLiteResources/video/test2.mp4");
					 
					
					 //���ļ����������
					 outputStream.write(buffer);
					 bytesmessage.acknowledge(); 
					 
					 long end = System.currentTimeMillis();
					 
					 long alltime = end-begin;
					 
					 System.out.println("������ʱ��"+alltime);
					} catch (Exception e) {
						e.printStackTrace();
					}
					  
				        return "�ɹ�����ͼƬ";
				   }*/
				  
			//����stream������
				  
				  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
				  @SendTo("SQueue")
				   public String handleMessage(Message message) throws JMSException {
					  StreamMessage streammessage =(StreamMessage) message;
					  
					

					    System.out.println("�ɹ�����Name" + streammessage.readString());
				        System.out.println("�ɹ�����Name" + streammessage.readInt());
				       //�ֶ�ǩ��
				        streammessage.acknowledge();
				        return "�ɹ�����Name";
				   }
				  
				  
				  
				    
}
