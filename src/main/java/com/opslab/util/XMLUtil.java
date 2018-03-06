package com.opslab.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

public class XMLUtil {
    public static Object parse(String xmlStr,Class c) throws Exception{
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(new ByteArrayInputStream(xmlStr.getBytes()));
        return obj;
    }
    public static String stringify(Object obj) throws Exception{
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(obj,sw);
        return sw.toString();
    }
}
