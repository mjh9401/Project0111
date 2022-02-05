package com.mjh.exam.Test1.Ut;

import java.security.MessageDigest;

public class Ut {

	public static boolean empty(Object obj) {
		if(obj == null) {
			return true;
		}
		
		if(obj instanceof Integer) {
			return ((int)obj) == 0;
		}
		
		if(obj instanceof Long) {
			return ((long)obj) == 0;
		}
		
		if(obj instanceof String == false) {
			return true;
		}
		
		String str = (String) obj;
		
		return str.trim().length() ==0;
	}
	
	public static String f(String format, Object...args) {
		
		return String.format(format, args);
	}
	
	public static String print(String msg) {
		if(msg == null) {
			msg = "";
		}
		
		String script = "<script>"
				+ "const msg = '%s'.trim();"
				+ "if(msg.length > 0){alert(msg);}"
				+ "</script>";
				
		return Ut.f(script, msg);
	}
	
	public static String jsHistoryBack(String msg) {
		if(msg == null) {
			msg = "";
		}
		
		String script = "<script>"
				+ "const msg = '%s'.trim();"
				+ "if(msg.length > 0){alert(msg);}"
				+ "history.back();"
				+ "</script>";
				
		return Ut.f(script, msg);
	}

	
	public static String jsReplace(String msg, String uri) {
		if(msg == null) {
			msg = "";
		}
		
		if(uri == null) {
			uri = "";
		}
		
		String script = "<script>"
				+ "const msg = '%s'.trim();"
				+ "if(msg.length > 0){alert(msg);}"
				+ "location.replace('%s');"
				+ "</script>";

		return Ut.f(script,msg, uri);
	}
	
	public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception ex) {
            return "";
        }
    }

}
