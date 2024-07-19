package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("shipmentsDao")
public class ShipmentsDaoImpl {
	@Autowired
	private SqlSession session;
	
	public String selectStatusByOrderID(String orderId) {
		return session.selectOne("shipments.selectStatusByOrderID", orderId);
	}
}
