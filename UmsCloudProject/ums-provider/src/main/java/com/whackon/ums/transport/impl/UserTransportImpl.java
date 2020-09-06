package com.whackon.ums.transport.impl;

import com.whackon.ums.base.pojo.vo.Page;
import com.whackon.ums.pojo.entity.User;
import com.whackon.ums.service.UserService;
import com.whackon.ums.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>用户信息传输层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("userTransport")
@RequestMapping("/tran/user")
public class UserTransportImpl implements UserTransport {
	@Autowired
	private UserService userService;

	/**
	 * <b>使用手机号码和密码登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public String loginUser(@RequestParam String cellphone, @RequestParam String password) throws Exception {
		return userService.loginUser(cellphone, password);
	}

	/**
	 * <b>获得分页对象</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public Page<User> getUserForPage(Page<User> page) throws Exception {
		return userService.getUserForPage(page);
	}
}
