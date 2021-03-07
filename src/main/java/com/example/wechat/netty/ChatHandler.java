package com.example.wechat.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @ClassName CustomHandler
 * @Description 自定义助手类, SimpleChannelInboundHandler对于请求来讲相当于入站
 * @Author Tzj
 * @Date 2021/2/27 21:33
 */
public class ChatHandler extends SimpleChannelInboundHandler<HttpObject> {
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        //获取channel
        Channel channel = channelHandlerContext.channel();
        if(httpObject instanceof HttpRequest){
            System.out.println("客户端地址为:" + channel.remoteAddress());
            //定义发送的数据消息
            ByteBuf content = Unpooled.copiedBuffer("hello,nt", CharsetUtil.UTF_8);
            //构建一个http response
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            //为响应增加数据类型和长度
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            //把响应刷到客户端
            channelHandlerContext.writeAndFlush(response);
        }
    }
}
