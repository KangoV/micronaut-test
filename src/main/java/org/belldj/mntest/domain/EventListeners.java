package org.belldj.mntest.domain;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import org.belldj.mntest.part.domain.PartCreatedEventSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.runtime.event.annotation.EventListener;

@Singleton
public class EventListeners {

  private static final Logger log = LoggerFactory.getLogger(EventListeners.class);

	@Transactional
	@EventListener
	public void onPartCreated(PartCreatedEventSpec event) {

		/*
		 * 1. lookup component via name 2. if not found then add it 3. create a new
		 * version of the component 4. the components commit token will be the build id
		 * (time uuid)
		 */

		log.info("Build \"{}\" created", event.getPart().getId());

	}

}
