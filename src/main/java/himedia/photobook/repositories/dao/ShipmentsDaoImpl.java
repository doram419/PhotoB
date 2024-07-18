package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.ShipmentsVo;

@Repository
public class ShipmentsDaoImpl implements ShipmentsDao{
	@Autowired
	private SqlSession session;
	
	public String selectStatusByOrderID(String orderId) {
		return session.selectOne("shipments.selectStatusByOrderID", orderId);
	}
	
	public ShipmentsVo selectShipmentInfoByOrderID(String orderId) {
		return session.selectOne("shipments.selectShipmentInfoByOrderID", orderId);
	}

	@Override
	public List<ShipmentsVo> selectAll() {
		return session.selectList("shipments.selectAll");
	}
}
