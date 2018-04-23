package com.tuyue.duanxin.common;

import java.net.URLEncoder;

public class IndustrySMS {
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "13403605189";
	private static String smsContent = "【秒嘀科技】您的验证码是345678，30分钟输入有效。";

	/**
	 * 验证码通知短信
	 */
	public static void execute() {
	//	String tmpSmsContent = null;
//		try {
//			tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
//		} catch (Exception e) {
//
//		}
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}

	public static void main(String[] args) {
		IndustrySMS.execute();
	}
}