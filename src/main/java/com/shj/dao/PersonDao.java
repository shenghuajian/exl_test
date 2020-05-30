package com.shj.dao;

import com.shj.entity.Person;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * (Person)表数据库访问层
 *
 * @author shj
 * @since 2020-05-29 15:17:59
 */
@Mapper
public interface PersonDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Person queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Person> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param person 实例对象
     * @return 对象列表
     */
    List<Person> queryAll(Person person);

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 影响行数
     */
    int insert(Person person);

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 影响行数
     */
    int update(Person person);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int insertList(List<Person> list);

    @Update("UPDATE person SET remark=#{state} WHERE id =#{id}")
    int updateRemarkById(@Param("state") String state,@Param("id") Integer id);


    int deleteByIds(String[] ids);
}