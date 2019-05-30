package com.fc.test.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PositionUtil {

    private  Integer range;
    private  Double longiFor100;
    private  Double latFor100;
    private  Properties properties;

    {

        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("position.properties");
        properties = new Properties();		//获取属性文件
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        range = Integer.parseInt(properties.getProperty("range"));
        longiFor100 = Double.parseDouble(properties.getProperty("lonFor100"));
        latFor100 = Double.parseDouble(properties.getProperty("latFor100"));
    }
    /**
     * 检查是否在范围内
     * @param nowLon
     * @param nowLat
     * @param targetLon
     * @param targetLat
     * @return
     */
    public  boolean checkHereYesOrNotPunch(Double nowLon, Double nowLat, Double targetLon, Double targetLat) {

        return Math.abs(targetLat - nowLat) <= range * latFor100 && Math.abs(targetLon - nowLon) <= range * longiFor100;
    }

    public Properties getProperties() {
        return properties;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        String result = list.toString();
        result =  result.substring(1, result.length() - 1);
        System.out.println(result);
        Integer[] integers = (Integer[]) list.toArray(new Integer[0]);
        reverse1(3, 6, integers) ;
        result = "";
        for (Integer a:integers) {
            result = result + a +",";
        }
        //result =  result.substring(0, result.length() - 1);
        System.out.println(result);
    }

    static void reverse1(Integer start, Integer end, Integer[] array) {
        int temp;
        for (int i = start-1; i<=(end+start)/2-1; i++) {
            temp = array[i];
            array[i] = array[end - (i - start + 1) - 1];
            array[end - (i - start + 1) - 1] = temp;
        }
    }
}
