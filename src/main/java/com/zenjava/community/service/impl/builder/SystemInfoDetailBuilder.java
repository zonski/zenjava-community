package com.zenjava.community.service.impl.builder;

import com.zenjava.community.service.data.SystemInfoDetail;
import com.zenjava.community.service.impl.entity.SystemInfo;
import org.springframework.stereotype.Service;

@Service
public class SystemInfoDetailBuilder extends AbstractBuilder<SystemInfo, SystemInfoDetail> {

    @Override
    protected SystemInfoDetail buildBean(SystemInfo entity) {
        return new SystemInfoDetail(
                entity.getId(),
        		entity.getName(),
                entity.getDescription()
        );
    }
}
