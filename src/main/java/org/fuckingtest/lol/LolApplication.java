package org.fuckingtest.lol;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.security.plain.PlainLoginModule;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
@EnableKafka
public class LolApplication {
	@Value("${kafka.url}")
	private String kafkaUrl;
	@Value("${kafka.login}")
	private String kafkaUser;
	@Value("${kafka.password}")
	private String kafkaPassword;
	public static void main(String[] args) {
		SpringApplication.run(LolApplication.class, args);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}
	@Bean
	public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerProps());
	}
	private Map<String, Object> producerProps() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		addConnectionProperties(props);
		return props;
	}
	private void addConnectionProperties(Map<String, Object> props) {
		props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
		if (StringUtils.hasText(kafkaUser)) {
			props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
			props.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
			props.put(SaslConfigs.SASL_JAAS_CONFIG, PlainLoginModule.class.getName() + " required username=\"" + kafkaUser + "\" password=\"" + kafkaPassword + "\";");
		}
	}
}
