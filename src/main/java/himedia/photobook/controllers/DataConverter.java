package himedia.photobook.controllers;

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
		else
			word = "비정상적인 값입니다";	

		return word;
	}
}
