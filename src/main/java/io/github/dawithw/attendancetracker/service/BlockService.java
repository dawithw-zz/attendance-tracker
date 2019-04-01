package io.github.dawithw.attendancetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.dawithw.attendancetracker.domain.Block;
import io.github.dawithw.attendancetracker.repository.BlockRepository;

@Service
public class BlockService {
    
    @Autowired
    private BlockRepository blockRepository;
    
    public void saveBlock(Block block) {
        blockRepository.save(block);
    }

    public Block getByName(String blockName) {
        return blockRepository.getByName(blockName);
    }

    public Block getById(long id) {
        return blockRepository.findById(id).get();
    }
}