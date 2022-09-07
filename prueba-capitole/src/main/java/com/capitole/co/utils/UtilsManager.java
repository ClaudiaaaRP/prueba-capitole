package com.capitole.co.utils;


import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;


public class UtilsManager  {

	/**
	 * Formats the string value received as parameter as a date with the format
	 * received as second parameter
	 * 
	 * @param strDateValue
	 * @param format
	 * @return
	 */
	public static Date getDateFromOffsetDateTime(OffsetDateTime offsetDate) {
		if (isNullOrEmpty(offsetDate)) {
			return null;
		} else {

			long epochMilli = offsetDate.toInstant().toEpochMilli();
			return new Date(epochMilli);
		}
	}

	/**
	 * Converts a Date value to a OffsetDateTime object in UTC timezone
	 * 
	 * @param dateValue: classic java date value
	 * @return: Offset date time calculated at the system default time zone
	 */
	public static OffsetDateTime getUTCOffsetDateTimeFromDate(Date dateValue) {

		if (!isNullOrEmpty(dateValue)) {
			Instant instant = dateValue.toInstant();
			ZonedDateTime zdt = instant.atZone(ZoneOffset.UTC);
			return (zdt.toOffsetDateTime());
		} else {
			return null;
		}
	}
	
	
	/**
	 * Converts a Date value (received as a String) to a OffsetDateTime object in
	 * UTC timezone
	 * 
	 * @param dateValue: classic java date value
	 * @return: Offset date time calculated at the system default time zone
	 */
	public static OffsetDateTime getUTCOffsetDateTimeFromDate(String strDateValue) {
		if (!isNullOrEmpty(strDateValue)) {
			try {
				return OffsetDateTime.parse(strDateValue);
			} catch (DateTimeParseException dtpe) {
				return null;
			}
		}
		return null;
	}


	/**
	 * Checks if a single object is null: - If the object is a String, checks if the
	 * String is null or empty - If the object is a different type, checks if it is
	 * null Note that it does not perform any special checking for lists
	 * 
	 * @param obj: Object to check
	 * @return: True if the object is null; false in other case
	 */
	public static boolean isNullOrEmpty(Object obj) {
		if (obj != null) {
			if (obj instanceof String) {
				return (obj.toString().trim().length() == 0);
			} else if (obj instanceof Map) {
				return (((Map) obj).size() == 0);
			} else if (obj instanceof Collection) {
				return (((Collection) obj).size() == 0);
			} else {
				return (obj == null);
			}
		} else {
			return true;
		}
	}


		
}