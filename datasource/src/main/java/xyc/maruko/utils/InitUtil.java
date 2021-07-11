package xyc.maruko.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import xyc.maruko.config.JdbcConfig;
import xyc.maruko.entity.JdbcEntity;
import xyc.maruko.enums.JdbcEnum;

import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.List;
import java.util.Map;


/**
 * 〈一句话功能简述〉<br>
 * 〈初始化实现类〉
 *
 * @author maruko
 * @date 2021/7/7 10:26
 * @since 1.0.0
 */

public class InitUtil {

    /**
     * 初始化数据库
     *
     * @param jdbcEntity 数据库连接信息
     */
    public static void init(JdbcEntity jdbcEntity) {
        try {

            Connection conn = JdbcConfig.getConnection(jdbcEntity);
            ScriptRunner runner = new ScriptRunner(conn);
            //设置字符集,不然中文乱码插入错误
            Resources.setCharset(Charset.forName("UTF-8"));
            //设置是否输出日志
            runner.setLogWriter(null);
            // 从class目录下直接读取
            String filePath;
            if (JdbcEnum.MYSQL8.equals(jdbcEntity.getDriverClass()) || JdbcEnum.MYSQL5.equals(jdbcEntity.getDriverClass())) {
                filePath = "mysql/";
            } else if (JdbcEnum.ORACLE.equals(jdbcEntity.getDriverClass())) {
                filePath = "oracle/";
                //oracle 不存在drop if exist
                dropTableAndSeqOfOracle(jdbcEntity);
            } else {
                filePath = "postgresql/";
            }

            Reader readJdbcInfo = Resources.getResourceAsReader(filePath + "jdbc_info.sql");
            Reader readParamsInfo = Resources.getResourceAsReader(filePath + "params_info.sql");
            Reader readSqlInfo = Resources.getResourceAsReader(filePath + "sql_info.sql");

            runner.runScript(readJdbcInfo);
            runner.runScript(readParamsInfo);
            runner.runScript(readSqlInfo);

            runner.closeConnection();
            conn.close();
            System.out.println("sql脚本执行完毕");
        } catch (Exception e) {
            System.out.println("sql脚本执行发生异常");
            throw new RuntimeException("sql脚本执行发生异常");
        }
    }

    /**
     * 查询表是否存在sql
     */
    private static final String TABLE_SQL = "select count(0) num  from user_tables where table_name = ";

    /**
     * 删除表
     */
    private static final String DROP_TABLE_SQL = "DROP TABLE ";

    /**
     * 数量字段
     */
    private static final String NUM = "NUM";

    /**
     * 查询序列是否存在sql
     */
    private static final String SEQUENCE_SQL = "select  count(0) num  from  user_sequences  where   sequence_name= ";

    /**
     * 删除序列
     */
    private static final String DROP_SEQUENCE_SQL = "DROP SEQUENCE ";

    /**
     * Oracle查询表或者序列是否存在
     *
     * @param jdbcEntity 数据库连接
     * @param sql        查询sql
     * @param tableName  表名
     * @param
     * @return
     */
    private static Boolean tableOrSeqIsExist(JdbcEntity jdbcEntity, String sql, String tableName) {
        List<Map<String, Object>> mapList = BaseJdbcUtil.executeQuery(jdbcEntity, sql + tableName, null);
        if (null == mapList || mapList.size() == 0) {
            return false;
        }
        Map<String, Object> objectMap = mapList.get(0);
        Integer num = Integer.parseInt(objectMap.get(NUM).toString());
        if (num == 0) {
            return false;
        }
        return true;
    }

    /**
     * Oracle删除表或者序列
     *
     * @param jdbcEntity 数据库连接
     * @param tableName  表名
     */
    private static void dropTableOrSeq(JdbcEntity jdbcEntity, String sql, String tableName) {
        BaseJdbcUtil.executeInsert(jdbcEntity, sql + tableName, null);
    }

    /**
     * r删除表或者序列 如果存在
     *
     * @param jdbcEntity 数据库连接
     * @param querySql   查询sql
     * @param dropSql    删除sql
     * @param tableName  表名
     */
    private static void dropTableOrSeqIfExist(JdbcEntity jdbcEntity, String querySql, String dropSql, String tableName) {
        if (tableOrSeqIsExist(jdbcEntity, querySql, tableName)) {
            //删除时表名不需要‘’替换
            tableName = tableName.replace("'", "");
            dropTableOrSeq(jdbcEntity, dropSql, tableName);
        }
    }

    /**
     * 删除表和序列
     *
     * @param jdbcEntity
     */
    private static void dropTableAndSeqOfOracle(JdbcEntity jdbcEntity) {
        //删除jdbc_info表
        dropTableOrSeqIfExist(jdbcEntity, TABLE_SQL, DROP_TABLE_SQL, "'JDBC_INFO'");
        //删除sql_info表
        dropTableOrSeqIfExist(jdbcEntity, TABLE_SQL, DROP_TABLE_SQL, "'SQL_INFO'");
        //删除params_info
        dropTableOrSeqIfExist(jdbcEntity, TABLE_SQL, DROP_TABLE_SQL, "'PARAMS_INFO'");
        //删除序列jdbc_seq
        dropTableOrSeqIfExist(jdbcEntity, SEQUENCE_SQL, DROP_SEQUENCE_SQL, "'JDBC_SEQ'");
        //删除序列sql_seq
        dropTableOrSeqIfExist(jdbcEntity, SEQUENCE_SQL, DROP_SEQUENCE_SQL, "'SQL_SEQ'");
        //删除序列params_seq
        dropTableOrSeqIfExist(jdbcEntity, SEQUENCE_SQL, DROP_SEQUENCE_SQL, "'PARAMS_SEQ'");
    }

}
