package himedia.photobook.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 코드, 날짜등을 사용자가 인지하기 편한 값으로 변환해주고 리턴해주는 클래스
 * */
public class DataConverter {
	/**
	 * Shipments 혹은 Refund의 Status를 받아서 사람이 인지하기 편한 문장으로 되돌려주는 코드
	 *  A(Application): 배송 준비 
	 *  B(Before Shipping): 배송 중 
	 *  C(Complete): 배송 완료
	 *  R(Refund): 환불 
	 *  P(Preparing Refund): 환불 준비
	 *  F(Finished Refund): 환불 완료
	 * */
	public String statusToWord(String statusCode) {
		String word = null;
		
		if(statusCode.equals("A"))
			word = "배송 준비";
		else if(statusCode.equals("B"))
			word = "배송 중";
		else if(statusCode.equals("C"))
			word = "배송 완료";
		else if(statusCode.equals("P"))
			word = "환불 대기";
		else if(statusCode.equals("F"))
			word = "환불 완료";
		else if(statusCode.equals("G"))
			word = "주문 요청";
		else
			word = "비정상적인 값입니다";	

		return word;
	}
	
	/**
	 * java.util.date 타입을 쓰면 Mon Jul 15 13:11:37 KST 2024 식으로 나옴
	 * 그래서 그걸 "yyyy-MM-dd"식으로 나오게 해주는 메서드
	 * parameter : Date 타입
	 * return : "yyyy-MM-dd"의 String
	 * */
	public String kstToYYYY(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.format(date);
	}
	
	/**
	 * String 타입의 데이터를 java.util.date 타입으로 변환시켜주는 메서드
	 * parameter : 날짜 형식의 String 
	 * return : date 타입 
	 * @throws ParseException 
	 * */
	public Date StringToDate(String src) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.parse(src);
	}
	
	/**
	 * java.util.date 타입을 쓰면 Mon Jul 15 13:11:37 KST 2024 식으로 나옴
	 * 그래서 그걸 "yyyy-MM-dd'T'HH:mm"식으로 나오게 해주는 메서드
	 * parameter : Date 타입
	 * return : String - datetime-local 
	 * */
	public String kstToLocal(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		
		return dateFormat.format(date);
	}
	
	/**
	 * String("yyyy-MM-dd'T'HH:mm")으로 날짜가 들어오면 java.util.date 타입으로 변환시켜주는 메서드
	 * parameter : String - datetime-local 
	 * return : Date
	 * */
	public Date LocalToKst(String src) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		
		return dateFormat.parse(src);
	}
}