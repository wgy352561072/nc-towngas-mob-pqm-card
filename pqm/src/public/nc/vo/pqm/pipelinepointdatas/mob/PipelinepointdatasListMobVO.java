package nc.vo.pqm.pipelinepointdatas.mob;

import nc.vo.pm.mobile.base.MobileSuperVO;

/**
 * 管线点数据Listmobvo
 * @author wugy
 *
 */
public class PipelinepointdatasListMobVO extends MobileSuperVO {
	
	public static final String PK_PIPELINEPOINTDATAS = "pk_pipelinepointdatas";
	public static final String CODE = "code";

	
	
	public PipelinepointdatasListMobVO() {
		// 初始化实体存储数据，供查询时调用
		setAttributeValue(PipelinepointdatasListMobVO.PK_PIPELINEPOINTDATAS, null);
		setAttributeValue(PipelinepointdatasListMobVO.CODE, null);
	}
	

	@Override
	public String getPKFieldName() {
		
		return PipelinepointdatasListMobVO.PK_PIPELINEPOINTDATAS;
	}


	@Override
	protected void constructMobRefRelationCardAggVO() {
		// TODO 自动生成的方法存根

	}

	@Override
	protected void constructMobRefRelationListAggVO() {
		// TODO 自动生成的方法存根

	}

}
