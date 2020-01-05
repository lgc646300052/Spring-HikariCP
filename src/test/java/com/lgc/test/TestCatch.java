package com.lgc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test() throws Exception {
		FileInputStream in = null;
		try {
			in = new FileInputStream("aa");
		} catch (FileNotFoundException e) {
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				throw e;
			}
		}
	}
	
	public static void test2() throws Exception {
		try (FileInputStream in = new FileInputStream("G:/log/SSM5.log.2017-11-11")) {
			in.close();
			in.read();
		} catch (Exception e) {
			throw e;
		}
	}

}
