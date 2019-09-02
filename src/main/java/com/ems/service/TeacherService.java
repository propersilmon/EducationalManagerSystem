package com.ems.service;

import com.ems.entity.SysEmployee;

public interface TeacherService {

    SysEmployee queryByUsername(int username);
}
