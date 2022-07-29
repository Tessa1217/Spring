package com.company.app.security;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptTest {
	
	@Test
	public void test() {
		BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder(); 
		String password = scpwd.encode("1111");
		System.out.println(password);
		
		// 파라미터 값은 stress(강도) = 해킹 방지를 위한 지연 시간
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
		String result = encoder.encode("myPassword");
		System.out.println(result);
		// 암호화할 때마다 다른 값이 나오기 때문에 matches 함수로 비교
		assertTrue(encoder.matches("myPassword", result));
	}
 
}
