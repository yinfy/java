package gov.cygs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * 身份证验证规则： 第十八位数字（校验码）的计算方法为：  
 * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 
 * 2.将这17位数字和系数相乘的结果相加。  
 * 3.用加出来和除以11，看余数是多少？ 
 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。 
 * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。 
 *  
 * @author: (le.qiao) 
 * @e-mail: qiaolevip@gmail.com 
 * @myblog: <a href="http://qiaolevip.iteye.com">http://qiaolevip.iteye.com</a> 
 * @date: 2012-10-18 
 *  
 */  
public class IdCard {  
  
    public static boolean checkIdno(String cardNo) {  
        //cardNo = "360481197512040035"; // 36900119751204003X // 360481197512040035  
        // 1.将身份证号码前面的17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2  
    	try{
    		cardNo = cardNo.toUpperCase();
    		int[] intArr = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };  
    		int sum = 0;  
    		for (int i = 0; i < intArr.length; i++) {  
    			// 2.将这17位数字和系数相乘的结果相加。  
    			sum += Character.digit(cardNo.charAt(i), 10) * intArr[i];  
    			// System.out.println((cardNo.charAt(i) - '0') + " x " + intArr[i] + " = " + (cardNo.charAt(i) - '0') *  
    			// intArr[i]);  
    		}  
        //System.out.println("Totally sum：" + sum);  
        // 3.用加出来和除以11，看余数是多少？  
        int mod = sum % 11;  
        //System.out.println("Totally sum%11 = " + mod);  
        // 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。  
        int[] intArr2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };  
        int[] intArr3 = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };  
        String matchDigit = "";  
        for (int i = 0; i < intArr2.length; i++) {  
            int j = intArr2[i];  
            if (j == mod) {  
                matchDigit = String.valueOf(intArr3[i]);  
                if (intArr3[i] > 57) {  
                    matchDigit = String.valueOf((char) intArr3[i]);  
                }  
            }  
        }  
  
        if (matchDigit.equals(cardNo.substring(cardNo.length() - 1))) {  
            //System.out.println("ID Card Verify Sucsess!");
            return true;
        } else {  
            //System.out.println("ID Card Verify Faild!");  
        	return false;
        }  
    }catch(Exception e){
    	//System.out.println("ID Card Verify Faild!");  
    	return false;
    }
    // 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。  
}  
    
    public static int getAge(String idno){
    	int age=0;
    	if(idno==null || idno.length()<18){
    		return age;
    	}
    	String birthStr= idno.substring(6, 13);
    	SimpleDateFormat sf = new SimpleDateFormat();
    	sf.applyPattern("yyyyMMdd");
    	Date birthDay= null;
    	try {
			birthDay =  sf.parse(birthStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    	if(birthDay==null){
    		return age;
    	}
    	
    	Date today = new Date();
    	
    	Calendar cal1 = Calendar.getInstance();
    	Calendar cal2 = Calendar.getInstance();
    	
    	cal1.setTime(birthDay);
    	cal2.setTime(today);
    	
    	age=cal2.get(Calendar.YEAR)-cal1.get(Calendar.YEAR);
    	int days= cal2.get(Calendar.DAY_OF_YEAR)-cal1.get(Calendar.DAY_OF_YEAR);
    	
    	if(days<0){
    		age--;
    	}
    	
    	return age;
    }
    
    public static void main(String[] args) {
    	IdCard.checkIdno("");
    	System.out.println("age is :"+IdCard.getAge("220104197312071310"));
    }
}  


