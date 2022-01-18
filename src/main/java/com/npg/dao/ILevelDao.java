package com.npg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npg.model.Label;

public interface ILevelDao extends JpaRepository<Label, Integer> {

}
