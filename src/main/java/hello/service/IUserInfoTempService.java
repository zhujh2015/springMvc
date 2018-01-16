package hello.service;

import hello.data.entity.UserInfo;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/10.
 */
@Component
public interface IUserInfoTempService
{
    public String getUserNameByCode(String userCode);
    public Integer InsertUserInfoTemp(UserInfo userInfo);
}
