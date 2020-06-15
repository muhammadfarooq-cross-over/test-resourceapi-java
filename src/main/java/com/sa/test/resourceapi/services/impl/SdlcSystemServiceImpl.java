package com.sa.test.resourceapi.services.impl;

import com.sa.test.resourceapi.entities.Project;
import com.sa.test.resourceapi.entities.ProjectRepository;
import com.sa.test.resourceapi.entities.SdlcSystem;
import com.sa.test.resourceapi.entities.SdlcSystemRepository;
import com.sa.test.resourceapi.exceptions.NotFoundException;
import com.sa.test.resourceapi.services.ProjectService;
import com.sa.test.resourceapi.services.SdlcSystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SdlcSystemServiceImpl implements SdlcSystemService {
	private final SdlcSystemRepository sdlcSystemRepository;

	@Override
	public SdlcSystem getSdlcSytem(long id) throws NotFoundException {
		return sdlcSystemRepository.findById(id).orElseThrow(() -> new NotFoundException(SdlcSystem.class, id));
	}

	@Override
	public SdlcSystem createSdlcSystem(SdlcSystem sdlcSystem) {
		if (sdlcSystem.getBaseUrl() == null) {
			sdlcSystem.setBaseUrl("http://localhost/test");
		}
		sdlcSystem.setCreatedDate(Instant.now());
		sdlcSystem.setLastModifiedDate(Instant.now());
		return sdlcSystemRepository.save(sdlcSystem);
	}

	@Override
	public SdlcSystem getOrCreateSdlcSystem(SdlcSystem sdlcSystem) {
		SdlcSystem sdlcSystemFromDB;

		try {
			sdlcSystemFromDB = this.getSdlcSytem(sdlcSystem.getId());
		} catch (NotFoundException notFoundException) {
			sdlcSystemFromDB = this.createSdlcSystem(sdlcSystem);
		}
		return sdlcSystemFromDB;
	}
}
