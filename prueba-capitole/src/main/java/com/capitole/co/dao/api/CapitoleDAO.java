package com.capitole.co.dao.api;

import java.time.OffsetDateTime;
import java.util.List;

import com.capitole.co.persistence.PricesDto;

public interface CapitoleDAO {
	public PricesDto getCurrentPricebyParameters(Integer productId, Integer brandId, String date);
}
