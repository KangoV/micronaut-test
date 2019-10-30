package org.belldj.mntest.builds;

import java.util.List;

import javax.inject.Inject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class BuildsControllerTest {

	@Client(value = "/builds")
	interface BuildsClient {
	    @Get(value = "/")
	    List<RegisterBuildCommandInT> findAll();
	}
	
	@Inject
	private BuildsClient client;
	
	@Test
	void testFindAll() {
		List<RegisterBuildCommandInT> user = client.findAll();
	    Assertions.assertThat(user).isNotNull();	
	}

}
