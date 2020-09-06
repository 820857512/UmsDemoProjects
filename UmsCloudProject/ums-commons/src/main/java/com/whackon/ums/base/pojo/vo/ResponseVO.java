package com.whackon.ums.base.pojo.vo;

import com.whackon.ums.base.pojo.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * <b>系统响应视图信息</b>
 * <p>
 *     后端响应前端对象都必须封装为本对象
 * </p>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = -2839720480166797093L;
	private Integer code;                       // 响应编码
	private boolean result;                     // 系统处理结果
	private E data;                             // 响应信息

	public ResponseVO(ResponseCodeEnum responseCodeEnum, boolean result) {
		this.code = responseCodeEnum.getCode();
		this.result = result;
	}
	public ResponseVO(ResponseCodeEnum responseCodeEnum, boolean result, E data) {
		this.code = responseCodeEnum.getCode();
		this.result = result;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得系统响应处理成功视图对象</b>
	 * @return
	 */
	public static ResponseVO success() {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, true);
	}

	/**
	 * <b>获得系统响应处理成功视图对象</b>
	 * @return
	 */
	public static ResponseVO success(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, true, data);
	}

	/**
	 * <b>获得系统响应处理失败视图对象</b>
	 * @return
	 */
	public static ResponseVO error(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, false, data);
	}

	/**
	 * <b>获得系统响应失败视图对象</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO failure(Object data) {
		return new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_500, false, data);
	}
}
