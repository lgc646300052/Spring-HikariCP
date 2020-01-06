package com.lgc.test;

import org.junit.Test;

public class TestSynchroinzed {
	
	@Test
	public void test() throws InterruptedException {
		StringBuilder sb = new StringBuilder("LGC");
		
		Thread t1 = new Thread(new Runnable() {
				public void run() {
					synchronized (sb) {
//						synchronized (sb) {
//							throw new RuntimeException();
							try {
								Thread.sleep(2L);
								print(sb.toString());
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
//						}
					}
				}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (sb) {
					print(sb.toString());
					sb.append(" t2");
					print("end");
//					sb.notify();
				}
			}
			
		}, "t2");
		
		t1.start();
//		Thread.sleep(100L);
		t2.start();
	}
	
	public static void print(Object obj) {
		System.out.println(Thread.currentThread().getName() +":"+ obj);
	}

}
