package com.tensquare.recruit.dto;

public class EnterpriseDTO {
    private String id;//ID
    private String name;//企业名称

    public EnterpriseDTO(String id, String name, String summary) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
