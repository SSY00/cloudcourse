package com.ros.util;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Random;

public class RandomUtil {

 public static String generateFourRandom() {
    String result= new String();
    Random random = new Random();
    for (int i = 0; i < 4; i++) {
		result=result+random.nextInt(10);
	}
    return result;
 }
}
