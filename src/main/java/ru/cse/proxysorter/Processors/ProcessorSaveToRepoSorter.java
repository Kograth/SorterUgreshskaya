package ru.cse.proxysorter.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.ehcache.EhcacheConstants;
import ru.cse.proxysorter.ConstantsSorter;
import ru.cse.proxysorter.Message.Request11;

public class ProcessorSaveToRepoSorter implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        Message in = exchange.getIn();
        Request11 resourceResponse =  in.getBody(Request11.class);

        exchange.setProperty(String.valueOf(resourceResponse.getCodePLK()),resourceResponse.getBarcode1С());

        Short StatusSize    = resourceResponse.getStateSize();
        Short StatuzWeight  = resourceResponse.getStateWeight();
//Получили значения статусов равные 0 то будем отправлять данные в 1С
        if (StatusSize==0&StatuzWeight==0) {
            in.setHeader(ConstantsSorter.PROPERTY_RSCEIVEDCSP,"0");
        }
        else {
            in.setHeader(ConstantsSorter.PROPERTY_RSCEIVEDCSP,"1");
        }
        in.setHeader(ConstantsSorter.PROPERTY_STATUS_SIZE ,StatusSize);
        in.setHeader(ConstantsSorter.PROPERTY_STATUS_WEIGHT ,StatuzWeight);
        //in.setHeader("ReceivedCSP","1");
        in.setHeader(EhcacheConstants.ACTION, EhcacheConstants.ACTION_PUT);
        in.setHeader(EhcacheConstants.KEY, resourceResponse.getCodePLK()) ;
    }
}
