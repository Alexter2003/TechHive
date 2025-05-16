package com.app.TechHive.domain.DTOs;

import com.app.TechHive.domain.utilsDTO.Resource_Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resource {
    private String Title;
    private String description;
    private String ulr;
    private String platform;
    private Resource_Category category;

}
