package pers.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.entity.User;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User findByAccount(@Param("account") String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}