package com.example.pizza.model.size;

import java.util.Objects;

public class Size {
    private int idSize;
    private float priceCoeff;
    private String sizeName;

    public Size(int idSize, float priceCoeff, String sizeName) {
        this.idSize = idSize;
        this.priceCoeff = priceCoeff;
        this.sizeName = sizeName;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public float getPriceCoeff() {
        return priceCoeff;
    }

    public void setPriceCoeff(float priceCoeff) {
        this.priceCoeff = priceCoeff;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return idSize == size.idSize && Float.compare(size.priceCoeff, priceCoeff) == 0 && Objects.equals(sizeName, size.sizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSize, priceCoeff, sizeName);
    }

    @Override
    public String toString() {
        return "Size{" +
                "idSize=" + idSize +
                ", priceCoeff=" + priceCoeff +
                ", sizeName='" + sizeName + '\'' +
                '}';
    }
}
