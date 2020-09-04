package com.whackon.ums.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>基础控制器</b>
 * <p>
 *     基础控制器依赖注入了 <b>HttpServletRequest</b>、<b>HttpServletResponse</b> 和 <b>HttpSession</b></br>
 *     其他模块功能控制器必须继承于本基础控制器
 * </p>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@Controller("baseController")
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
}
