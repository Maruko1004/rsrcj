package xyc.maruko.entity;

import lombok.Data;
import xyc.maruko.enums.JdbcEnum;

import javax.validation.constraints.NotNull;

/**
 * 〈一句话功能简述〉<br>
 * 〈抽象实体类 默认数据源 初始化数据表结构所需数据源〉
 *
 * @author maruko
 * @date 2021/7/7 11:33
 * @since 1.0.0
 */
@Data
public class JdbcEntity {
    /**
     * 序号
     */
    public Long id;

    /**
     * 连接驱动
     */
    @NotNull(message = "连接驱动不能为空")
    public JdbcEnum driverClass;

    /**
     * 连接路径
     */
    @NotNull(message = "连接路径不能为空,需要配置默认schema")
    public String url;

    /**
     * 登录用户
     */
    @NotNull(message = "登录用户不能为空")
    public String userName;

    /**
     * 登录密码
     */
    @NotNull(message = "登录密码不能为空")
    public String password;

    public JdbcEntity() {
    }

    public JdbcEntity(JdbcEnum driverClass, String url, String userName, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public JdbcEntity(Long id, JdbcEnum driverClass, String url, String userName, String password) {
        this.id = id;
        this.driverClass = driverClass;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
}
