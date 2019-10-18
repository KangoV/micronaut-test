package org.belldj;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
            title = "test",
            version = "0.0"
    )
)
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
    
    private final BuildsDao buildsDao;
    
    public Application(BuildsDao buildsDao) {
		this.buildsDao = buildsDao;
	}
    
    @EventListener
    @Transactional
    void init(StartupEvent event) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Populating data");
        }
        var b = new BuildE();
        b.setId(1);
        b.setName("shuffle-bots");
        buildsDao.save(b);
    }
    
}