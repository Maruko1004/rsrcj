package xyc.maruko.enums;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据库驱动枚举〉
 *
 * @author maruko
 * @date 2021/7/6 16:17
 * @since 1.0.0
 */

public enum JdbcEnum {
    /**
     * MYSQL 版本5
     */
    MYSQL5("com.mysql.jdbc.Driver"),
    /**
     * MYSQL 版本8
     */
    MYSQL8("com.mysql.cj.jdbc.Driver"),
    /**
     * ORACLE
     */
    ORACLE("oracle.jdbc.driver.OracleDriver"),
    /**
     * PostgreSQL
     */
    POSTGRESQL("org.postgresql.Driver");

    private String driverClass;

    JdbcEnum(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public static Boolean getDriverClassIsSet(JdbcEnum driverClass) {
        for (JdbcEnum c : JdbcEnum.values()) {
            if (c.equals(driverClass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取枚举
     *
     * @param driverClass
     * @return
     */
    public static JdbcEnum getJdbcEnum(String driverClass) {
        for (JdbcEnum c : JdbcEnum.values()) {
            if (c.getDriverClass().equals(driverClass)) {
                return c;
            }
        }
        return null;
    }

}
