package com.antybeety.map.model.vo;

import lombok.Data;

@Data
public class LightDetailVO implements FacilityDetailVO{
    private String code;
    private String roadAddr;
    private String landAddr;
    private String adminName;
    private String adminTel;
}
