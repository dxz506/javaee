package com.wpx.storm.demo01.topology;


import com.wpx.storm.demo01.bolt.PrintBolt;
import com.wpx.storm.demo01.bolt.WriteBolt;
import com.wpx.storm.demo01.spout.Spout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

public class Topology01 {

	public static void main(String[] args) throws InterruptedException {
		Config cfg = new Config();
		cfg.setNumWorkers(2);
		cfg.setDebug(true);

		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout",new Spout());
		builder.setBolt("print-bolt", new PrintBolt());
		builder.setBolt("write-bolt", new WriteBolt());
		
		//����ģʽ
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("top1", cfg, builder.createTopology());
		Thread.sleep(1000);
		cluster.killTopology("top1");
		cluster.shutdown();
	}
}
