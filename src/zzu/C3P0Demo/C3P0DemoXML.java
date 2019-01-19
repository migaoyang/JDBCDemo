package zzu.C3P0Demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import zzu.commonCRUD.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class C3P0DemoXML {

    @Test
    public void testC3P0(){


        Connection conn = null;
        PreparedStatement ps = null;

        try {

            ComboPooledDataSource dataSource = new ComboPooledDataSource();

            conn = dataSource.getConnection();
            String sql = "insert into t_stu values(null ,? , ? ,? ,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"admin");
            ps.setInt(2,18);
            ps.setString(3,"nv");
            ps.setString(4,"zz");


            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            JDBCUtil.release(conn,ps);
        }

    }
}
