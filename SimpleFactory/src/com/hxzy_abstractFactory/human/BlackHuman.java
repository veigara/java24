package com.hxzy_abstractFactory.human;

public abstract class BlackHuman implements Human {

	@Override
	public void talk() {
		System.out.println("黑种人说话一般人听不懂");
	}

}
