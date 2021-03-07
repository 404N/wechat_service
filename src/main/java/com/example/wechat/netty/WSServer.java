package com.example.wechat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @ClassName WSServer
 * @Description TODO
 * @Author Tzj
 * @Date 2021/3/6 9:04
 */
@Component
public class WSServer {

    public static class SingletonWsServer {
        static final WSServer instance = new WSServer();
    }

    public static WSServer getInstance() {
        return SingletonWsServer.instance;
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup workerGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    public WSServer() {
        //定义一对线程组
        //主线程组， 用于接收客户端的连接但是不做事
        mainGroup = new NioEventLoopGroup();
        //从线程组， 接收主线程主安排的任务
        workerGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WSServerInitializer());
    }

    public void start() {
        this.future = server.bind(8088);
        System.out.println("netty websocket start");
    }

}
