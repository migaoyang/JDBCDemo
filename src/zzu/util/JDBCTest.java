package zzu.util;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            // 注册驱动
            conn = JDBCUtil.getConn();

            //创建Statement对象
            st = conn.createStatement();


            //执行查询，得到结果集
            String sql = "select * from t_stu";
            rs = st.executeQuery(sql);

            //遍历结果
            while (rs.next()){
                System.out.println(rs.getString("id") + " "+ rs.getString("name") + " "
                        +rs.getString("age") + " " +rs.getString("gender"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("123456");
        }finally{
            //按照建立的逆序关闭资源 reverse-order
            JDBCUtil.release(conn, st, rs);
        }
    }

}
