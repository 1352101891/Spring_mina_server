package com.pcm.mina.service;

import com.pcm.mina.service.model.IMPackage;
import com.pcm.mina.service.session.PcmSession;
/**
 * @author ZERO
 * @Description  请求处理接口,所有的请求必须实现此接口
 */
public interface RequestHandler {
	public abstract IMPackage process(PcmSession session, IMPackage message);
}
