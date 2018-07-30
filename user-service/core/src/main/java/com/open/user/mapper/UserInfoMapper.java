package com.open.user.mapper;

import com.open.user.entity.po.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
}
