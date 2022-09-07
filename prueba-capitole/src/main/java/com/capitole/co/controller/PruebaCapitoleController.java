package com.capitole.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.co.dao.CapitoleDAOImpl;
import com.capitole.co.persistence.PricesDto;
import com.capitole.co.utils.UtilsManager;


@RestController
public class PruebaCapitoleController {

	@Autowired
	private CapitoleDAOImpl capitoleDAOImpl;


	@RequestMapping(value = "/capitole/getCurrentPricebyParameters/{productId}/{brandId}/{date}", method = RequestMethod.GET)
	public ResponseEntity<PricesDto> getCurrentPricebyParameters(@PathVariable(required = true) Integer productId, @PathVariable(required = true) Integer brandId, @PathVariable(required = true) String date) {
		if (!UtilsManager.isNullOrEmpty(date) && !UtilsManager.isNullOrEmpty(productId)
				&& !UtilsManager.isNullOrEmpty(brandId)) {
	
			PricesDto prices = capitoleDAOImpl.getCurrentPricebyParameters(productId, brandId, date);
			return new ResponseEntity<PricesDto>(prices, HttpStatus.OK);
		} else {
			return new ResponseEntity<PricesDto>(HttpStatus.BAD_REQUEST);
		}
	}

}
