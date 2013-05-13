package com.zenjava.community.service.impl.helper;

import com.zenjava.community.service.data.exception.SystemNotSetupException;
import com.zenjava.community.service.impl.entity.SystemInfo;
import com.zenjava.community.service.impl.repository.SystemInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@Service
public class SystemInfoHelper {

    private static final Logger log = LoggerFactory.getLogger(SystemInfoHelper.class);

    @Autowired private SystemInfoRepository systemInfoRepository;

    public SystemInfo getSystemInfo() throws SystemNotSetupException {
        Iterator<SystemInfo> all = systemInfoRepository.findAll().iterator();
        if (all.hasNext()) {
            return all.next();
        } else {
            throw new SystemNotSetupException("The system setup process has not been run yet");
        }
    }

    public String getBaseUrl() {
        return getSystemInfo().getBaseUrl();
    }

    public String buildUrl(String relativePath) {
        return getBaseUrl() + relativePath;
    }

    @Transactional(readOnly = false)
    public void saveSystemInfo(SystemInfo systemInfo) {
        systemInfoRepository.save(systemInfo);
    }
}
