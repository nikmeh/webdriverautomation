package com.sqa.ra.framework;

import java.util.Random;

public class CaptchaService {
	
	public static String getCaptcha(){
		Random rd=new Random();
		return String.valueOf(rd.nextGaussian());
	}

}
