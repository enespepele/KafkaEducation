package com.enesppl.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaBaseProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaBaseProducer.class);

    public static void main(String[] args) {


        Properties config = new Properties();


        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // Get serialize this class for key
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());//Get serialize this class for value

        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String,String>(config);
        ProducerRecord<String,String> kafkaRecord = new ProducerRecord<String,String>("transaction_eft","Hello From Java ");
        kafkaProducer.send(kafkaRecord);
        kafkaProducer.flush();

        for (int i=0 ; i<120 ; i++){

            ProducerRecord<String,String> kafkaRecord2 = new ProducerRecord<String,String>("transaction_eft","Hello From Java "+i);
            kafkaProducer.send(kafkaRecord2);
            logger.info("Hello From Java "+i+" Send to Kafka");
            kafkaProducer.flush();

        }



       // config.put("bootstrap.server","localhost:9092"); This is the another method for bootstrap server


    }
}
