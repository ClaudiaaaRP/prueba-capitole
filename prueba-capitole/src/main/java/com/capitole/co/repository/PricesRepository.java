package com.capitole.co.repository;

import java.time.OffsetDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capitole.co.persistence.Prices;
import com.capitole.co.persistence.PricesPK;;

public interface PricesRepository extends JpaRepository<Prices, PricesPK> {

	@Query (value ="SELECT p.* FROM PRICES p \r\n" + 
			"WHERE p.BRAND_ID = ?2 AND p.PRODUCT_ID = ?1 and  p.start_date < ?3 and p.end_date > ?3\r\n" + 
			"AND p.PRIORITY = (SELECT MAX(p2.PRIORITY) FROM PRICES p2 WHERE  p2.BRAND_ID = ?2 AND p2.PRODUCT_ID = ?1 \r\n"
			+ "and p2.start_date < ?3 and p2.end_date > ?3)", nativeQuery = true)
	public Prices findCurrentPricebyParameters(Integer productId, Integer brandId, OffsetDateTime date);

}
