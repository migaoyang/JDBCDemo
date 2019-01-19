package zzu.commonCRUD;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass = null;
    static String url = null;
    static String user = null;
    static String password = null;

    static{
        try {
            //建立一个配置对象
            Properties properties = new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //导入输入流
            properties.load(is);
            //读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * 获取连接对象
     * @return Connection
     */
    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 可以不用
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return conn;
    }


    public static void release(Connection conn,Statement st,ResultSet rs){
        clossRs(rs);
        clossSt(st);
        clossConn(conn);
    }


    public static void release(Connection conn,PreparedStatement ps ){
        clossConn(conn);
        clossPS(ps);
    }

    private static void clossRs(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                rs = null;
            }
        }
    }

    private static void clossSt(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                st = null;
            }
        }
    }

    private static void clossConn(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                conn = null;
            }
        }
    }

    private static void clossPS(PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                ps = null;
            }
        }
    }

}
