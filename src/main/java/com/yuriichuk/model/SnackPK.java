package com.yuriichuk.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SnackPK implements Serializable {
    private Integer id;
    private Integer brandId;

    @Column(name = "id")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "brand_id")
    @Id
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnackPK snackPK = (SnackPK) o;
        return Objects.equals(id, snackPK.id) && Objects.equals(brandId, snackPK.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId);
    }
}
