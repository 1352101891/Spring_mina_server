package com.pcm.mina.service.model;

/**
 * @author ZERO
 * @Description 消息常量
 */
public class Message {
	public static class ReturnCode {

		public static String CODE_404 = "404"; 

		public static String CODE_403 = "403";  //该账号未绑定

		public static String CODE_405 = "405"; //事物未定义
        
		public static String CODE_200 = "200"; //成功

		public static String CODE_201 = "201"; //消息转给目标成功
		public static String CODE_202 = "202"; //目标不在线

		public static String CODE_500 = "500"; //未知错误

	}

	public static final String SESSION_KEY = "account";
	public static final String SENDER = "sender";
	public static final String RECEIVER = "receiver";
	public static final String MESSAGE = "message";

	public static final String BIND_TYPE = "client_bind";
	public static final String CLOSE_TYPE = "client_close";
	public static final String PUSH_TYPE = "client_push";
	public static final String CHAT_TYPE = "client_message";
    public static final String CHAT_CONFLICT = "client_conflict";

	/**
	 * 服务端心跳请求命令
	 */
	public static final String CMD_HEARTBEAT_REQUEST = "hb_request";
	/**
	 * 客户端心跳响应命令
	 */
	public static final String CMD_HEARTBEAT_RESPONSE = "hb_response";


	public static class MessageType {
		// 用户会 踢出下线消息类型
		public static String TYPE_999 = "999";

	}

}
