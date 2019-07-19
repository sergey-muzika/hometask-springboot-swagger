package com.sergey.hometask.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sergey.hometask.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

}