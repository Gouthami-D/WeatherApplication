package com.A.amqq.controller;

import javax.management.JMException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.web.bind.annotation.RestController;

import com.A.amqq.Repository.WeatherHistoryRepository;
import com.A.amqq.entity.Weather;
import com.A.amqq.entity.WeatherHistory;

@RestController
public class ConsumerController {
	
	@Autowired
	private WeatherHistoryRepository historyRepository;
	
	@JmsListener(destination = "WeatherQueue")
	public void WeatherConsumer(Weather message) throws MessageConversionException,JMException{
		//Logger logger =Logger.getLogger("CONSUMER");
		//logger.log(Level.INFO,"Invoking Consumer");
		Weather weather = message;
		WeatherHistory history = new WeatherHistory();
		history.setLocation(weather.getLocation().getName());
		history.setTemp_f(weather.getCurrent().getTemp_f());
		history.setFeelslike_f(weather.getCurrent().getFeelslike_f());
		historyRepository.save(history);
	}
	}
	
	
	


