package com.open.core.util;

import java.util.ResourceBundle;

/**
 * @Description: 属性文件工具类
 * @author dingzhiwei jmdhappy@126.com
 * @date 2017-07-05
 * @version V1.0
 * @Copyright: www.xxpay.org
 */
public class PropertiesFileUtils {

	private ResourceBundle rb = null;

	public PropertiesFileUtils(String bundleFile) {
		rb = ResourceBundle.getBundle(bundleFile);
	}

	public String getValue(String key) {
		return rb.getString(key);
	}

	public static void main(String[] args) {


	}
}
