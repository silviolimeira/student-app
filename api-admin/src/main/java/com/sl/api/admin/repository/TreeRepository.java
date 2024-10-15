package com.sl.api.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sl.api.admin.entity.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {

}
