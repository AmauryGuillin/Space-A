package fr.isika.cda.spring;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class AppCollectionUtils {

	public static final <T> List<T> asList(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}
	
	private AppCollectionUtils() {
	}
	
}
