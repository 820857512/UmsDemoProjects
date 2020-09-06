package com.whackon.ums.transport;

import com.whackon.ums.base.pojo.vo.Page;
import com.whackon.ums.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ums-provider")
@RequestMapping("/tran/user")
public interface UserTransport {
	/**
	 * <b>使用手机号码和密码登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	String loginUser(@RequestParam String cellphone, @RequestParam String password) throws Exception;

	/**
	 * <b>获得分页对象</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	Page<User> getUserForPage(@RequestBody Page<User> page) throws Exception;
}
