package com.open.user.dal.mapper;

import com.open.user.dal.entity.UserInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
}
