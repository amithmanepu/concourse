/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013-2015 Jeff Nelson, Cinchapi Software Collective
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.cinchapi.concourse.server.cluster;

import java.util.List;
import java.util.concurrent.Executors;

import org.apache.thrift.TException;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.cinchapi.concourse.server.GlobalState;
import org.cinchapi.concourse.server.cluster.thrift.ClusterService;
import org.cinchapi.concourse.server.cluster.thrift.ClusterService.Iface;
import org.cinchapi.concourse.util.Networking;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * 
 * 
 * @author jnelson
 */
public class Node implements ClusterService.Iface {

    /**
     * The address that this node is identified by in the cluster.
     */
    private final String address;

    protected Node(List<String> cluster) throws TTransportException {
        this.address = Networking.getHostAddress() + ":"
                + GlobalState.CLIENT_PORT;
        System.out.println(address);
        TServerSocket socket = new TServerSocket(GlobalState.CHATTER_PORT);
        ClusterService.Processor<Iface> processor = new ClusterService.Processor<Iface>(
                this);
        Args args = new TThreadPoolServer.Args(socket);
        args.processor(processor);
        args.maxWorkerThreads(cluster.size());
        args.executorService(Executors
                .newCachedThreadPool(new ThreadFactoryBuilder().setNameFormat(
                        "[" + address + "]Chatter" + "-%d").build()));
//        for (String node : cluster) {
//            System.out.println(node);
//        }
    }

    @Override
    public boolean confirm(String node) throws TException {
        // TODO Auto-generated method stub
        return false;
    }

}
