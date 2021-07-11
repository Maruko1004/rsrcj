package xyc.maruko.utils;

import xyc.maruko.entity.JdbcEntity;
import xyc.maruko.entity.ParamsEntity;
import xyc.maruko.entity.SqlEntity;
import xyc.maruko.enums.JdbcEnum;
import xyc.maruko.vo.ResponseVo;

import java.util.Collections;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试〉
 *
 * @author maruko
 * @date 2021/7/11 16:51
 * @since 1.0.0
 */

public class Test {
    public static void main(String[] args) {
//        mysqlInit();
//        mysqlAddJdbc();
//        mysqlAddSql();
//        mysqlAddParams();
//        mysqlQuery();
//        oracleInit();
//        oracleAddJdbc();
//        oracleAddSql();
//        oracleAddParams();
//        oracleQuery();
//        pgInit();
//        pgAddJdbc();
//        pgAddSql();
//        pgAddParams();
        pgQuery();
    }

    /**
     * pg查询
     */
    public static void pgQuery() {
        ResponseVo<?> responseVo = SqlUtil.executeSql(pgBaseJdbc(), 1L, Collections.singletonList(1L));
        Object data = responseVo.getData();
        System.out.println(data);
    }

    /**
     * pg参数添加
     */
    public static void pgAddParams() {
        ParamsEntity paramsEntity = new ParamsEntity();
        paramsEntity.setSqlId(1L);
        paramsEntity.setValue(1L);
        ParamsUtil.addParams(pgBaseJdbc(), paramsEntity);
    }

    /**
     * pg添加SQL语句
     */
    public static void pgAddSql() {
        SqlEntity sqlEntity = new SqlEntity();
        sqlEntity.setJdbcId(1L);
        sqlEntity.setSql("select * from sql_info where id=?");
        SqlUtil.addSql(pgBaseJdbc(), sqlEntity);
    }

    /**
     * 添加pg数据库连接信息
     */
    public static void pgAddJdbc() {
        JdbcUtil.addJdbc(pgBaseJdbc(), pgBaseJdbc());
    }


    /**
     * 实例化pg数据库
     *
     * @return
     */
    public static JdbcEntity pgBaseJdbc() {
        JdbcEntity jdbcEntity = new JdbcEntity();
        jdbcEntity.setDriverClass(JdbcEnum.POSTGRESQL);
        jdbcEntity.setUrl("jdbc:postgresql://172.16.121.219:5432/bigdata?currentSchema=dqyj_db");
        jdbcEntity.setUserName("postgres");
        jdbcEntity.setPassword("dbpg123");
        return jdbcEntity;
    }

    /**
     * pg测试
     */
    public static void pgInit() {
        InitUtil.init(pgBaseJdbc());
    }


    /**
     * oracle查询
     */
    public static void oracleQuery() {
        ResponseVo<?> responseVo = SqlUtil.executeSql(oracleBaseJdbc(), 1L, Collections.singletonList(1L));
        Object data = responseVo.getData();
        System.out.println(data);
    }

    /**
     * oracle参数添加
     */
    public static void oracleAddParams() {
        ParamsEntity paramsEntity = new ParamsEntity();
        paramsEntity.setSqlId(1L);
        paramsEntity.setValue(1L);
        ParamsUtil.addParams(oracleBaseJdbc(), paramsEntity);
    }

    /**
     * oracle添加SQL语句
     */
    public static void oracleAddSql() {
        SqlEntity sqlEntity = new SqlEntity();
        sqlEntity.setJdbcId(1L);
        sqlEntity.setSql("select * from SQL_INFO where ID=?");
        SqlUtil.addSql(oracleBaseJdbc(), sqlEntity);
    }

    /**
     * 添加oracle数据库连接信息
     */
    public static void oracleAddJdbc() {
        JdbcUtil.addJdbc(oracleBaseJdbc(), oracleBaseJdbc());
    }

    /**
     * 实例化oracle数据库
     *
     * @return
     */
    public static JdbcEntity oracleBaseJdbc() {
        JdbcEntity jdbcEntity = new JdbcEntity();
        jdbcEntity.setDriverClass(JdbcEnum.ORACLE);
        jdbcEntity.setUrl("jdbc:oracle:thin:@172.16.121.219:1521:ORCL");
        jdbcEntity.setUserName("nfdp");
        jdbcEntity.setPassword("123456");
        return jdbcEntity;
    }

    /**
     * oracle测试
     */
    public static void oracleInit() {
        InitUtil.init(oracleBaseJdbc());
    }

    /**
     * mysql查询
     */
    public static void mysqlQuery() {
        ResponseVo<?> responseVo = SqlUtil.executeSql(mysqlBaseJdbc(), 1L, Collections.singletonList(1L));
        Object data = responseVo.getData();
        System.out.println(data);
    }

    /**
     * mysql参数添加
     */
    public static void mysqlAddParams() {
        ParamsEntity paramsEntity = new ParamsEntity();
        paramsEntity.setSqlId(1L);
        paramsEntity.setValue(1L);
        ParamsUtil.addParams(mysqlBaseJdbc(), paramsEntity);
    }

    /**
     * mysql添加SQL语句
     */
    public static void mysqlAddSql() {
        SqlEntity sqlEntity = new SqlEntity();
        sqlEntity.setJdbcId(1L);
        sqlEntity.setSql("select * from sql_info where id=?");
        SqlUtil.addSql(mysqlBaseJdbc(), sqlEntity);
    }

    /**
     * 添加mysql数据库连接信息
     */
    public static void mysqlAddJdbc() {
        JdbcUtil.addJdbc(mysqlBaseJdbc(), mysqlBaseJdbc());
    }

    /**
     * 实例化MySQL数据库
     *
     * @return
     */
    public static JdbcEntity mysqlBaseJdbc() {
        JdbcEntity jdbcEntity = new JdbcEntity();
        jdbcEntity.setDriverClass(JdbcEnum.MYSQL8);
        jdbcEntity.setUrl("jdbc:mysql://localhost:3307/maruko?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&allowMultiQueries=true&useSSL=false");
        jdbcEntity.setUserName("root");
        jdbcEntity.setPassword("123456");
        return jdbcEntity;
    }

    /**
     * mysql测试
     */
    public static void mysqlInit() {
        InitUtil.init(mysqlBaseJdbc());
    }

}
