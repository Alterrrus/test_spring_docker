package org.fuckingtest.lol.kafkaservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

  private final static Logger LOG = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);
  private final KafkaTemplate<String, String> kafkaTemplate;
  private final ObjectMapper objectMapper;

  public KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
    this.kafkaTemplate = kafkaTemplate;
    this.objectMapper = objectMapper;
  }

  @Override
  public void sendMessage(String message) {
    String r = null;
    try {
      r = objectMapper.writeValueAsString(message);
    } catch (JsonProcessingException e) {
      LOG.error(e.getMessage());
    }
    kafkaTemplate.send("test", r);
  }
}
