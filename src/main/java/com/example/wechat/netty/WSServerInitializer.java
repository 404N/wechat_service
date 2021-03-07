package com.example.wechat.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName HelloServerInitializer
 * @Description 初始化器，channel注册后，会执行相应的初始化方法
 * @Author Tzj
 * @Date 2021/2/27 21:24
 */
public class WSServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 通过socketchannel去获取对应管道
        ChannelPipeline channelPipeline=socketChannel.pipeline();
        //通过管道添加handler
        channelPipeline.addLast("HttpServerCodec",new HttpServerCodec());
        //添加自定义的handler，返回hello
        channelPipeline.addLast("customHandler",new com.example.wechat.netty.ChatHandler());
    }
}
