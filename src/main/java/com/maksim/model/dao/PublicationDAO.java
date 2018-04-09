package com.maksim.model.dao;

import com.maksim.domain.Publication;

import java.util.List;

/**
 * Created by Максим on 09/Apr/18.
 */
public interface PublicationDAO {
    List<Publication> findAll();
    Publication findByName(String name);
    boolean addPublication(Publication Publication);
}
