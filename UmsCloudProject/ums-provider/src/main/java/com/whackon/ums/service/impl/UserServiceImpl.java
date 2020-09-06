package com.whackon.ums.service.impl;

import cn.ekgc.ums.util.RedisUtil;
import com.whackon.ums.dao.UserDao;
import com.whackon.ums.pojo.entity.User;
import com.whackon.ums.service.UserService;
import com.whackon.ums.util.MD5Util;
import com.whackon.ums.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户信息业务持久层接口实现类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>使用手机号码和密码登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Override
	public String loginUser(String cellphone, String password) throws Exception {
		// 通过手机号码查询用户信息
		User query = new User();
		query.setCellphone(cellphone);
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && userList.size() > 0) {
			User user = userList.get(0);
			password = MD5Util.encrypt(password);
			if (password.equals(user.getPassword())) {
				// 生成 token
				String token = TokenUtil.createToken(user.getId());
				// 存储 token
				redisUtil.saveValue(token, user);
				return token;
			}
		}
		return null;
	}
}
