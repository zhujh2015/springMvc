import java.sql.*;

/**
 * Created by Administrator on 2018/1/10.
 */
public class jdbcTest
{
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String CONNECTIONURL="jdbc:mysql://192.168.1.46:3307/hospital";
    public static final String USERNAME="phhc";
    public static final String PASSWORD="q1w2e3";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            connection= DriverManager.getConnection(CONNECTIONURL,USERNAME,PASSWORD);
            String sql="select PatientName from zy_patientinfo where InterfaceID=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                System.out.println(resultSet.getString("PatientName"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            if(resultSet!=null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}
