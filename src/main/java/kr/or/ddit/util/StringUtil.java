package kr.or.ddit.util;

public class StringUtil {
	
	/**
	* Method : getFileNameFromHeader
	* 작성자 : pc23
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition
	*/
	public static String getFileNameFromHeader(String contentDisposition){
		String fileName = "";
		String[] splits = contentDisposition.split("; ");
		for(String str : splits) {
			if(str.indexOf("filename=") >= 0){
				fileName = str.substring(10, str.lastIndexOf("\""));
			}
			
		}
		return fileName;
	}

	
	/**
	* Method : getCookie
	* 작성자 : pc23
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 : cookieString
	*/
	public static String getCookie(String cookieString, String string) {
		
		String fileName = "";
		
		String[] splits = cookieString.split("; ");
		
		for(String str : splits) {
			if(str.indexOf(string) >= 0){
				System.out.println(str);
				fileName = str.substring(str.indexOf("=")+1);
				System.out.println(fileName);
				
			}
			
		}
		return fileName;
	}
	
}
