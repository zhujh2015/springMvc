package hello.data.dao;

import hello.data.entity.UserInfo;

/**
 * Created by Administrator on 2018/1/10.
 */
public interface IUserInfoTempDao
{
    public String getUserNameByCode(String userCode);
    public Integer InsertUserInfoTemp(UserInfo userInfo);
}
