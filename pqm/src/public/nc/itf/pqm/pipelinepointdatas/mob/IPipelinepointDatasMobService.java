package nc.itf.pqm.pipelinepointdatas.mob;

import java.util.List;
import java.util.Map;

/**
 * 管线点数据移动应用服务
 * 
 * @author  wugy
 * @time 2019-4-25 
 */
public interface IPipelinepointDatasMobService {
	
	/**
	 * 新增管线点数据
	 * 
	 * @author wugy
	 * @date 2019-4-25
	 * @param group
	 * @param param  包含：
	 * @return
	 */
	public Map<String, Object> insertPipelinepointDatas (String creator,String pk_group, List<Map> plpList);

	/**
	 * 根据当前项目查询管线点数据列表
	 * 
	 * @author wugy
	 * @date 2019-4-25
	 * @param pk_project
	 * @return 
	 */
	public Map<String, Object> queryPipelinepointDatasByProject (Map<String, Object> param);

	/**
	 * 根据管线点数据pk查询管线点数据详细信息
	 * 
	 * @author wugy
	 * @date 2019-4-25
	 * @param pk_pipelinepointdatas
	 * @return 
	 */
	public Map<String, Object> queryPipelinepointDatasByPK (Map<String, Object> param);

	
}
