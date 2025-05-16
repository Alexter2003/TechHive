package com.app.TechHive.domain.utilsDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Resource_Category {
    PAID_COURSES,
    FREE_COURSES,
    OFFICIAL_SITE,
    OFFICIAL_DOCS,
    CONTENT_CREATORS,
    TECH_BLOGS
}
