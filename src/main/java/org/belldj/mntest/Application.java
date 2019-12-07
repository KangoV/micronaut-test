package org.belldj.mntest;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(
    title = "Micronaut Test Apoplication",
    description = "A small (real world) application for testing as many features as possible",
    version = "0.0",
    license = @License(
        name = "Apache 2.0",
        url = "https://www.apache.org/licenses/LICENSE-2.0"),
    contact = @Contact(
        url = "https://github.com/KangoV/micronaut-test",
        name = "darren",
        email = "djb.bell@gmail.com")))
public class Application {

  private static final Logger LOG = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    Micronaut.run(Application.class);
  }

  @EventListener
  @Transactional
  void init(StartupEvent event) {
	  LOG.info("Init processed");
  }

}
