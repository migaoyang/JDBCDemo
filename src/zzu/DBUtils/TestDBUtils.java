package zzu.DBUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class TestDBUtils {

    @Test
    public void testInsert() throws SQLException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);

        queryRunner.update("insert into t_stu values(null,?,?,?,?)","aa",10,"nan","zz");

    }
}
