package com.shj.service;

import com.shj.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Person)表服务接口
 *
 * @author shj
 * @since 2020-05-29 15:17:59
 */
public interface PersonService {

    int insertList(List<Person> list);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Person queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Person> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person insert(Person person);

    /**
     * 修改数据
     *
     * @param person 实例对象
     * @return 实例对象
     */
    Person update(Person person);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Person> queryAll();

    int updateRemarkById(String state,Integer id);

    int deleteByIds(String[] ids);

    List<Person> queryBySearch(String nickname, String remark);
}