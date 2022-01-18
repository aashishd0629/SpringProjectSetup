package com.npg.service;

import java.util.List;

import com.npg.dto.LevelDTO;

public interface StudentService {
	void createLevel(LevelDTO request);

	void updateLevel(LevelDTO request);

	List<LevelDTO> getLevels();

	void deleteLevel(Integer levelID);
	
	
}
