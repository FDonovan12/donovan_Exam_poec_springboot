package fr.donovan.exam.centrale_ish.entity.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SluggerInterface {

    void setSlug(String slug);

    @JsonIgnore
    String getField();

}
