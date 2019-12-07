package org.belldj.mntest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.assertj.core.api.Assertions;
import org.belldj.mntest.web.Transport;
import org.junit.jupiter.api.Test;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.inject.BeanDefinition;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
class TransportTest {

	@Inject
	private ApplicationContext ctx;

	@Test
	public void test() {
		
		Collection<BeanDefinition<?>> allBeanDefinitions = ctx.getAllBeanDefinitions();
		
		List<BeanDefinition<?>> transports = allBeanDefinitions.stream()
			.filter(bd -> bd.findAnnotation(Transport.class).isPresent())
			.collect(Collectors.toList());
		
		transports.forEach(bd -> {
			Optional<AnnotationValue<Introspected>> find= bd.findAnnotation(Introspected.class);
			Assertions.assertThat(find.isPresent()).as("check ").isTrue();
		});
		
	}


}
