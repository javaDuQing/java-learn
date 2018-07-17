package com.threadlearn.producerandconsumer;
 
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
 
public class MyService {
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;
	
	/**
	 * 生产数据
	 */
	public void set(){
		try {
			lock.lock();    
			while(hasValue){
				condition.await();
			}
			System.out.println("生产数据");
			hasValue = true;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	/**
	 * 消费数据
	 */
	public void get(){
		try {
			lock.lock();
			while(!hasValue){
				condition.await();
			}
			System.out.println("消费数据");
			hasValue = false;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
 
}
