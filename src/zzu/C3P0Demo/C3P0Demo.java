package zzu.C3P0Demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import zzu.commonCRUD.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class C3P0Demo {
    @Test
    public void testP3C0(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();


        Connection conn = null;
        PreparedStatement ps = null;

        try {



            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost/stus?useUnicode=true&characterEncoding=utf-8");
            dataSource.setUser("root");
            dataSource.setPassword("123456");

            conn = dataSource.getConnection();
            String sql = "insert into t_stu values(null ,? , ? ,? ,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"admin");
            ps.setInt(2,18);
            ps.setString(3,"nan");
            ps.setString(4,"郑州");


            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            JDBCUtil.release(conn,ps);
        }

    }


}
