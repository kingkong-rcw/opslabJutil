package com.opslab.util;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class XMLUtilTest {
    @Test
    public void testStringify() throws Exception{
        Stupid stupid = new Stupid();
        stupid.setAge(2);
        stupid.setName("sb");
        stupid.setShortStory("blablabla....");

        String xml = XMLUtil.stringify(stupid);
        System.out.println("xml=\n"+xml);
    }
    @Test
    public void testParse() throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("<stupid>");
        sb.append("<age>3</age>");
        sb.append("<name>sb!</name>");
        sb.append("<short-story>what?</short-story>");
        sb.append("</stupid>");

        Stupid stupid = (Stupid)XMLUtil.parse(sb.toString(),Stupid.class);
        System.out.println("stupid="+stupid);
        Assert.assertEquals(stupid.getAge(),3);
        Assert.assertEquals(stupid.getShortStory(),"what?");
    }
    @XmlRootElement(name = "stupid")
    public static class Stupid{
        private String name;
        private int age;
        private String shortStory;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @XmlElement(name = "short-story")
        public String getShortStory() {
            return shortStory;
        }

        public void setShortStory(String shortStory) {
            this.shortStory = shortStory;
        }
    }
}
