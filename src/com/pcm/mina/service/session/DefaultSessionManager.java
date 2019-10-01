package com.pcm.mina.service.session;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import com.pcm.mina.service.model.Message;
import org.apache.mina.core.session.IoSession;

/**
 * @author ZERO
 * @Description  自带默认 session管理实现
 */
public class DefaultSessionManager implements SessionManager{

	 private static ConcurrentHashMap<String,PcmSession> sessions =new  ConcurrentHashMap<String,PcmSession>();
	 private static final AtomicInteger connectionsCounter = new AtomicInteger(0);

	public void addSession(String account, PcmSession session) {
		if(session !=null){
			sessions.put(account, session);
			connectionsCounter.incrementAndGet();
		}
	}
	
	public PcmSession getSession(String account) {
		return sessions.get(account);
	}

	public void removeSession(PcmSession session) {
		sessions.remove(session.getAttribute(Message.SESSION_KEY));
	}
	
	public void removeSession(String account) {
		sessions.remove(account);
	}

	public PcmSession getSeesion(IoSession session){
		if(sessions !=null) {
			Collection<PcmSession> collection = sessions.values();
			for (PcmSession s: collection) {
				if (s.getIoSession()==session){
					return s;
				}
			}
		}
		return null;
	}

    public Collection<PcmSession> getAllSeesion(){
        if(sessions !=null) {
            Collection<PcmSession> collection = sessions.values();
            return collection;
        }
        return null;
    }
}
