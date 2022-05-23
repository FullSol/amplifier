package com.amplifier.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ImgPostRepositoryImpl implements ImgPostRepository {

    @Autowired
    private ImgPostRepository imgPostRepository;
}
