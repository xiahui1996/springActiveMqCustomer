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
	
	//String类型的接收
	/*  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
	  @SendTo("SQueue")
	   public String handleMessage(Message message) throws JMSException {
		  TextMessage textMessage =(TextMessage) message;
		  
	        System.out.println("成功接受Name" + textMessage.getText());
	       //手动签收
	       textMessage.acknowledge();
	        return "成功接受Name" + textMessage.getText();
	   }*/
	  
	  
	////Map类型的接收
	  /*@JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
	  @SendTo("SQueue")
	   public String handleMessage(Message message) throws JMSException {
		  MapMessage mapMessage =(MapMessage) message;
		  
	        System.out.println("成功接受Name" + mapMessage.getString("name"));
	        System.out.println("成功接受Name" + mapMessage.getInt("age"));
	       //手动签收
	        mapMessage.acknowledge();
	        return "成功接受Name" +mapMessage.getString("name");
	   }*/
	  
	  
	  //对象类型接收
	  
	////Map类型的接收
	/*	  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
		  @SendTo("SQueue")
		   public String handleMessage(Message message) throws JMSException {
			  ObjectMessage objectmessage =(ObjectMessage) message;
			  
			    User user=(User) objectmessage.getObject();

			    System.out.println("成功接受Name" + user.getName());
		        System.out.println("成功接受Name" + user.getAge());
		       //手动签收
		        objectmessage.acknowledge();
		        return "成功接受Name" +user.getName();
		   }
		  */
		  
		
		  
			////字节流类型的接收
				/*  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
			    @SendTo("SQueue")
				   public String handleMessage(Message message) throws JMSException {
					
					 long begin = System.currentTimeMillis();
					 
					 BytesMessage bytesmessage =(BytesMessage) message;
					  
					  System.out.println("文件有"+bytesmessage.getBodyLength());
					  //1:创建缓存数组
					  byte[] buffer = new byte[(int) bytesmessage.getBodyLength()];
					  try {
					  //将字节消息写入到缓冲数组中
					 bytesmessage.readBytes(buffer);
					//创建输出流
					// FileOutputStream outputStream = new FileOutputStream("E:/photo/test2.jpg");
					 FileOutputStream outputStream = new FileOutputStream("F:/HYLiteResources/video/test2.mp4");
					 
					
					 //将文件输出到本地
					 outputStream.write(buffer);
					 bytesmessage.acknowledge(); 
					 
					 long end = System.currentTimeMillis();
					 
					 long alltime = end-begin;
					 
					 System.out.println("共花费时间"+alltime);
					} catch (Exception e) {
						e.printStackTrace();
					}
					  
				        return "成功接受图片";
				   }*/
				  
			//监听stream流类型
				  
				  @JmsListener(destination = "ActiveMQQueue",containerFactory="JmsListenerContainerFactory")
				  @SendTo("SQueue")
				   public String handleMessage(Message message) throws JMSException {
					  StreamMessage streammessage =(StreamMessage) message;
					  
					

					    System.out.println("成功接受Name" + streammessage.readString());
				        System.out.println("成功接受Name" + streammessage.readInt());
				       //手动签收
				        streammessage.acknowledge();
				        return "成功接受Name";
				   }
				  
				  
				  
				    
}
