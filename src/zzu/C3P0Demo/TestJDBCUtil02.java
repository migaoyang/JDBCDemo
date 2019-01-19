package zzu.C3P0Demo;

import org.junit.Test;
import zzu.util.JDBCUtil02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCUtil02 {

    @Test
    public void test(){

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil02.getConn();
            String sql = "insert into t_stu values(null ,? , ? , ? ,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"xiaomi");
            ps.setInt(2,10);
            ps.setString(3,null);
            ps.setString(4,null);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            JDBCUtil02.release(conn,ps);
        }
    }

}
