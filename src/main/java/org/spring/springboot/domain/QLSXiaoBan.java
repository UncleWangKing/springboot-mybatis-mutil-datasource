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
    private String imageUrl;//MwGeometry 图片需要转静态
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
    private String gnFqu;//GN_FQU //功能开发区
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
    private BigDecimal mianJi;//MIAN_JI
    private BigDecimal pmMianJi;//PM_MIANJI
    private BigDecimal elMianJi;//EL_MIANJI
    private String tudiQuanShu;//TD_QS
    private String linMuQuanShu;//LM_QS
    private String diLei;//DI_LEI 地类
    private String dlErlei;//DL_ERLEI 地二类
    private String linZhong;//LIN_ZHONG 林种
    private String qiYuan;//QI_YUAN 起源
    private String senLinLb;//SEN_LIN_LB 森林类别
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
    private String senLinZaiHaiType;//DISPE 森林灾害类型
    private String disasterClass;//DISASTER_C 灾害等级
    private String linDiZhiLiangClass;//ZL_DJ 林地质量等级
    private BigDecimal linDiKuanDu;//LD_KD 林地宽度
    private BigDecimal linDiChangDu;//LD_CD 林地长度
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
    private String;//DBLINK
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
    private String ;//SHENG_N
    private String;//XIAN_N
    private String;//GN_FQU_N
    private String;//LINCHANG_N
    private String;//DI_MAO_N
    private String;//PO_XIANG_N
    private String;//PO_WEI_N
    private String;//PO_DU_N
    private String;//KE_JI_DU_N
    private String;//TD_QS_N
    private String;//LM_QS_N
    private String;//DI_LEI_N
    private String;//LINZHONG_N
    private String;//QI_YUAN_N
    private String;//SENLINLB_N
    private String;//SHIQUAND_N
    private String;//SHT_QW_N
    private String;//GJGYLBHD_N
    private String;//GCHENGLB_N
    private String;//LING_ZU_N
    private String;//TD_TH_LX_N
    private String;//DISPE_N
    private String;//DISASTER_N
    private String;//ZL_DJ_N
    private String;//BC_LD_N
    private String;//SFNRLD_N
    private String;//SFZY_N
    private String;//YOU_SHI__1
    private String;//GH_LZ_N
    private String;//GH_SLLB_N
    private String;//GH_GJJBH_1
    private String;//GH_BHDJ_N
    private String;//DILIX
    private Date;//LZX
    private String;//LZXX
    private String;//BIAO_ZHU 标注
    private String;//LIN_YE_JU_ 林业局名字
    private BigDecimal;//SHAPE_AREA
    private BigDecimal;//SHAPE_LEN
    private String zhuanYongTu;//专题图
    private String diJiBianHao;//地籍编号
}
