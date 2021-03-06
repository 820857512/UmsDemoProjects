package com.whackon.ums.controller;

import com.whackon.ums.base.controller.BaseController;
import com.whackon.ums.base.pojo.vo.Page;
import com.whackon.ums.base.pojo.vo.ResponseVO;
import com.whackon.ums.pojo.entity.User;
import com.whackon.ums.transport.UserTransport;
import com.whackon.ums.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>用户信息控制器</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@RestController("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>用户登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseVO loginUser(String cellphone, String password) throws Exception {
		// 校验用户登录提交信息
		if (ValidateUtil.checkCellphone(cellphone) && ValidateUtil.checkPassword(password)) {
			// 用户登录信息有效，使用手机号码查询用户信息
			String token = userTransport.loginUser(cellphone, password);
			if (token != null) {
				// 将 token 返回到前端页面
				return ResponseVO.success(token);
			}
		}
		return ResponseVO.error("请填写正确的登录信息");
	}

	/**
	 * <b>分页查询列表</b>
	 * @param pageNum
	 * @param pageSize
	 * @param draw
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	public ResponseVO queryUserForPage(Integer pageNum, Integer pageSize, Integer draw) throws Exception {
		// 封装分页视图对象 Page
		Page<User> page = new Page<User>(pageNum, pageSize, draw);
		// 使用分页视图对象查询 Page 对象
		page = userTransport.getUserForPage(page);
		// 使用 Page 创建返回视图对象
		return ResponseVO.success(page);
	}
}
