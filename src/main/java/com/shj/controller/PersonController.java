package com.shj.controller;

import com.shj.entity.Person;
import com.shj.service.PersonService;
import com.shj.utils.EasyPoiUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (Person)表控制层
 *
 * @author shj
 * @since 2020-05-29 15:17:59
 */
@Controller
@RequestMapping("person")
public class PersonController {

    /**
     * 服务对象
     */
    @Autowired
    private PersonService personService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public Person selectOne(Integer id) {
        return this.personService.queryById(id);
    }

    @RequestMapping("fileUp")
    @ResponseBody
    public String fileUp(@RequestParam("file") MultipartFile file) {
        List<Person> people = EasyPoiUtils.importExcel(file, Person.class);
        personService.insertList(people);
        return "1";
    }

    @RequestMapping("fileDown")
    public void fileDown(HttpServletResponse response) {
        List<Person> personList = personService.queryAll();
        // 导出操作
        EasyPoiUtils.exportExcel(personList, "easypoi导出功能", "导出sheet1", Person.class, "测试user.xls", response);
    }

    @RequestMapping("showData")
    public String showData(Model model) {
        List<Person> personList = personService.queryAll();
        model.addAttribute("list", personList);
        return "list";
    }

    @RequestMapping("updateRemarkById")
    @ResponseBody
    public int updateRemarkById(@Param("state") String state,@Param("id") Integer id) {

        System.out.println(state);
        System.out.println(id);
        int i = personService.updateRemarkById(state, id);

        return i;
    }

    @RequestMapping("deleteByIds")
    @ResponseBody
    public int deleteByIds(@Param("ids") String ids) {

        System.out.println(ids);
        String[] split = ids.split(",");
        int i = personService.deleteByIds(split);

        return i;
    }

    @RequestMapping("search")
    public String  search(@Param("nickname") String nickname, @Param("remark") String remark, Model model) {

        System.out.println(remark);
        System.out.println(nickname);
        List<Person> people = personService.queryBySearch(nickname, remark);
        model.addAttribute("list", people);

        return "list";
    }
}