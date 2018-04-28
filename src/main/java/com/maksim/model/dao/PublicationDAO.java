package com.maksim.model.dao;

import com.maksim.domain.Publication;

import java.util.List;

/**
 * Created by Максим on 09/Apr/18.
 */
public interface PublicationDAO {
    List<Integer> findAllId();
    List<Publication> findAll();
    Publication findById(int id);
    Publication findByTitle(String title);
    boolean addPublication(Publication Publication);
}
