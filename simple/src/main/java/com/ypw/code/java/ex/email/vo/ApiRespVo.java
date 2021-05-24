package com.ypw.code.java.ex.email.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yangpengwei
 * @time: 2021/5/19 5:46 下午
 * @description 接口返回 VO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiRespVo {
    private Integer code;
    private String msg;
    private Object data;
}
