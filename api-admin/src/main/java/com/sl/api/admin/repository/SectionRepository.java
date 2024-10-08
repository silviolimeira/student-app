package com.sl.api.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sl.api.admin.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
