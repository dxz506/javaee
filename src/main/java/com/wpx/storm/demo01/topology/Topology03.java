package com.wpx.storm.demo01.topology;


import com.wpx.storm.demo01.bolt.PrintBolt;
import com.wpx.storm.demo01.bolt.WriteBolt;
import com.wpx.storm.demo01.spout.Spout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;



public class Topology03 {

	public static void main(String[] args) throws InterruptedException, AlreadyAliveException, InvalidTopologyException  {
		Config config = new Config();
		config.setNumWorkers(2);
		config.setDebug(true);
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new Spout(), 4);
		builder.setBolt("print-bolt", new PrintBolt(), 4).shuffleGrouping("spout");
		//�����ֶη���
		builder.setBolt("write-bolt",new WriteBolt(),8).fieldsGrouping("print-bolt", new Fields("write"));
		//������ȫ����
		builder.setBolt("write-bolt", new WriteBolt(),4).allGrouping("print-bolt");
		//����ȫ�ַ���
		builder.setBolt("write-bolt", new WriteBolt(), 4).globalGrouping("print-bolt");
		
		//����ģʽ
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("top3", config, builder.createTopology());;
		Thread.sleep(100);
		cluster.killTopology("top3");
		cluster.shutdown();
		
		//��Ⱥģʽ
		StormSubmitter.submitTopology("top3", config, builder.createTopology());
	}
}
