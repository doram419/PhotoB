package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import himedia.photobook.exceptions.UsersDaoException;
import himedia.photobook.repositories.vo.UsersVo;

//@Repository("profileDao")
@Repository
public class ProfileDaoImpl implements ProfileDao {

    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public int updateProfile(UsersVo user) {
        try {
            int updatedCount = sqlSession.update("profile.updateProfile", user);
            System.out.println("Updating profile for user: " + user);
            System.out.println("updatecount"+updatedCount);
            return updatedCount;
        } catch (Exception e) {
        	e.printStackTrace();
            throw new UsersDaoException("예외 발생!");
        }
    }
}
