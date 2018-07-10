package com.wpx.storm.demo01.bolt;

import java.io.FileWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;




public class WriteBolt extends BaseBasicBolt{
	private static final Log log=LogFactory.getLog(WriteBolt.class);
	
	private static final long serialVersionUID = 1L;

	private FileWriter writer;
	
	@Override
	public void execute(Tuple tuple, BasicOutputCollector collector) {
		//��ȡ��һ�������������Field
		String text = tuple.getStringByField("write");
		try {
			if(writer == null) {
				if(System.getProperty("os.name") .equals("Linux")) {
					writer = new FileWriter("D:\\storm_test01\\"+this);
				}else {
					System.out.println("-------" + System.getProperty("os.name"));
					writer = new FileWriter("/usr/local/temp/"+this);
				}
			}
			log.info(" д���ļ� ");
			writer.write(text);
			writer.write("\n");
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
	}

}
