package com.threadlearn.producerandconsumer;
 
public class MyThreadB extends Thread{
 
/**
 * 消费者线程
 */
private MyService myService;
	
	public MyThreadB(MyService myService){
		this.myService = myService;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			myService.get();
		}
	}
 
}
