package zzu.util;

import org.junit.Test;
import zzu.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDemo {
    @Test
    public void testQuery(){
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

    @Test
    public void testInsert(){
        {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;

            try {

                // 注册驱动
                conn = JDBCUtil.getConn();

                //创建Statement对象
                st = conn.createStatement();


                //执行查询，得到结果集
//            String sql = "select * from t_stu";
                String sql = "insert  into t_stu values(null,'扬',18,'男','洛阳')";
                int result = st.executeUpdate(sql);


                //遍历结果
                if(result > 0){
                    System.out.println("插入成功！");

                }else{
                    System.out.println("插入失败！");
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
}
