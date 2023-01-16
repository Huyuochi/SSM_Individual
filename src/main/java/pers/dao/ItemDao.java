package pers.dao;

import org.springframework.stereotype.Repository;
import pers.entity.Item;

@Repository
public interface ItemDao {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}