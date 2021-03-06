package com.crossoverjie.netty.client.learning.channel.init;

import com.crossoverjie.netty.client.learning.encode.CustomerEncode;
import com.crossoverjie.netty.client.learning.handle.EchoClientHandle;
import com.crossoverjie.netty.client.learning.handle.HeartHandle;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 23/02/2018 22:47
 * @since JDK 1.8
 */
public class CustomerHandleInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                //10 秒没发送消息
                .addLast(new IdleStateHandler(0, 10, 0))
                .addLast(new CustomerEncode())
                .addLast(new EchoClientHandle())
        ;
    }
}
