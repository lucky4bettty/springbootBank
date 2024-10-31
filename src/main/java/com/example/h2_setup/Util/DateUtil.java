package com.example.h2_setup.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {
	
	/**
	 * 取得目前的日期時間 - 字串
	 */
	public static String getNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
		return formattedDate;
	}

}
