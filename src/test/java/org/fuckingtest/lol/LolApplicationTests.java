package org.fuckingtest.lol;

import org.fuckingtest.lol.util.LolService;
import org.fuckingtest.lol.util.ServiceUtil;
import org.fuckingtest.lol.util.ServiceUtil2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class LolApplicationTests {
@Bean
	public LolService getServiceUtil(){
		return new ServiceUtil();
	}
	@Bean
	public LolService getServiceUtil2(){
		return new ServiceUtil2();
	}
	@Test
	void contextLoads() {
	}

}
