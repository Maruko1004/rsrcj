package xyc.maruko.utils;

import xyc.maruko.entity.JdbcEntity;
import xyc.maruko.enums.JdbcEnum;
import xyc.maruko.enums.RespEnum;
import xyc.maruko.enums.SqlExecuteEnum;
import xyc.maruko.vo.ResponseVo;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据库信息录入实现层〉
 *
 * @author maruko
 * @date 2021/7/7 10:45
 * @since 1.0.0
 */

public class JdbcUtil {


    /**
     * 添加jdbc连接信息 注意区分两个配置差别
     *
     * @param baseJdbcEntity 初始化数据源
     * @param jdbcEntity     配置数据库信息
     * @return ResponseVo
     */
    public static ResponseVo addJdbc(JdbcEntity baseJdbcEntity, JdbcEntity jdbcEntity) {
        BaseJdbcUtil.executeInsert(baseJdbcEntity, SqlExecuteEnum.executeSql(baseJdbcEntity.getDriverClass(), 1), jdbcToList(jdbcEntity));
        return new ResponseVo(RespEnum.SUCCESS);
    }

    /**
     * 根据id查询数据库信息
     *
     * @param jdbcEntity 初始化数据源
     * @param id         编号
     * @return JdbcEntity
     */
    protected static JdbcEntity queryJdbcInfo(JdbcEntity jdbcEntity, Long id) {

        List<Map<String, Object>> mapList = BaseJdbcUtil.executeQuery(jdbcEntity, SqlExecuteEnum.executeSql(jdbcEntity.getDriverClass(), 2), Collections.singletonList(id));
        if (null != mapList && mapList.size() > 0) {
            //数据库连接一一对应关系，只取1
            Map<String, Object> map = mapList.get(0);
            return mapToJdbcEntity(jdbcEntity.getDriverClass(), map);
        }
        return null;
    }

    /**
     * 将map转换为JdbcEntity
     *
     * @param map      map
     * @param jdbcEnum 数据库类型
     * @return JdbcEntity
     */
    private static JdbcEntity mapToJdbcEntity(JdbcEnum jdbcEnum, Map<String, Object> map) {
        JdbcEntity jdbcEntity = new JdbcEntity();
        jdbcEntity.setId(Long.parseLong(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 3)).toString()));
        jdbcEntity.setDriverClass(JdbcEnum.getJdbcEnum(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 4)).toString()));
        jdbcEntity.setUrl(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 5)).toString());
        jdbcEntity.setUserName(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 6)).toString());
        jdbcEntity.setPassword(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 7)).toString());
        return jdbcEntity;
    }

    /**
     * 将实体转换为list
     *
     * @param jdbcEntity 数据库实体
     * @return List<Object>
     */
    private static List<Object> jdbcToList(JdbcEntity jdbcEntity) {
        if (null == jdbcEntity) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        //需要插入string字段
        list.add(jdbcEntity.getDriverClass().getDriverClass());
        list.add(jdbcEntity.getUrl());
        list.add(jdbcEntity.getUserName());
        list.add(jdbcEntity.getPassword());
        return list;
    }


}
