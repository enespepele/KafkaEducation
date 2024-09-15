package com.enesppl.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaBaseProducer {


    public static void main(String[] args) {

        Properties config = new Properties();


        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // Get serialize this class for key
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());//Get serialize this class for value

        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String,String>(config);
        ProducerRecord<String,String> kafkaRecord = new ProducerRecord<String,String>("transaction_eft","Hello From Java ");
        kafkaProducer.send(kafkaRecord);
        kafkaProducer.flush();

       // config.put("bootstrap.server","localhost:9092"); This is the another method for bootstrap server


    }
}
