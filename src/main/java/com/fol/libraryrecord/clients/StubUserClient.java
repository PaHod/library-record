package com.fol.libraryrecord.clients;

import org.springframework.stereotype.Service;

@Service
public class StubUserClient implements IUserClient {

    @Override
    public boolean doesUserHavePermission(Long userId) {
        return true;
    }
}
