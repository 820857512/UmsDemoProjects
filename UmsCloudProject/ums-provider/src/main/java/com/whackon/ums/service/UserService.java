package com.whackon.ums.service;

/**
 * <b>用户信息业务持久层接口</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public interface UserService {
	/**
	 * <b>使用手机号码和密码登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	String loginUser(String cellphone, String password) throws Exception;
}
