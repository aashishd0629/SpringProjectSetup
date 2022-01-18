package com.npg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.npg.dao.ILevelDao;
import com.npg.dto.LevelDTO;
import com.npg.exception.CustomException;
import com.npg.model.Label;
import com.npg.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private ILevelDao levelDao;

	@Override
	public void createLevel(LevelDTO request) {
		Label label = new Label();
		label.setName(request.getName());

		this.levelDao.save(label);
	}

	@Override
	public void updateLevel(LevelDTO request) {
		Integer levelId = request.getId();
		Optional<Label> levelOPT = levelDao.findById(levelId);
		
		if(!levelOPT.isPresent()) {
			throw new CustomException(HttpStatus.NOT_FOUND,"Bhatte Chor");
		}

			Label levelDB = levelOPT.get();
			levelDB.setName(request.getName());
			this.levelDao.save(levelDB);
		}


	@Override
	public List<LevelDTO> getLevels() {
		
		List<Label> levelDBlist=levelDao.findAll();
		
		List<LevelDTO> dtolist=new ArrayList<>();
		for(Label levelDB:levelDBlist) {
			LevelDTO dto =new LevelDTO();
			dto.setId(levelDB.getId());
			dto.setName(levelDB.getName());
			
			dtolist.add(dto);
			
		}
		return dtolist;
	}
	public void deleteLevel(Integer levelID) {
		
Optional<Label> levelOPT = levelDao.findById(levelID);
		
		if(!levelOPT.isPresent()) {
			throw new CustomException(HttpStatus.NOT_FOUND,"Bhatte Chor");
		}

		Label levelDB=levelOPT.get();
		levelDao.delete(levelDB);
			
		
		
	}
}
