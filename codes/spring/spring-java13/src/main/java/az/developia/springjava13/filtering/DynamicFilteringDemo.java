package az.developia.springjava13.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class DynamicFilteringDemo {
	public MappingJacksonValue filter(String dto, Object data, String... properties) {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(dto, filter);

		MappingJacksonValue result = new MappingJacksonValue(data);

		result.setFilters(filterProvider);

		return result;
	}
}