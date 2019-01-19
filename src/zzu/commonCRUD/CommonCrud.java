package zzu.commonCRUD;

import org.junit.Test;
import zzu.domain.Tstu;
import zzu.util.JDBCUtil02;

import java.sql.*;

public class CommonCrud <T> {


    @Test
    public void testQuery(){

        Tstu tstu = query("select * from t_stu where id =?", new ResultSetHandler<Tstu>() {
            @Override
            public Tstu handle(ResultSet rs) {

                try {
                    Tstu tstu =null;
                    if (rs.next()){
                        tstu = new Tstu();
                        String name = rs.getString("name");
                        int age = rs.getInt("age");

                        tstu.setName(name);
                        tstu.setAge(age);
                    }
                    return tstu;
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                }

                return null;
            }
        } ,1);

        System.out.println(tstu.toString());





    }


    public <T> T query(String sql, ResultSetHandler handler , Object...args){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil02.getConn();
            ps = conn.prepareStatement(sql);

            ParameterMetaData metaData = ps.getParameterMetaData();

            int count = metaData.getParameterCount();

            for(int i = 0; i < count ; i++){
                ps.setObject(i+1 , args[i]);
            }

            ResultSet rs = ps.executeQuery();
            T t = (T) handler.handle(rs);
            return t;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

        return null;

    }






















    @Test
    public  void testUpdate(){

        update02("insert into t_stu values(null,?,?,?,? )", "CC",8,"nan","zz");
    }



    public void update02(String sql, Object...args){

        Connection conn = null;
        PreparedStatement ps = null;


        try {
            conn = JDBCUtil02.getConn();
            ps = conn.prepareStatement( sql);
            ParameterMetaData parameterMetaData = ps.getParameterMetaData();
            int count = parameterMetaData.getParameterCount();

            for(int i =0; i < count;i++){
                ps.setObject(i+1,args[i]);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil02.release(conn,ps);
        }


    }



    //通用增删改查
    public void update(String sql, Object...args){

        Connection conn = null;
        PreparedStatement ps = null;


        try {
            conn = JDBCUtil02.getConn();
            ps = conn.prepareStatement( sql);

            for(int i =0; i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil02.release(conn,ps);
        }


    }
}
