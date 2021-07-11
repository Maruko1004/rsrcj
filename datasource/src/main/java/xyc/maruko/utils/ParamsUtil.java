package xyc.maruko.utils;

import xyc.maruko.entity.JdbcEntity;
import xyc.maruko.entity.ParamsEntity;
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
 * 〈参数信息录入实现层〉
 *
 * @author maruko
 * @date 2021/7/7 10:46
 * @since 1.0.0
 */

public class ParamsUtil {

    /**
     * 添加参数信息
     *
     * @param jdbcEntity   初始化数据源
     * @param paramsEntity 参数实体
     * @return ResponseVo
     */
    public static ResponseVo addParams(JdbcEntity jdbcEntity, ParamsEntity paramsEntity) {

        BaseJdbcUtil.executeInsert(jdbcEntity, SqlExecuteEnum.executeSql(jdbcEntity.getDriverClass(), 13), paramsToList(paramsEntity));
        return new ResponseVo(RespEnum.SUCCESS);
    }

    /**
     * 根据SQL id查询参数详情
     *
     * @param jdbcEntity 初始化数据源
     * @param sqlId      sql编号
     * @return List<Object>
     */
    protected static List<Object> queryParamsInfo(JdbcEntity jdbcEntity, Long sqlId) {

        List<Map<String, Object>> mapList = BaseJdbcUtil.executeQuery(jdbcEntity, SqlExecuteEnum.executeSql(jdbcEntity.getDriverClass(), 14), Collections.singletonList(sqlId));
        if (null == mapList || mapList.size() == 0) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            list.add(map.get(SqlExecuteEnum.executeSql(jdbcEntity.getDriverClass(), 18)).toString());
        }
        return list;
    }

    /**
     * map转换为实体
     *
     * @param map map
     * @return ParamsEntity
     */
    private static ParamsEntity mapToParamsEntity(JdbcEnum jdbcEnum, Map<String, Object> map) {
        ParamsEntity paramsEntity = new ParamsEntity();
        paramsEntity.setId(Long.parseLong(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 15)).toString()));
        paramsEntity.setSqlId(Long.parseLong(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 16)).toString()));
        paramsEntity.setName(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 17)).toString());
        paramsEntity.setValue(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 18)).toString());
        paramsEntity.setType(map.get(SqlExecuteEnum.executeSql(jdbcEnum, 19)).toString());
        return paramsEntity;
    }

    /**
     * 实体类转换为list
     *
     * @param paramsEntity 实体
     * @return List<Object>
     */
    private static List<Object> paramsToList(ParamsEntity paramsEntity) {
        if (null == paramsEntity) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        list.add(paramsEntity.getSqlId());
        list.add(paramsEntity.getName());
        list.add(paramsEntity.getValue());
        list.add(paramsEntity.getType());
        return list;
    }
}
