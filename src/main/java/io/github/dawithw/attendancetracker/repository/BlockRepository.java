package io.github.dawithw.attendancetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.dawithw.attendancetracker.domain.Block;

@Repository
public interface BlockRepository extends CrudRepository<Block,Long> {

    // Query
	Block getByName(String blockName);

}