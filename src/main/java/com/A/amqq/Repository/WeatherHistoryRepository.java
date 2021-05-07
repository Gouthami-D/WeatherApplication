package com.A.amqq.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.A.amqq.entity.WeatherHistory;

@Repository
public interface WeatherHistoryRepository  extends JpaRepository<WeatherHistory, Integer>{

}
