package himedia.photobook.repositories.dao;

public interface OrderDao {
	public int orderInsert(String userId, String albumId, Long oQuantity);	// 주문생성
}
