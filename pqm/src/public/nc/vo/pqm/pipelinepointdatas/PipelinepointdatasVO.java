package nc.vo.pqm.pipelinepointdatas;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/**
 * <b> 此处简要描述此类功能 </b>
 * <p>
 *   此处添加累的描述信息
 * </p>
 *  创建日期:2019-5-22
 * @author yonyouBQ
 * @version NCPrj ??
 */
 
public class PipelinepointdatasVO extends SuperVO {
	
/**
*主键
*/
public java.lang.String pk_pipelinepointdatas;
/**
*集团
*/
public java.lang.String pk_group;
/**
*组织
*/
public java.lang.String pk_org;
/**
*项目主键
*/
public java.lang.String pk_project;
/**
*项目组织
*/
public java.lang.String project_org;
/**
*项目编码
*/
public java.lang.String project_code;
/**
*项目名称
*/
public java.lang.String project_name;
/**
*项目类型
*/
public java.lang.String project_class;
/**
*eps
*/
public java.lang.String eps;
/**
*采点编码
*/
public java.lang.Integer code;
/**
*采点名称
*/
public java.lang.String name;
/**
*经度
*/
public java.lang.String longitude;
/**
*纬度
*/
public java.lang.String latitude;
/**
*高程
*/
public java.lang.String elevation;
/**
*管线点分类
*/
public java.lang.String pk_pipelinepointclass;
/**
*压力等级
*/
public java.lang.String pk_pressuregrade;
/**
*压力MPa
*/
public java.lang.String mpa;
/**
*成线
*/
public java.lang.String isline;
/**
*备注
*/
public java.lang.String memo;
/**
*单据日期
*/
public UFDate billdate;
/**
*提交人
*/
public java.lang.String creator;
/**
*提交时间
*/
public UFDateTime creationtime;
/**
*最后修改人
*/
public java.lang.String modifier;
/**
*最后修改时间
*/
public UFDateTime modifiedtime;
/**
*自定义项1
*/
public java.lang.String vdef1;
/**
*自定义项2
*/
public java.lang.String vdef2;
/**
*自定义项3
*/
public java.lang.String vdef3;
/**
*自定义项4
*/
public java.lang.String vdef4;
/**
*自定义项5
*/
public java.lang.String vdef5;
/**
*自定义项6
*/
public java.lang.String vdef6;
/**
*自定义项7
*/
public java.lang.String vdef7;
/**
*自定义项8
*/
public java.lang.String vdef8;
/**
*自定义项9
*/
public java.lang.String vdef9;
/**
*自定义项10
*/
public java.lang.String vdef10;
/**
*自定义项11
*/
public java.lang.String vdef11;
/**
*自定义项12
*/
public java.lang.String vdef12;
/**
*自定义项13
*/
public java.lang.String vdef13;
/**
*自定义项14
*/
public java.lang.String vdef14;
/**
*自定义项15
*/
public java.lang.String vdef15;
/**
*自定义项16
*/
public java.lang.String vdef16;
/**
*自定义项17
*/
public java.lang.String vdef17;
/**
*自定义项18
*/
public java.lang.String vdef18;
/**
*自定义项19
*/
public java.lang.String vdef19;
/**
*自定义项20
*/
public java.lang.String vdef20;
/**
*自定义项21
*/
public java.lang.String vdef21;
/**
*自定义项22
*/
public java.lang.String vdef22;
/**
*自定义项23
*/
public java.lang.String vdef23;
/**
*自定义项24
*/
public java.lang.String vdef24;
/**
*自定义项25
*/
public java.lang.String vdef25;
/**
*自定义项26
*/
public java.lang.String vdef26;
/**
*自定义项27
*/
public java.lang.String vdef27;
/**
*自定义项28
*/
public java.lang.String vdef28;
/**
*自定义项29
*/
public java.lang.String vdef29;
/**
*自定义项30
*/
public java.lang.String vdef30;
/**
*时间戳
*/
public UFDateTime ts;


/**
*时间戳
*/
public static final String TS="ts";
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
public static final String ISLINE = "isline";
public static final String MEMO = "memo";
public static final String CREATOR = "creator";
public static final String CREATIONTIME = "creationtime";
public static final String MODIFIER = "modifier";
public static final String MODIFIEDTIME = "modifiedtime";
public static final String BILLDATE = "billdate";
public static final String DEF1 = "def1";
public static final String DEF2 = "def2";
public static final String DEF3 = "def3";
public static final String DEF4 = "def4";
public static final String DEF5 = "def5";
public static final String DEF6 = "def6";
public static final String DEF7 = "def7";
public static final String DEF8 = "def8";
public static final String DEF9 = "def9";
public static final String DEF10 = "def10";
public static final String MDID = "d30e91c1-485f-4486-90d9-59d9710039a1";
    
    
/**
* 属性 pk_pipelinepointdatas的Getter方法.属性名：主键
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getPk_pipelinepointdatas() {
return this.pk_pipelinepointdatas;
} 

/**
* 属性pk_pipelinepointdatas的Setter方法.属性名：主键
* 创建日期:2019-5-22
* @param newPk_pipelinepointdatas java.lang.String
*/
public void setPk_pipelinepointdatas ( java.lang.String pk_pipelinepointdatas) {
this.pk_pipelinepointdatas=pk_pipelinepointdatas;
} 
 
/**
* 属性 pk_group的Getter方法.属性名：集团
*  创建日期:2019-5-22
* @return nc.vo.org.GroupVO
*/
public java.lang.String getPk_group() {
return this.pk_group;
} 

/**
* 属性pk_group的Setter方法.属性名：集团
* 创建日期:2019-5-22
* @param newPk_group nc.vo.org.GroupVO
*/
public void setPk_group ( java.lang.String pk_group) {
this.pk_group=pk_group;
} 
 
/**
* 属性 pk_org的Getter方法.属性名：组织
*  创建日期:2019-5-22
* @return nc.vo.org.OrgVO
*/
public java.lang.String getPk_org() {
return this.pk_org;
} 

/**
* 属性pk_org的Setter方法.属性名：组织
* 创建日期:2019-5-22
* @param newPk_org nc.vo.org.OrgVO
*/
public void setPk_org ( java.lang.String pk_org) {
this.pk_org=pk_org;
} 
 
/**
* 属性 pk_project的Getter方法.属性名：项目主键
*  创建日期:2019-5-22
* @return nc.vo.pmpub.project.ProjectHeadVO
*/
public java.lang.String getPk_project() {
return this.pk_project;
} 

/**
* 属性pk_project的Setter方法.属性名：项目主键
* 创建日期:2019-5-22
* @param newPk_project nc.vo.pmpub.project.ProjectHeadVO
*/
public void setPk_project ( java.lang.String pk_project) {
this.pk_project=pk_project;
} 
 
/**
* 属性 project_org的Getter方法.属性名：项目组织
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getProject_org() {
return this.project_org;
} 

/**
* 属性project_org的Setter方法.属性名：项目组织
* 创建日期:2019-5-22
* @param newProject_org java.lang.String
*/
public void setProject_org ( java.lang.String project_org) {
this.project_org=project_org;
} 
 
/**
* 属性 project_code的Getter方法.属性名：项目编码
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getProject_code() {
return this.project_code;
} 

/**
* 属性project_code的Setter方法.属性名：项目编码
* 创建日期:2019-5-22
* @param newProject_code java.lang.String
*/
public void setProject_code ( java.lang.String project_code) {
this.project_code=project_code;
} 
 
/**
* 属性 project_name的Getter方法.属性名：项目名称
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getProject_name() {
return this.project_name;
} 

/**
* 属性project_name的Setter方法.属性名：项目名称
* 创建日期:2019-5-22
* @param newProject_name java.lang.String
*/
public void setProject_name ( java.lang.String project_name) {
this.project_name=project_name;
} 
 
/**
* 属性 project_class的Getter方法.属性名：项目类型
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getProject_class() {
return this.project_class;
} 

/**
* 属性project_class的Setter方法.属性名：项目类型
* 创建日期:2019-5-22
* @param newProject_class java.lang.String
*/
public void setProject_class ( java.lang.String project_class) {
this.project_class=project_class;
} 
 
/**
* 属性 eps的Getter方法.属性名：eps
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getEps() {
return this.eps;
} 

/**
* 属性eps的Setter方法.属性名：eps
* 创建日期:2019-5-22
* @param newEps java.lang.String
*/
public void setEps ( java.lang.String eps) {
this.eps=eps;
} 
 
/**
* 属性 code的Getter方法.属性名：采点编码
*  创建日期:2019-5-22
* @return java.lang.Integer
*/
public java.lang.Integer getCode() {
return this.code;
} 

/**
* 属性code的Setter方法.属性名：采点编码
* 创建日期:2019-5-22
* @param newCode java.lang.Integer
*/
public void setCode ( java.lang.Integer code) {
this.code=code;
} 
 
/**
* 属性 name的Getter方法.属性名：采点名称
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getName() {
return this.name;
} 

/**
* 属性name的Setter方法.属性名：采点名称
* 创建日期:2019-5-22
* @param newName java.lang.String
*/
public void setName ( java.lang.String name) {
this.name=name;
} 
 
/**
* 属性 longitude的Getter方法.属性名：经度
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getLongitude() {
return this.longitude;
} 

/**
* 属性longitude的Setter方法.属性名：经度
* 创建日期:2019-5-22
* @param newLongitude java.lang.String
*/
public void setLongitude ( java.lang.String longitude) {
this.longitude=longitude;
} 
 
/**
* 属性 latitude的Getter方法.属性名：纬度
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getLatitude() {
return this.latitude;
} 

/**
* 属性latitude的Setter方法.属性名：纬度
* 创建日期:2019-5-22
* @param newLatitude java.lang.String
*/
public void setLatitude ( java.lang.String latitude) {
this.latitude=latitude;
} 
 
/**
* 属性 elevation的Getter方法.属性名：高程
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getElevation() {
return this.elevation;
} 

/**
* 属性elevation的Setter方法.属性名：高程
* 创建日期:2019-5-22
* @param newElevation java.lang.String
*/
public void setElevation ( java.lang.String elevation) {
this.elevation=elevation;
} 
 
/**
* 属性 pk_pipelinepointclass的Getter方法.属性名：管线点分类
*  创建日期:2019-5-22
* @return nc.vo.pmbd.bd.pipelinepointclass.PipelinepointclassVO
*/
public java.lang.String getPk_pipelinepointclass() {
return this.pk_pipelinepointclass;
} 

/**
* 属性pk_pipelinepointclass的Setter方法.属性名：管线点分类
* 创建日期:2019-5-22
* @param newPk_pipelinepointclass nc.vo.pmbd.bd.pipelinepointclass.PipelinepointclassVO
*/
public void setPk_pipelinepointclass ( java.lang.String pk_pipelinepointclass) {
this.pk_pipelinepointclass=pk_pipelinepointclass;
} 
 
/**
* 属性 pk_pressuregrade的Getter方法.属性名：压力等级
*  创建日期:2019-5-22
* @return nc.vo.pmbd.bd.pressuregrade.PressuregradeVO
*/
public java.lang.String getPk_pressuregrade() {
return this.pk_pressuregrade;
} 

/**
* 属性pk_pressuregrade的Setter方法.属性名：压力等级
* 创建日期:2019-5-22
* @param newPk_pressuregrade nc.vo.pmbd.bd.pressuregrade.PressuregradeVO
*/
public void setPk_pressuregrade ( java.lang.String pk_pressuregrade) {
this.pk_pressuregrade=pk_pressuregrade;
} 
 
/**
* 属性 mpa的Getter方法.属性名：压力MPa
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getMpa() {
return this.mpa;
} 

/**
* 属性mpa的Setter方法.属性名：压力MPa
* 创建日期:2019-5-22
* @param newMpa java.lang.String
*/
public void setMpa ( java.lang.String mpa) {
this.mpa=mpa;
} 
 
/**
* 属性 isline的Getter方法.属性名：成线
*  创建日期:2019-5-22
* @return nc.vo.pqm.pipelinepointdatas.Isline
*/
public java.lang.String getIsline() {
return this.isline;
} 

/**
* 属性isline的Setter方法.属性名：成线
* 创建日期:2019-5-22
* @param newIsline nc.vo.pqm.pipelinepointdatas.Isline
*/
public void setIsline ( java.lang.String isline) {
this.isline=isline;
} 
 
/**
* 属性 memo的Getter方法.属性名：备注
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getMemo() {
return this.memo;
} 

/**
* 属性memo的Setter方法.属性名：备注
* 创建日期:2019-5-22
* @param newMemo java.lang.String
*/
public void setMemo ( java.lang.String memo) {
this.memo=memo;
} 
 
/**
* 属性 billdate的Getter方法.属性名：单据日期
*  创建日期:2019-5-22
* @return nc.vo.pub.lang.UFDate
*/
public UFDate getBilldate() {
return this.billdate;
} 

/**
* 属性billdate的Setter方法.属性名：单据日期
* 创建日期:2019-5-22
* @param newBilldate nc.vo.pub.lang.UFDate
*/
public void setBilldate ( UFDate billdate) {
this.billdate=billdate;
} 
 
/**
* 属性 creator的Getter方法.属性名：提交人
*  创建日期:2019-5-22
* @return nc.vo.sm.UserVO
*/
public java.lang.String getCreator() {
return this.creator;
} 

/**
* 属性creator的Setter方法.属性名：提交人
* 创建日期:2019-5-22
* @param newCreator nc.vo.sm.UserVO
*/
public void setCreator ( java.lang.String creator) {
this.creator=creator;
} 
 
/**
* 属性 creationtime的Getter方法.属性名：提交时间
*  创建日期:2019-5-22
* @return nc.vo.pub.lang.UFDateTime
*/
public UFDateTime getCreationtime() {
return this.creationtime;
} 

/**
* 属性creationtime的Setter方法.属性名：提交时间
* 创建日期:2019-5-22
* @param newCreationtime nc.vo.pub.lang.UFDateTime
*/
public void setCreationtime ( UFDateTime creationtime) {
this.creationtime=creationtime;
} 
 
/**
* 属性 modifier的Getter方法.属性名：最后修改人
*  创建日期:2019-5-22
* @return nc.vo.sm.UserVO
*/
public java.lang.String getModifier() {
return this.modifier;
} 

/**
* 属性modifier的Setter方法.属性名：最后修改人
* 创建日期:2019-5-22
* @param newModifier nc.vo.sm.UserVO
*/
public void setModifier ( java.lang.String modifier) {
this.modifier=modifier;
} 
 
/**
* 属性 modifiedtime的Getter方法.属性名：最后修改时间
*  创建日期:2019-5-22
* @return nc.vo.pub.lang.UFDateTime
*/
public UFDateTime getModifiedtime() {
return this.modifiedtime;
} 

/**
* 属性modifiedtime的Setter方法.属性名：最后修改时间
* 创建日期:2019-5-22
* @param newModifiedtime nc.vo.pub.lang.UFDateTime
*/
public void setModifiedtime ( UFDateTime modifiedtime) {
this.modifiedtime=modifiedtime;
} 
 
/**
* 属性 vdef1的Getter方法.属性名：自定义项1
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef1() {
return this.vdef1;
} 

/**
* 属性vdef1的Setter方法.属性名：自定义项1
* 创建日期:2019-5-22
* @param newVdef1 java.lang.String
*/
public void setVdef1 ( java.lang.String vdef1) {
this.vdef1=vdef1;
} 
 
/**
* 属性 vdef2的Getter方法.属性名：自定义项2
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef2() {
return this.vdef2;
} 

/**
* 属性vdef2的Setter方法.属性名：自定义项2
* 创建日期:2019-5-22
* @param newVdef2 java.lang.String
*/
public void setVdef2 ( java.lang.String vdef2) {
this.vdef2=vdef2;
} 
 
/**
* 属性 vdef3的Getter方法.属性名：自定义项3
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef3() {
return this.vdef3;
} 

/**
* 属性vdef3的Setter方法.属性名：自定义项3
* 创建日期:2019-5-22
* @param newVdef3 java.lang.String
*/
public void setVdef3 ( java.lang.String vdef3) {
this.vdef3=vdef3;
} 
 
/**
* 属性 vdef4的Getter方法.属性名：自定义项4
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef4() {
return this.vdef4;
} 

/**
* 属性vdef4的Setter方法.属性名：自定义项4
* 创建日期:2019-5-22
* @param newVdef4 java.lang.String
*/
public void setVdef4 ( java.lang.String vdef4) {
this.vdef4=vdef4;
} 
 
/**
* 属性 vdef5的Getter方法.属性名：自定义项5
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef5() {
return this.vdef5;
} 

/**
* 属性vdef5的Setter方法.属性名：自定义项5
* 创建日期:2019-5-22
* @param newVdef5 java.lang.String
*/
public void setVdef5 ( java.lang.String vdef5) {
this.vdef5=vdef5;
} 
 
/**
* 属性 vdef6的Getter方法.属性名：自定义项6
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef6() {
return this.vdef6;
} 

/**
* 属性vdef6的Setter方法.属性名：自定义项6
* 创建日期:2019-5-22
* @param newVdef6 java.lang.String
*/
public void setVdef6 ( java.lang.String vdef6) {
this.vdef6=vdef6;
} 
 
/**
* 属性 vdef7的Getter方法.属性名：自定义项7
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef7() {
return this.vdef7;
} 

/**
* 属性vdef7的Setter方法.属性名：自定义项7
* 创建日期:2019-5-22
* @param newVdef7 java.lang.String
*/
public void setVdef7 ( java.lang.String vdef7) {
this.vdef7=vdef7;
} 
 
/**
* 属性 vdef8的Getter方法.属性名：自定义项8
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef8() {
return this.vdef8;
} 

/**
* 属性vdef8的Setter方法.属性名：自定义项8
* 创建日期:2019-5-22
* @param newVdef8 java.lang.String
*/
public void setVdef8 ( java.lang.String vdef8) {
this.vdef8=vdef8;
} 
 
/**
* 属性 vdef9的Getter方法.属性名：自定义项9
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef9() {
return this.vdef9;
} 

/**
* 属性vdef9的Setter方法.属性名：自定义项9
* 创建日期:2019-5-22
* @param newVdef9 java.lang.String
*/
public void setVdef9 ( java.lang.String vdef9) {
this.vdef9=vdef9;
} 
 
/**
* 属性 vdef10的Getter方法.属性名：自定义项10
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef10() {
return this.vdef10;
} 

/**
* 属性vdef10的Setter方法.属性名：自定义项10
* 创建日期:2019-5-22
* @param newVdef10 java.lang.String
*/
public void setVdef10 ( java.lang.String vdef10) {
this.vdef10=vdef10;
} 
 
/**
* 属性 vdef11的Getter方法.属性名：自定义项11
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef11() {
return this.vdef11;
} 

/**
* 属性vdef11的Setter方法.属性名：自定义项11
* 创建日期:2019-5-22
* @param newVdef11 java.lang.String
*/
public void setVdef11 ( java.lang.String vdef11) {
this.vdef11=vdef11;
} 
 
/**
* 属性 vdef12的Getter方法.属性名：自定义项12
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef12() {
return this.vdef12;
} 

/**
* 属性vdef12的Setter方法.属性名：自定义项12
* 创建日期:2019-5-22
* @param newVdef12 java.lang.String
*/
public void setVdef12 ( java.lang.String vdef12) {
this.vdef12=vdef12;
} 
 
/**
* 属性 vdef13的Getter方法.属性名：自定义项13
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef13() {
return this.vdef13;
} 

/**
* 属性vdef13的Setter方法.属性名：自定义项13
* 创建日期:2019-5-22
* @param newVdef13 java.lang.String
*/
public void setVdef13 ( java.lang.String vdef13) {
this.vdef13=vdef13;
} 
 
/**
* 属性 vdef14的Getter方法.属性名：自定义项14
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef14() {
return this.vdef14;
} 

/**
* 属性vdef14的Setter方法.属性名：自定义项14
* 创建日期:2019-5-22
* @param newVdef14 java.lang.String
*/
public void setVdef14 ( java.lang.String vdef14) {
this.vdef14=vdef14;
} 
 
/**
* 属性 vdef15的Getter方法.属性名：自定义项15
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef15() {
return this.vdef15;
} 

/**
* 属性vdef15的Setter方法.属性名：自定义项15
* 创建日期:2019-5-22
* @param newVdef15 java.lang.String
*/
public void setVdef15 ( java.lang.String vdef15) {
this.vdef15=vdef15;
} 
 
/**
* 属性 vdef16的Getter方法.属性名：自定义项16
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef16() {
return this.vdef16;
} 

/**
* 属性vdef16的Setter方法.属性名：自定义项16
* 创建日期:2019-5-22
* @param newVdef16 java.lang.String
*/
public void setVdef16 ( java.lang.String vdef16) {
this.vdef16=vdef16;
} 
 
/**
* 属性 vdef17的Getter方法.属性名：自定义项17
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef17() {
return this.vdef17;
} 

/**
* 属性vdef17的Setter方法.属性名：自定义项17
* 创建日期:2019-5-22
* @param newVdef17 java.lang.String
*/
public void setVdef17 ( java.lang.String vdef17) {
this.vdef17=vdef17;
} 
 
/**
* 属性 vdef18的Getter方法.属性名：自定义项18
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef18() {
return this.vdef18;
} 

/**
* 属性vdef18的Setter方法.属性名：自定义项18
* 创建日期:2019-5-22
* @param newVdef18 java.lang.String
*/
public void setVdef18 ( java.lang.String vdef18) {
this.vdef18=vdef18;
} 
 
/**
* 属性 vdef19的Getter方法.属性名：自定义项19
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef19() {
return this.vdef19;
} 

/**
* 属性vdef19的Setter方法.属性名：自定义项19
* 创建日期:2019-5-22
* @param newVdef19 java.lang.String
*/
public void setVdef19 ( java.lang.String vdef19) {
this.vdef19=vdef19;
} 
 
/**
* 属性 vdef20的Getter方法.属性名：自定义项20
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef20() {
return this.vdef20;
} 

/**
* 属性vdef20的Setter方法.属性名：自定义项20
* 创建日期:2019-5-22
* @param newVdef20 java.lang.String
*/
public void setVdef20 ( java.lang.String vdef20) {
this.vdef20=vdef20;
} 
 
/**
* 属性 vdef21的Getter方法.属性名：自定义项21
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef21() {
return this.vdef21;
} 

/**
* 属性vdef21的Setter方法.属性名：自定义项21
* 创建日期:2019-5-22
* @param newVdef21 java.lang.String
*/
public void setVdef21 ( java.lang.String vdef21) {
this.vdef21=vdef21;
} 
 
/**
* 属性 vdef22的Getter方法.属性名：自定义项22
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef22() {
return this.vdef22;
} 

/**
* 属性vdef22的Setter方法.属性名：自定义项22
* 创建日期:2019-5-22
* @param newVdef22 java.lang.String
*/
public void setVdef22 ( java.lang.String vdef22) {
this.vdef22=vdef22;
} 
 
/**
* 属性 vdef23的Getter方法.属性名：自定义项23
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef23() {
return this.vdef23;
} 

/**
* 属性vdef23的Setter方法.属性名：自定义项23
* 创建日期:2019-5-22
* @param newVdef23 java.lang.String
*/
public void setVdef23 ( java.lang.String vdef23) {
this.vdef23=vdef23;
} 
 
/**
* 属性 vdef24的Getter方法.属性名：自定义项24
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef24() {
return this.vdef24;
} 

/**
* 属性vdef24的Setter方法.属性名：自定义项24
* 创建日期:2019-5-22
* @param newVdef24 java.lang.String
*/
public void setVdef24 ( java.lang.String vdef24) {
this.vdef24=vdef24;
} 
 
/**
* 属性 vdef25的Getter方法.属性名：自定义项25
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef25() {
return this.vdef25;
} 

/**
* 属性vdef25的Setter方法.属性名：自定义项25
* 创建日期:2019-5-22
* @param newVdef25 java.lang.String
*/
public void setVdef25 ( java.lang.String vdef25) {
this.vdef25=vdef25;
} 
 
/**
* 属性 vdef26的Getter方法.属性名：自定义项26
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef26() {
return this.vdef26;
} 

/**
* 属性vdef26的Setter方法.属性名：自定义项26
* 创建日期:2019-5-22
* @param newVdef26 java.lang.String
*/
public void setVdef26 ( java.lang.String vdef26) {
this.vdef26=vdef26;
} 
 
/**
* 属性 vdef27的Getter方法.属性名：自定义项27
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef27() {
return this.vdef27;
} 

/**
* 属性vdef27的Setter方法.属性名：自定义项27
* 创建日期:2019-5-22
* @param newVdef27 java.lang.String
*/
public void setVdef27 ( java.lang.String vdef27) {
this.vdef27=vdef27;
} 
 
/**
* 属性 vdef28的Getter方法.属性名：自定义项28
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef28() {
return this.vdef28;
} 

/**
* 属性vdef28的Setter方法.属性名：自定义项28
* 创建日期:2019-5-22
* @param newVdef28 java.lang.String
*/
public void setVdef28 ( java.lang.String vdef28) {
this.vdef28=vdef28;
} 
 
/**
* 属性 vdef29的Getter方法.属性名：自定义项29
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef29() {
return this.vdef29;
} 

/**
* 属性vdef29的Setter方法.属性名：自定义项29
* 创建日期:2019-5-22
* @param newVdef29 java.lang.String
*/
public void setVdef29 ( java.lang.String vdef29) {
this.vdef29=vdef29;
} 
 
/**
* 属性 vdef30的Getter方法.属性名：自定义项30
*  创建日期:2019-5-22
* @return java.lang.String
*/
public java.lang.String getVdef30() {
return this.vdef30;
} 

/**
* 属性vdef30的Setter方法.属性名：自定义项30
* 创建日期:2019-5-22
* @param newVdef30 java.lang.String
*/
public void setVdef30 ( java.lang.String vdef30) {
this.vdef30=vdef30;
} 
 
/**
* 属性 生成时间戳的Getter方法.属性名：时间戳
*  创建日期:2019-5-22
* @return nc.vo.pub.lang.UFDateTime
*/
public UFDateTime getTs() {
return this.ts;
}
/**
* 属性生成时间戳的Setter方法.属性名：时间戳
* 创建日期:2019-5-22
* @param newts nc.vo.pub.lang.UFDateTime
*/
public void setTs(UFDateTime ts){
this.ts=ts;
} 
     
    @Override
    public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("pqm.pipelinepointdatas");
    }
   }
    