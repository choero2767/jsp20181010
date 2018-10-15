package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"ball3.gif\"";

		String fileName = "";
		
		/***When***/
		// logic
		String[] splits = contentDisposition.split("; ");
		for(String str : splits) {
			if(str.indexOf("filename=") >= 0){
				fileName = str.substring(10, str.lastIndexOf("\""));
			}
		}
		
		/***Then***/
		assertEquals("ball3.gif", fileName);
		
	}

}
