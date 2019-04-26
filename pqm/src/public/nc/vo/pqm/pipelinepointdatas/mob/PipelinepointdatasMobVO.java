package nc.vo.pqm.pipelinepointdatas.mob;

import nc.vo.pm.mobile.base.MobileSuperVO;

/**
 * 管线点数据mobvo
 * @author wugy
 *
 */
public class PipelinepointdatasMobVO extends MobileSuperVO {
	
	public static final String PK_PIPELINEPOINTDATAS = "pk_pipelinepointdatas";
	public static final String PK_GROUP = "pk_group";
	public static final String PK_ORG = "pk_org";
	public static final String PK_PROJECT = "pk_project";
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String ELEVATION = "elevation";
	public static final String PK_PIPELINEPOINTCLASS = "pk_pipelinepointclass";
	public static final String PK_PRESSUREGRADE = "pk_pressuregrade";
	public static final String PIPELINEPOINTCLASS_NAME = "pipelinepointclass_name";
	public static final String PRESSUREGRADE_NAME = "pressuregrade_name";
	public static final String ISLINE = "isline";
	public static final String MEMO = "memo";
	public static final String CREATOR = "creator";
	public static final String CREATIONTIME = "creationtime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedtime";
	
	
	public PipelinepointdatasMobVO() {
		// 初始化实体存储数据，供查询时调用
		setAttributeValue(PipelinepointdatasMobVO.PK_PIPELINEPOINTDATAS, null);
		setAttributeValue(PipelinepointdatasMobVO.PK_GROUP, null);
		setAttributeValue(PipelinepointdatasMobVO.PK_ORG, null);
		setAttributeValue(PipelinepointdatasMobVO.PK_PROJECT, null);
		setAttributeValue(PipelinepointdatasMobVO.CODE, null);
		setAttributeValue(PipelinepointdatasMobVO.NAME, null);
		setAttributeValue(PipelinepointdatasMobVO.LONGITUDE, null);
		setAttributeValue(PipelinepointdatasMobVO.LATITUDE, null);
		setAttributeValue(PipelinepointdatasMobVO.ELEVATION, null);
		setAttributeValue(PipelinepointdatasMobVO.PK_PIPELINEPOINTCLASS, null);
		setAttributeValue(PipelinepointdatasMobVO.PK_PRESSUREGRADE, null);
		setAttributeValue(PipelinepointdatasMobVO.PIPELINEPOINTCLASS_NAME, null);
		setAttributeValue(PipelinepointdatasMobVO.PRESSUREGRADE_NAME, null);
		setAttributeValue(PipelinepointdatasMobVO.ISLINE, null);
		setAttributeValue(PipelinepointdatasMobVO.MEMO, null);
		setAttributeValue(PipelinepointdatasMobVO.CREATOR, null);
		setAttributeValue(PipelinepointdatasMobVO.CREATIONTIME, null);
		setAttributeValue(PipelinepointdatasMobVO.MODIFIER, null);
		setAttributeValue(PipelinepointdatasMobVO.MODIFIEDTIME, null);	
	}
	

	@Override
	public String getPKFieldName() {
		
		return PipelinepointdatasMobVO.PK_PIPELINEPOINTDATAS;
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
