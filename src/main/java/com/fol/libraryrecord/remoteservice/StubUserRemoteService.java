package com.fol.libraryrecord.remoteservice;

import org.springframework.stereotype.Service;

@Service
public class StubUserRemoteService implements IUserRemoteService {
    @Override
    public boolean doesUserHavePermission(Long userId) {
        return true;
    }
}
