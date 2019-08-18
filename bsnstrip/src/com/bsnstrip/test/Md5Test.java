package com.bsnstrip.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class Md5Test {
	@Test
	public void testMd5() {
		
		String password = "luohaojian";
		String salt = "666";
		
		Md5Hash md5 = new Md5Hash(password, salt, 1);
		
		System.out.println(md5);
	}
}
