package com.pcm.mina.service.handler;

import com.pcm.mina.service.model.IMPackage;
import org.apache.log4j.Logger;
import com.pcm.mina.service.RequestHandler;
import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.session.DefaultSessionManager;
import com.pcm.mina.service.session.PcmSession;
import com.pcm.util.ContextHolder;

import java.util.Collection;

/**
 * @author ZERO
 * @Description  推送消息
 */ 
public class PushMessageHandler implements RequestHandler {

	protected final Logger logger = Logger.getLogger(PushMessageHandler.class);
	public IMPackage process(PcmSession ios, IMPackage sent) {
		IMPackage reply = new IMPackage();
		DefaultSessionManager sessionManager=(DefaultSessionManager) ContextHolder.getBean("PcmSessionManager");
		Collection<PcmSession> sessions=sessionManager.getAllSeesion();
		for (PcmSession session:sessions) {
			if(session !=null){
				sent.remove(Message.SESSION_KEY);
				reply.setKey(sent.getKey());
				reply.setMessage("推送的消息");
				reply.setData(sent.getData());
				reply.setCode(Message.ReturnCode.CODE_200);
				session.write(reply); //转发获取的消息
				logger.info("推送的消息是:"+reply.toString());
			}
		}
		reply=new IMPackage();
		reply.setCode(Message.ReturnCode.CODE_200);
		return reply;
	}
}