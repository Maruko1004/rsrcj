package xyc.maruko.utils;

import xyc.maruko.entity.JdbcEntity;
import xyc.maruko.entity.SqlEntity;
import xyc.maruko.enums.JdbcEnum;
import xyc.maruko.enums.RespEnum;
import xyc.maruko.enums.SqlExecuteEnum;
import xyc.maruko.vo.ResponseVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈SQL信息录入实现层〉
 *
 * @author maruko
 * @date 2021/7/7 10:46
 * @since 1.0.0
 */

public class SqlUtil {

    /**
     * 添加sql信息
     *
     * @param jdbcEntity 初始化数据源
     * @param sqlEntity  SQL实体
     * @return ResponseVo
     */
    public static ResponseVo addSql(JdbcEntity jdbcEntity, SqlEntity sqlEntity) {
        BaseJdbcUtil.executeInsert(jdbcEntity, SqlExecuteEnum.executeSql(jdbcEntity.getDriverClass(), 8), sqlToList(sqlEntity));
        return new ResponseVo(RespEnum.SUCCESS);
    }

    /**
     * 执行SQL参数需要在数据库配置
     *
     * @param baseJdbcEntity 初始化数据源
     * @param id             编号
     * @param params         参数
     * @return ResponseVo
     */
    public static ResponseVo<?> executeSql(JdbcEntity baseJdbcEntity, Long id, List<Object> params) {
        List<Map<String, Object>> list = getResult(baseJdbcEntity, id);

        //查询出来的数据只会有一条
        if (null != list && list.size() > 0) {
            Map<String, Object> map = list.get(0);
            SqlEntity sqlEntity = mapToSqlEntity(baseJdbcEntity.getDriverClass(), map);
            //获取数据库id
            Long jdbcId = sqlEntity.getJdbcId();
            //根据jdbcId查询jdbc连接信息
            JdbcEntity jdbcEntity = JdbcUtil.queryJdbcInfo(baseJdbcEntity, jdbcId);
            //根据id查询参数信息 如果有传参 用自己传的参数 没有去数据库查询是否有配置参数
            if (null == params || params.size() == 0) {
                params = ParamsUtil.queryParamsInfo(baseJdbcEntity, id);
            }
            List<Map<String, Object>> mapList = BaseJdbcUtil.executeQuery(jdbcEntity, sqlEntity.getSql(), params);
            return new ResponseVo(RespEnum.SUCCESS, mapList);
        }

        return new ResponseVo(RespEnum.SUCCESS);
    }

    /**
     * 查询SQL信息
     *
     * @param jdbcEntity 实体
     * @param id         编号
     * @return List<Map < String, Object>>
     */
    private static List<Map<String, Object>> getResult(JdbcEntity jdbcEntity, Long id) {

        return BaseJdbcUtil.executeQuery(jdbcEntity, SqlExecuteEnum.executeSql(jdbcEntity.getDriverClass(), 9), Collections.singletonList(id));
    }

    /**
     * map转换为实体
     *
     * @param jdbcEnum 数据源类型
     * @param map      map
     * @return SqlEntity
     */
    private static SqlEntity mapToSqlEntity(JdbcEnum jdbcEnum, Map<String, Object> map) {
        SqlEntity sqlEntity = new SqlEntity();
        sqlEntity.setId(Long.parseLong(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 10)).toString()));
        sqlEntity.setJdbcId(Long.parseLong(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 11)).toString()));
        sqlEntity.setSql(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 12)).toString());
        return sqlEntity;
    }

    /**
     * 实体类转换为list
     *
     * @param sqlEntity sql实体
     * @return List<Object>
     */
    private static List<Object> sqlToList(SqlEntity sqlEntity) {
        if (null == sqlEntity) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        list.add(sqlEntity.getJdbcId());
        list.add(sqlEntity.getSql());
        return list;
    }
}
