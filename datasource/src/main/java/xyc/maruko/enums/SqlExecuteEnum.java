package xyc.maruko.enums;

/**
 * 〈一句话功能简述〉<br>
 * 〈执行sql〉
 *
 * @author maruko
 * @date 2021/7/9 16:58
 * @since 1.0.0
 */

public enum SqlExecuteEnum {
    /**
     * jdbc_info 表mysql5对应字段
     */
    JDBC_MYSQL5_INSERT_SQL(JdbcEnum.MYSQL5, 1, "INSERT INTO jdbc_info(drive_class, url, user_name, password) VALUES (?, ?, ?, ?)"),
    JDBC_MYSQL5_QUERY_BY_ID_SQL(JdbcEnum.MYSQL5, 2, "select * from jdbc_info where id=?"),
    JDBC_MYSQL5_ID(JdbcEnum.MYSQL5, 3, "id"),
    JDBC_MYSQL5_DRIVER_CLASS(JdbcEnum.MYSQL5, 4, "drive_class"),
    JDBC_MYSQL5_URL(JdbcEnum.MYSQL5, 5, "url"),
    JDBC_MYSQL5_USER_NAME(JdbcEnum.MYSQL5, 6, "user_name"),
    JDBC_MYSQL5_PASSWORD(JdbcEnum.MYSQL5, 7, "password"),


    /**
     * sql_info 表mysql5对应字段
     */
    SQL_MYSQL5_INSERT_SQL(JdbcEnum.MYSQL5, 8, "INSERT INTO sql_info( jdbc_id,`sql`) VALUES (?, ?)"),
    SQL_MYSQL5_EXECUTE_SQL(JdbcEnum.MYSQL5, 9, "select * from sql_info where id=?"),
    SQL_MYSQL5_ID(JdbcEnum.MYSQL5, 10, "id"),
    SQL_MYSQL5_JDBC_ID(JdbcEnum.MYSQL5, 11, "jdbc_id"),
    SQL_MYSQL5_SQL(JdbcEnum.MYSQL5, 12, "sql"),


    /**
     * params_info表mysql5对应字段
     */
    PARAMS_MYSQL5_INSERT_SQL(JdbcEnum.MYSQL5, 13, "INSERT INTO params_info(sql_id, name, value, type) VALUES ( ?, ?, ?, ?)"),
    PARAMS_MYSQL5_QUERY_BY_SQL_ID_SQL(JdbcEnum.MYSQL5, 14, "select * from params_info where sql_id=?"),
    PARAMS_MYSQL5_ID(JdbcEnum.MYSQL5, 15, "id"),
    PARAMS_MYSQL5_SQL_ID(JdbcEnum.MYSQL5, 16, "sql_id"),
    PARAMS_MYSQL5_NAME(JdbcEnum.MYSQL5, 17, "name"),
    PARAMS_MYSQL5_VALUE(JdbcEnum.MYSQL5, 18, "value"),
    PARAMS_MYSQL5_TYPE(JdbcEnum.MYSQL5, 19, "type"),

    /**
     * jdbc_info 表mysql8对应字段
     */
    JDBC_MYSQL8_INSERT_SQL(JdbcEnum.MYSQL8, 1, "INSERT INTO jdbc_info(drive_class, url, user_name, password) VALUES (?, ?, ?, ?)"),
    JDBC_MYSQL8_QUERY_BY_ID_SQL(JdbcEnum.MYSQL8, 2, "select * from jdbc_info where id=?"),
    JDBC_MYSQL8_ID(JdbcEnum.MYSQL8, 3, "id"),
    JDBC_MYSQL8_DRIVER_CLASS(JdbcEnum.MYSQL8, 4, "drive_class"),
    JDBC_MYSQL8_URL(JdbcEnum.MYSQL8, 5, "url"),
    JDBC_MYSQL8_USER_NAME(JdbcEnum.MYSQL8, 6, "user_name"),
    JDBC_MYSQL8_PASSWORD(JdbcEnum.MYSQL8, 7, "password"),


    /**
     * sql_info 表mysql8对应字段
     */
    SQL_MYSQL8_INSERT_SQL(JdbcEnum.MYSQL8, 8, "INSERT INTO sql_info( jdbc_id,`sql`) VALUES (?, ?)"),
    SQL_MYSQL8_EXECUTE_SQL(JdbcEnum.MYSQL8, 9, "select * from sql_info where id=?"),
    SQL_MYSQL8_ID(JdbcEnum.MYSQL8, 10, "id"),
    SQL_MYSQL8_JDBC_ID(JdbcEnum.MYSQL8, 11, "jdbc_id"),
    SQL_MYSQL8_SQL(JdbcEnum.MYSQL8, 12, "sql"),


    /**
     * params_info表mysql8对应字段
     */
    PARAMS_MYSQL8_INSERT_SQL(JdbcEnum.MYSQL8, 13, "INSERT INTO params_info(sql_id, name, value, type) VALUES ( ?, ?, ?, ?)"),
    PARAMS_MYSQL8_QUERY_BY_SQL_ID_SQL(JdbcEnum.MYSQL8, 14, "select * from params_info where sql_id=?"),
    PARAMS_MYSQL8_ID(JdbcEnum.MYSQL8, 15, "id"),
    PARAMS_MYSQL8_SQL_ID(JdbcEnum.MYSQL8, 16, "sql_id"),
    PARAMS_MYSQL8_NAME(JdbcEnum.MYSQL8, 17, "name"),
    PARAMS_MYSQL8_VALUE(JdbcEnum.MYSQL8, 18, "value"),
    PARAMS_MYSQL8_TYPE(JdbcEnum.MYSQL8, 19, "type"),


    /**
     * jdbc_info表 oracle对应字段
     */
    JDBC_ORACLE_INSERT_SQL(JdbcEnum.ORACLE, 1, "INSERT INTO JDBC_INFO(ID,DRIVE_CLASS, URL, USER_NAME, PASSWORD) VALUES (JDBC_SEQ.nextval,?, ?, ?, ?)"),
    JDBC_ORACLE_QUERY_BY_ID_SQL(JdbcEnum.ORACLE, 2, "select * from JDBC_INFO where ID=?"),
    JDBC_ORACLE_ID(JdbcEnum.ORACLE, 3, "ID"),
    JDBC_ORACLE_DRIVER_CLASS(JdbcEnum.ORACLE, 4, "DRIVE_CLASS"),
    JDBC_ORACLE_URL(JdbcEnum.ORACLE, 5, "URL"),
    JDBC_ORACLE_USER_NAME(JdbcEnum.ORACLE, 6, "USER_NAME"),
    JDBC_ORACLE_PASSWORD(JdbcEnum.ORACLE, 7, "PASSWORD"),


    /**
     * sql_info表 oracle对应字段
     */
    SQL_ORACLE_INSERT_SQL(JdbcEnum.ORACLE, 8, "INSERT INTO SQL_INFO(ID,JDBC_ID, SQL) VALUES (SQL_SEQ.nextval,?, ?)"),
    SQL_ORACLE_EXECUTE_SQL(JdbcEnum.ORACLE, 9, "select * from SQL_INFO where ID=?"),
    SQL_ORACLE_ID(JdbcEnum.ORACLE, 10, "ID"),
    SQL_ORACLE_JDBC_ID(JdbcEnum.ORACLE, 11, "JDBC_ID"),
    SQL_ORACLE_SQL(JdbcEnum.ORACLE, 12, "SQL"),


    /**
     * params_info表oracle对应字段
     */
    PARAMS_ORACLE_INSERT_SQL(JdbcEnum.ORACLE, 13, "INSERT INTO PARAMS_INFO(ID,SQL_ID, NAME, VALUE, TYPE) VALUES (PARAMS_SEQ.nextval, ?, ?, ?, ?)"),
    PARAMS_ORACLE_QUERY_BY_SQL_ID_SQL(JdbcEnum.ORACLE, 14, "select * from PARAMS_INFO where SQL_ID=?"),
    PARAMS_ORACLE_ID(JdbcEnum.ORACLE, 15, "ID"),
    PARAMS_ORACLE_SQL_ID(JdbcEnum.ORACLE, 16, "SQL_ID"),
    PARAMS_ORACLE_NAME(JdbcEnum.ORACLE, 17, "NAME"),
    PARAMS_ORACLE_VALUE(JdbcEnum.ORACLE, 18, "VALUE"),
    PARAMS_ORACLE_TYPE(JdbcEnum.ORACLE, 19, "TYPE"),


    /**
     * jdbc_info 表postgresql对应字段
     */
    JDBC_POSTGRESQL_INSERT_SQL(JdbcEnum.POSTGRESQL, 1, "INSERT INTO jdbc_info(drive_class, url, user_name, password) VALUES (?, ?, ?, ?)"),
    JDBC_POSTGRESQL_QUERY_BY_ID_SQL(JdbcEnum.POSTGRESQL, 2, "select * from jdbc_info where id=?"),
    JDBC_POSTGRESQL_ID(JdbcEnum.POSTGRESQL, 3, "id"),
    JDBC_POSTGRESQL_DRIVER_CLASS(JdbcEnum.POSTGRESQL, 4, "drive_class"),
    JDBC_POSTGRESQL_URL(JdbcEnum.POSTGRESQL, 5, "url"),
    JDBC_POSTGRESQL_USER_NAME(JdbcEnum.POSTGRESQL, 6, "user_name"),
    JDBC_POSTGRESQL_PASSWORD(JdbcEnum.POSTGRESQL, 7, "password"),


    /**
     * sql_info 表postgresql对应字段
     */
    SQL_POSTGRESQL_INSERT_SQL(JdbcEnum.POSTGRESQL, 8, "INSERT INTO sql_info( jdbc_id,sql) VALUES (?, ?)"),
    SQL_POSTGRESQL_EXECUTE_SQL(JdbcEnum.POSTGRESQL, 9, "select * from sql_info where id=?"),
    SQL_POSTGRESQL_ID(JdbcEnum.POSTGRESQL, 10, "id"),
    SQL_POSTGRESQL_JDBC_ID(JdbcEnum.POSTGRESQL, 11, "jdbc_id"),
    SQL_POSTGRESQL_SQL(JdbcEnum.POSTGRESQL, 12, "sql"),


    /**
     * params_info表postgresql对应字段
     */
    PARAMS_POSTGRESQL_INSERT_SQL(JdbcEnum.POSTGRESQL, 13, "INSERT INTO params_info(sql_id, name, value, type) VALUES ( ?, ?, ?, ?)"),
    PARAMS_POSTGRESQL_QUERY_BY_SQL_ID_SQL(JdbcEnum.POSTGRESQL, 14, "select * from params_info where sql_id=?"),
    PARAMS_POSTGRESQL_ID(JdbcEnum.POSTGRESQL, 15, "id"),
    PARAMS_POSTGRESQL_SQL_ID(JdbcEnum.POSTGRESQL, 16, "sql_id"),
    PARAMS_POSTGRESQL_NAME(JdbcEnum.POSTGRESQL, 17, "name"),
    PARAMS_POSTGRESQL_VALUE(JdbcEnum.POSTGRESQL, 18, "value"),
    PARAMS_POSTGRESQL_TYPE(JdbcEnum.POSTGRESQL, 19, "type"),

    ;

    private JdbcEnum jdbcEnum;
    private Integer order;
    private String sql;

    public JdbcEnum getJdbcEnum() {
        return jdbcEnum;
    }

    public void setJdbcEnum(JdbcEnum jdbcEnum) {
        this.jdbcEnum = jdbcEnum;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    SqlExecuteEnum(JdbcEnum jdbcEnum, Integer order, String sql) {
        this.jdbcEnum = jdbcEnum;
        this.order = order;
        this.sql = sql;
    }

    public static String executeSql(JdbcEnum jdbcEnum, Integer order) {
        for (SqlExecuteEnum s : SqlExecuteEnum.values()) {

            if (s.getOrder().equals(order)) {

                if (s.getJdbcEnum().equals(jdbcEnum)) {
                    return s.getSql();
                }

            }
        }
        return null;
    }
}
