package org.spring.springboot.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/7/26 13:32
 */
@Data
@Accessors(chain = true)
public class QLSXiaoBan {
    private Long id;//MwOID
    private String image;//MwGeometry 图片需要转静态
    private Long checkedUserId;//MwCheckedUserID
    private Long editState;//MwEditState
    private Long userId;//MwUserID
    private BigDecimal minX;//MwMinX
    private BigDecimal maxX;//MwMaxX
    private BigDecimal minY;//MwMinY
    private BigDecimal maxY;//MwMaxY
    private BigDecimal area;//MwArea
    private BigDecimal perimeter;//MwPerimeter
    private String sheng;//SHENG 省
    private String xian;//XIAN 县
    private String xiang;//XIANG 乡
    private String cun;//CUN 村
    private String linYeJu;//LIN_YE_JU 林业局
    private String gongNengKaiFaQu;//GN_FQU //功能开发区
    private String linChang;//LIN_CHANG 林场
    private String linBan;//LIN_BAN 林班
    private String xiaoBan;//XIAO_BAN 小班
    private String diMao;//DI_MAO 地貌
    private String poXiang;//PO_XIANG 坡向
    private String poWei;//PO_WEI 坡位
    private String poDu;//PO_DU 坡度
    private String keJiDu;//KE_JI_DU
    private String tuRangType;//TU_RANG_LX 土壤类型
    private String tuCengHouDu;//TU_CENG_HD
    private BigDecimal mianJi;//MIAN_JI 面积
    private BigDecimal pmMianJi;//PM_MIANJI
    private BigDecimal elMianJi;//EL_MIANJI
    private String tudiQuanShu;//TD_QS 土地权属
    private String linMuQuanShu;//LM_QS 林木权属
    private String diLei;//DI_LEI 地类
    private String dlErlei;//DL_ERLEI 地二类
    private String linZhong;//LIN_ZHONG 林种
    private String qiYuan;//QI_YUAN 起源
    private String senLinType;//SEN_LIN_LB 森林类别
    private String shiQuanClass;//SHI_QUAN_D 事权等级
    private String shengTaiQuWei;//SHT_QW 生态区位
    private String guoJiaJiGongYiLinBaoHuClass;//GJGYL_BHDJ 国家级公益林保护等级
    private String GongChengType;//G_CHENG_LB 工程类别
    private String LingZu;//LING_ZU 林组
    private BigDecimal yuBiDu;//YU_BI_DU 郁闭度
    private String youShiShuZhong;//YOU_SHI_SZ 优势树种
    private BigDecimal pingJunXiongJing;//PING_JUN_X 平均胸径
    private BigDecimal huoLinMuMeiGongQingXiongJing;//HUO_LMGQXJ 活林木每公顷胸径
    private Integer youShuMeiGongQingZhuShu;//MEI_GQ_ZS 幼树每公顷株数
    private String tuDiTuiHuaType;//TD_TH_LX 土地退化类型
    private String disasterType;//DISPE 森林灾害类型
    private String disasterClass;//DISASTER_C 灾害等级
    private String linDiZhiLiangClass;//ZL_DJ 林地质量等级
    private BigDecimal linDiWidth;//LD_KD 林地宽度
    private BigDecimal linDiLength;//LD_CD 林地长度
    private String buChongLinDi;//BCLD 是否为补充林地
    private String guiHuaLinDi;//SFNRLD 是否纳入规划林地
    private String baoHuClass;//BH_DJ 保护等级
    private String linDiGongNengQuFen;//LYFQ 林地功能区分
    private String zhuTiGongNengQuFen;//QYKZ 主体功能区分
    private String guanLiDanWei;//GLDW 管理单位
    private String zhengYi;//SFZY 是否争议
    private String linDiSuoZaiDi;//LDSZS 林地所在地
    private String guiHuaLinZhong;//GH_LZ 规划林种
    private String guiHuaSenLinType;//GH_SLLB 规划森林类别
    private String guiHuaGuoJiaBaoHuClass;//GH_GJJBHDJ 规划国家保护等级
    private String guiHuaBaoHuClass;//GH_BHDJ 规划保护等级
    private String dbLink;//DBLINK
    private String ageClass;//龄级
    private BigDecimal xiaoBanZhuShu;//全小班株数
    private BigDecimal xiaoBanChuJi;//全小班蓄积
    private String jingJiLinChanQi;//经济林产期
    private BigDecimal sanShengMuZhuShu;//散生木株数
    private BigDecimal sanShengMuChuJi;//散生木蓄积
    private BigDecimal siPangShuZhuShu;//四旁树株数
    private BigDecimal siPangShuChuJi;//四旁树蓄积
    private String remark;//备注
    private String guiHuaSenLinMianJiZongJi;//GH_SLMJ_ZJ 规划森林面积总计
    private String shuZhongZuCheng;//树种组成
    private String shengName;//SHENG_N 省-名
    private String xianName;//XIAN_N 县-名
    private String gongNengKaiFaQuName;//GN_FQU_N 功能开发区-名
    private String linChangName;//LINCHANG_N 林场-名
    private String diMaoName;//DI_MAO_N 地貌-名
    private String poXiangName;//PO_XIANG_N 坡向-名
    private String poWeiName;//PO_WEI_N 坡位-名
    private String poDuName;//PO_DU_N 坡度-名
    private String keJiDuName;//KE_JI_DU_N
    private String tuDiQuanShuName;//TD_QS_N 土地权属-名
    private String linMuQuanShuName;//LM_QS_N 林木权属-名
    private String diLeiName;//DI_LEI_N 地类名
    private String linZhongName;//LINZHONG_N 林种-名
    private String qiYuanName;//QI_YUAN_N 起源-名
    private String senLinTypeName;//SENLINLB_N 森林类别-名
    private String shiQuanClassName;//SHIQUAND_N 事权等级-名
    private String shengTaiQuWeiName;//SHT_QW_N 生态区位-名
    private String guoJiaJiGongYiLinBaoHuClassName;//GJGYLBHD_N 国家级公益林保护等级-名
    private String gongChengTypeName;//GCHENGLB_N 工程类别-名
    private String lingZuName;//LING_ZU_N 林组-名
    private String tuDiTuiHuaTypeName;//TD_TH_LX_N 土地退化类型-名
    private String disasterTypeName;//DISPE_N 灾害类型-名
    private String disasterClassName;//DISASTER_N 灾害等级-名
    private String linDiZhiLiangClassName;//ZL_DJ_N 林地质量等级-名
    private String linDiWidthName;//BC_LD_N 林宽度-名
    private String linDiLengName;//SFNRLD_N 林地长度-名
    private String zhengYiName;//SFZY_N 是否争议-名
    private String youShiShuZhongName;//YOU_SHI__1 优势树种-名
    private String guiHuaLinZhongName;//GH_LZ_N 规划林种-名
    private String guiHuaSenLinTypeName;//GH_SLLB_N 规划森林类别-名
    private String guiHuaGuoJiaBaoHuClassName;//GH_GJJBH_1 规划国家保护等级-名
    private String guiHuaBaoHuClassName;//GH_BHDJ_N 规划保护等级-名
    private String dilix;//DILIX
    private Date lzx;//LZX
    private String lzxx;//LZXX
    private String biaoZhu;//BIAO_ZHU 标注
    private String linyejuName;//LIN_YE_JU_ 林业局-名
    private BigDecimal shapeArea;//SHAPE_AREA
    private BigDecimal shapeLength;//SHAPE_LEN
    private String zhuanYongTu;//专题图
    private String diJiBianHao;//地籍编号
}