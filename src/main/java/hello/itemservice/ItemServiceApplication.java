package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import hello.itemservice.config.QuerydslConfig;
import hello.itemservice.repository.ItemRepository;


// @Import(MemoryConfig.class)
// @Import(JdbcTemplateV1Config.class)
// @Import(JdbcTemplateV2Config.class)
// @Import(JdbcTemplateV3Config.class)
// @Import(MyBatisConfig.class)
// @Import(JpaConfig.class)
// @Import(SpringDataJpaConfig.class)
@Import(QuerydslConfig.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

}
