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
	
	@Override
	public String selectStatusByOrderID(String orderId) {
		return session.selectOne("refund.selectStatusByOrderID", orderId);
	}
	
	@Override
	public List<RefundVo> selectAllRefunds(){
		return session.selectList("refund.selectAllRefunds");
	}
	
	@Override
	public int insert(String orderId) {
		return session.insert("refund.insert", orderId);
	}
}
