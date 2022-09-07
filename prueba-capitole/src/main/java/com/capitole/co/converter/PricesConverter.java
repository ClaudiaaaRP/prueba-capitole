package com.capitole.co.converter;

import java.time.OffsetDateTime;


import org.springframework.stereotype.Service;
import com.capitole.co.persistence.Prices;
import com.capitole.co.persistence.PricesDto;


@Service
public class PricesConverter {
	public PricesDto convertToDto(Prices prices, OffsetDateTime date) {
		PricesDto pricesDto = new PricesDto();
		pricesDto.setBrandId(prices.getId().getBrandId());
		pricesDto.setPrice(prices.getPrice());
		pricesDto.setProductId(prices.getId().getProductId());
		pricesDto.setPriceList(prices.getPriceList());
		pricesDto.setDate(date);
		return pricesDto;

	}
}