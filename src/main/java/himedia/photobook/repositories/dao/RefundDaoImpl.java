package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.RefundVo;

@Repository
public class RefundDaoImpl implements RefundDao{
	@Autowired
	private SqlSession session;
	
	public String selectStatusByOrderID(String orderId) {
		return session.selectOne("refund.selectStatusByOrderID", orderId);
	}
	
	public List<RefundVo> selectAllRefunds(){
		return session.selectList("refund.selectAllRefunds");
	}
}
