package com.dean.demo.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/16 13:48
 *
 * 判断javaBean属性是否为空或"";
 */
public class LocalObjectUtils {
	//TODO 待完善
	private static final Logger logger = LoggerFactory.getLogger(LocalObjectUtils.class);
	/**
	 * 判断类中每个属性是否都为空
	 *
	 * @param obj javaBean
	 * @return bool
	 */
	public static boolean allFieldIsNull(Object obj) {
		try {
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);

				Object object = field.get(obj);

			}
		} catch (Exception e) {
			logger.error("判断对象属性为空异常", e);

		}
		return true;
	}
}