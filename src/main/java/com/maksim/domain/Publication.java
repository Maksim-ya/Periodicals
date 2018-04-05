package com.maksim.domain;

import java.math.BigDecimal;

/**
 * Created by User on 05/04/2018.
 */
public class Publication {
    private int publicationId;
    private String title;
    private BigDecimal price;
    private String type;
    private int edition;

    public Publication() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;

        Publication that = (Publication) o;

        if (publicationId != that.publicationId) return false;
        if (edition != that.edition) return false;
        if (!title.equals(that.title)) return false;
        if (!price.equals(that.price)) return false;
        return type.equals(that.type);

    }

    @Override
    public int hashCode() {
        int result = publicationId;
        result = 31 * result + title.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + edition;
        return result;
    }

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
