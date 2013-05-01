package com.zenjava.community.service;

import com.zenjava.community.service.data.SystemInfoDetail;
import com.zenjava.community.service.data.SystemSetupRequest;

public interface SystemService {

    void setupSystem(SystemSetupRequest request);

    SystemInfoDetail getSystemInfo();
}
