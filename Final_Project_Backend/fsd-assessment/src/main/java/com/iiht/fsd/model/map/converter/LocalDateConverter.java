package com.iiht.fsd.model.map.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

/**
 * 
 * @author Syed Yusuf
 * @version 1.0
 */
public class LocalDateConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(MappingContext<String, LocalDate> context) {

		String srcDate = context.getSource();
		if (StringUtils.isNotBlank(srcDate)) {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			return LocalDate.parse(srcDate, df);
		}

		return null;
	}

}
