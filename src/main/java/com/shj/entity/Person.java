package com.shj.entity;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (Person)实体类
 *
 * @author shj
 * @since 2020-05-29 15:17:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//链式编程
public class Person implements Serializable {
    private static final long serialVersionUID = -31576833995775145L;

    @Excel(name = "id")
    private Integer id;

    @Excel(name = "openid")
    private String openid;

    @Excel(name = "nickname")
    private String nickname;

    @Excel(name = "sex")
    private Integer sex;

    @Excel(name = "city")
    private String city;

    @Excel(name = "country")
    private String country;

    @Excel(name = "province")
    private String province;

    @Excel(name = "headimgurl")
    private String headimgurl;

    @Excel(name = "subscribe")
    private String subscribe;

    @Excel(name = "language")
    private String language;

    @Excel(name = "remark")
    private String remark;

    private String other;



}