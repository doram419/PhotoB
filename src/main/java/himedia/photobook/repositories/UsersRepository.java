package himedia.photobook.repositories;

import himedia.photobook.repositories.vo.UsersVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository {

    @Select("SELECT * FROM USERS WHERE EMAIL = #{email}")
    UsersVo findByEmail(@Param("email") String email);

    @Insert("INSERT INTO USERS (USER_ID, EMAIL, PASSWORD, USER_NAME, CREATED_AT, UPDATED_AT) " +
            "VALUES (#{userId}, #{email}, #{password}, #{userName}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
    void save(UsersVo user);
}