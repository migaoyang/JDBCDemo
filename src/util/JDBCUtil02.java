package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCUtil02 {

    static ComboPooledDataSource dataSource = null;

    static {
        dataSource =  new ComboPooledDataSource();
    }

    static String driverClass = null;
    static String url = null;
    static String user = null;
    static String password = null;



    /**
     * 获取连接对象
     * @return Connection
     */
    public static Connection getConn() throws SQLException {


        return dataSource.getConnection();
    }

    public static DataSource getDataSource(){
        return dataSource;
    }


    public static void release(Connection conn,Statement st,ResultSet rs){
        clossRs(rs);
        clossSt(st);
        clossConn(conn);
    }

    public static void release(Connection conn,PreparedStatement ps){

        clossConn(conn);
        clossPs(ps);
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


    private static void clossPs(PreparedStatement ps){
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
