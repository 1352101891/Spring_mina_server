package com.pcm.mina.client.MinaDemo;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * @author ZERO
 * @Description 客户端handle
 */
public class MinaClientHandler extends IoHandlerAdapter {
    private static Logger logger = Logger.getLogger(MinaClientHandler.class);

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        String msg = message.toString();
    //    logger.info("客户端A接收的数据:" + msg);
        System.out.println("客户端A接收的数据:" + msg);
        if(msg.equals("hb_request")){
            logger.warn("客户端A成功收到心跳包:hb_request");
            session.write("hb_response");
            logger.warn("客户端A成功发送心跳包:hb_response");
        }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        logger.warn("sessionClosed");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        logger.error("发生错误...", cause);
    }
}
