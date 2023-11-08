package com.fol.libraryrecord.microservice;

import org.springframework.stereotype.Service;

@Service
public class StubUserMicroservice implements IUserMicroservice {
    @Override
    public boolean doesUserHavePermission(Long userId) {
        return true;
    }
}
