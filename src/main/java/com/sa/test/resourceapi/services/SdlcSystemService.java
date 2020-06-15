package com.sa.test.resourceapi.services;

import com.sa.test.resourceapi.entities.SdlcSystem;
import com.sa.test.resourceapi.exceptions.NotFoundException;

public interface SdlcSystemService {

    SdlcSystem getSdlcSytem(long id) throws NotFoundException;
    SdlcSystem createSdlcSystem(SdlcSystem sdlcSystem);
    SdlcSystem getOrCreateSdlcSystem(SdlcSystem sdlcSystem);
}
