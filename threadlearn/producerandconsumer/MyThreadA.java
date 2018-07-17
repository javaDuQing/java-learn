package com.threadlearn.producerandconsumer;
 
/**
 * 生产者线程
 * @author Administrator
 *
 */
public class MyThreadA extends Thread{
	
	private MyService myService;
	
	public MyThreadA(MyService myService){
		this.myService = myService;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			myService.set();
		}
	}
 
}
