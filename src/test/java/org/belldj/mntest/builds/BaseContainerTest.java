package org.belldj.mntest.builds;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;

@Testcontainers
@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseContainerTest implements TestPropertyProvider {

  @Container
  private static final PostgreSQLContainer<?> container =
      new PostgreSQLContainer<>("postgres:10-alpine")
          .withDatabaseName("test")
          .withUsername("test")
          .withPassword("");

  @Inject
  public Flyway flyway;

  @AfterEach
  public void afterEach() {
    flyway.clean();
  }

  @BeforeEach
  public void beforeEach() {
    flyway.migrate();
  }

  @Override
  public Map<String, String> getProperties() {
    System.out.println("### properties retieved");
    HashMap<String, String> map = new HashMap<>();
    map.put("datasources.default.dialect", "POSTGRES");
    map.put("datasources.default.url", container.getJdbcUrl());
    map.put("datasources.default.driverClassName", container.getDriverClassName());
    map.put("datasources.default.username", container.getUsername());
    map.put("datasources.default.password", container.getPassword());
    return map;
  }


}
