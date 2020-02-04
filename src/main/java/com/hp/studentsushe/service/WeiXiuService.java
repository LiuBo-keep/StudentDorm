package com.hp.studentsushe.service;

import com.hp.studentsushe.bean.WeiXiu;

public interface WeiXiuService {
    /**
     * 上传维修信息
     * @param weiXiu 封装信息对象
     * @return int
     */
    public int shang(WeiXiu weiXiu);
}
