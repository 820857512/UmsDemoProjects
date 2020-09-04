package com.whackon.ums.util;

/**
 * <b>系统校验工具类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class ValidateUtil {
	private static String cellphoneRegex = "1[0-9]{10}";

	/**
	 * <b>使用正则表达式校验手机号码格式是否正确</b>
	 * @param cellphone
	 * @return
	 */
	public static boolean checkCellphone(String cellphone) {
		if (cellphone != null && !"".equals(cellphone.trim())) {
			return cellphone.matches(cellphoneRegex);
		}
		return false;
	}

	/**
	 * <b>校验密码长度信息有效性</b>
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {
		if (password != null && password.trim().length() > 4) {
			return true;
		}
		return false;
	}
}
