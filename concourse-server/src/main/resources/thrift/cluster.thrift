# This file defines the inter-node communication (aka Chatter) protocol within a
# distributed Concourse cluster.
#
# To generate java source code run:
# thrift -out ../../java -gen java cluster.thrift

namespace java org.cinchapi.concourse.server.cluster.thrift

/**
 * The spec for the Chatter protocol that distributed Concourse nodes use
 * to communicate with one another.
 */
service ClusterService {

  /**
   * Return {@code true} if the {@code node} identified by the specified address
   * is one with which this node expects to communicate.
   *
   * @param node
   * @return {@code true} if this node can confirm it should talk to {@code node}
   */
  bool confirm(1: string node);

}
