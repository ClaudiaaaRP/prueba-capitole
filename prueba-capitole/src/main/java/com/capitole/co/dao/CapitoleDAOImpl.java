package com.capitole.co.dao;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.co.converter.PricesConverter;
import com.capitole.co.dao.api.CapitoleDAO;
import com.capitole.co.persistence.Prices;
import com.capitole.co.persistence.PricesDto;
import com.capitole.co.repository.PricesRepository;
import com.capitole.co.utils.UtilsManager;

@Service
public class CapitoleDAOImpl implements CapitoleDAO {

	@Autowired
	private PricesRepository pricesRepository;

	@Autowired
	private PricesConverter pricesConverter;

	/**
	 * Obtains information on the prices that apply to a product and a brand at a given time.
	 * @param productId, brandId, and specific time
	 * @return: Information on the prices to apply
	 */
	@Override
	public PricesDto getCurrentPricebyParameters(Integer productId, Integer brandId, String date) {
		PricesDto pricesDto = new PricesDto();

		OffsetDateTime dateTime = UtilsManager.getUTCOffsetDateTimeFromDate(date);
		System.out.println("Petición a las " + dateTime.getHour() + ":" + dateTime.getMinute() + " del día "
				+ dateTime.getDayOfMonth() + " del producto " + productId + " para la brand " + brandId);

		Prices price = pricesRepository.findCurrentPricebyParameters(productId, brandId, dateTime);

		if (!UtilsManager.isNullOrEmpty(price)) {
			pricesDto = pricesConverter.convertToDto(price, dateTime);
		}

		return pricesDto;
	}

}
