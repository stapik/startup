package com.startup.startup.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
public class UpdateArticleDTO extends CreateArticleDTO {

    @NotNull
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UpdateArticleDTO that = (UpdateArticleDTO) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
