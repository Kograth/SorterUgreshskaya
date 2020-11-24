/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cse.proxysorter.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import ru.cse.Meashuring.Service1c.Measurement;
import ru.cse.proxysorter.ConstantsSorter;
import ru.cse.proxysorter.Message.Request11;

/**
 *
 * @author Oleynik
 */
public class Processor13ToMeashure implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {

            Request11 Req11 = exchange.getIn().getBody(Request11.class);
            Measurement Reqto1C = new Measurement();
            //Сортировщик отдает в мм размера, а вес в кг.
            if (!(Req11==null)) {
            float weight = Float.valueOf(Req11.getWeight());
            Reqto1C.setHeight(Float.valueOf(Req11.getHeight()));
            Reqto1C.setLength(Float.valueOf(Req11.getLength()));
            Reqto1C.setWidth(Float.valueOf(Req11.getWidth()));
            Reqto1C.setWeight(weight);
            Reqto1C.setNumber(Req11.getBarcode1С());
        }
            else {
            Reqto1C.setHeight(Float.valueOf(1));
            Reqto1C.setLength(Float.valueOf(1));
            Reqto1C.setWidth(Float.valueOf(1));
            Reqto1C.setWeight(Float.valueOf(1));
            Reqto1C.setNumber("request 11 is null");
        }
            //Гуид для 1с чтобы получить пользователя
            //Ждем обновления webservice Measurer
            //Reqto1C.setMeasurementSource("754208e4-6e15-489a-af0d-f589e6569895");

            Message Out = exchange.getOut();
            Out.setBody(Reqto1C);
            Out.setHeader(CxfConstants.OPERATION_NAME, "Measurement");
            Out.setHeader(CxfConstants.OPERATION_NAMESPACE, "http://www.cse-cargo.ru/MeasurerCargo");
    }
    
}
