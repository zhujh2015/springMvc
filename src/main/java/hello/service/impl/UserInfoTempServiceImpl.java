package hello.service.impl;

import hello.data.dao.IUserInfoTempDao;
import hello.data.entity.UserInfo;
import hello.service.IUserInfoTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/10.
 */
@Service("userInfoTempService")
public class UserInfoTempServiceImpl implements IUserInfoTempService {
    @Autowired
    private IUserInfoTempDao userInfoTempDao;

    @Override
    public String getUserNameByCode(String userCode) {
        return userInfoTempDao.getUserNameByCode(userCode);
    }

    @Override
    public Integer InsertUserInfoTemp(UserInfo userInfo) {
        return userInfoTempDao.InsertUserInfoTemp(userInfo);
    }
}
