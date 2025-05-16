package com.app.TechHive.domain.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponse {
    private List<Resource> paidCourses;
    private List<Resource> freeCourses;
    private List<Resource> officialSite;
    private List<Resource> officialDocs;
    private List<Resource> contentCreators;
    private List<Resource> techBlogs;

}
