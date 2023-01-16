package pers.dao;

import org.springframework.stereotype.Repository;
import pers.entity.ItemUnit;

@Repository
public interface ItemUnitDao {
    int deleteByPrimaryKey(Long id);

    int insert(ItemUnit record);

    int insertSelective(ItemUnit record);

    ItemUnit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemUnit record);

    int updateByPrimaryKey(ItemUnit record);
}