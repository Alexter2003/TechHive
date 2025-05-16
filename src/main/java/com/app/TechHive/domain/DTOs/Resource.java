package com.app.TechHive.domain.DTOs;

import com.app.TechHive.domain.utilsDTO.Resource_Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private String title;
    private String description;
    private String url;
    private String platform;
    private Resource_Category category;

}
