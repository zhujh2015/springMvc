package hello.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/10.
 */
public class UserInfo implements Serializable
{
    private int id;
    private String userName;
    private String userCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
