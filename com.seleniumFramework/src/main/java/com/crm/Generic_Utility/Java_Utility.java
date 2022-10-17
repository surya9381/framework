package com.crm.Generic_Utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * This method id used to fetch the random number
	 * @return
	 * @author surya
	 */
	public int getRandom()
	{
		Random ran=new Random();
		int RanNum=ran.nextInt(1000);
		return RanNum;
		
	}

}
