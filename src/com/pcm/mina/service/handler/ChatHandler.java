package com.pcm.mina.service.handler;

import com.pcm.mina.service.RequestHandler;
import com.pcm.mina.service.model.IMPackage;
import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.session.DefaultSessionManager;
import com.pcm.mina.service.session.PcmSession;
import com.pcm.util.ContextHolder;
import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.util.UUID;

/**
 * @author ZERO
 * @Description  账号绑定实现
 */ 
public class ChatHandler implements RequestHandler {
	protected final Logger logger = Logger.getLogger(ChatHandler.class);
	public IMPackage process(PcmSession senderSession, IMPackage message) {
		logger.info("ChatHandler");
		IMPackage reply = new IMPackage();
		DefaultSessionManager sessionManager= ((DefaultSessionManager) ContextHolder.getBean("PcmSessionManager"));
		try { 
			String account = message.get(Message.RECEIVER);

			PcmSession receiverSession=sessionManager.getSession(account);
			//如果接收者在线，那么发送消息给接收者
			if(receiverSession!=null)
			{	message.setCode(Message.ReturnCode.CODE_200);
				message.setTimestamp(System.currentTimeMillis());
				receiverSession.write(message);//给目标 发送消息

				reply.setCode(Message.ReturnCode.CODE_201);
			}else {
				reply.setCode(Message.ReturnCode.CODE_202);
			}
		} catch (Exception e) {
			reply.setCode(Message.ReturnCode.CODE_500);
			e.printStackTrace();
		}
		reply.setTimestamp(System.currentTimeMillis());
		return reply;
	}
	
}