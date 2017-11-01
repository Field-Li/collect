package com.collect.nettyInAction.nettyServer4_1.nettyNIO;

/**
 * Created by lifana on
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

public class NIOServerHandler extends ChannelInboundHandlerAdapter {

    public NIOServerHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 连接后，写消息到客户端，写完后便关闭连接
        final ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("hello!\r\n", CharsetUtil.UTF_8));
        System.out.println("Server received: " + buf);
        ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
    {
        System.out.println("Server received: " + msg);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception

    {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}