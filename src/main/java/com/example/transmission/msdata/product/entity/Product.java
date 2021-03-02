package com.example.transmission.msdata.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Product {

    private static final long serialVersionUID = 1L;
    protected String id;
    protected String remarks;	// 备注
    protected Date createDate;	// 创建日期
    protected Date updateDate;	// 更新日期
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
    protected String companycode; //商户代码
    private ProductCategory productCategory; // 商品分类
    private ProductColor productColor; // 颜色
    private ProductSpecification productSpecification; // 规格
    private ProductUnit productUnit; // 单位
    private ProductModelNumber productModelNumber; // 型号

    private ProductBrand productBrand; // 品牌
    private String name; // 名称
    private String mnemonicCode; // 助记码
    private String commodityInitials; // 商品首字母
    private String barCode; // 条形码
    private String size; // 尺码
    private Date productionDate; // 生产日期
    private String guaranteePeriod; // 保质期
    private String placeOfProduction; // 产地
    private String batchNumber; // 批号
    private String serialzNumber; // 序列号
    private String productCode; // 商品货号
    private String imeiManage; // 是否管理串号，1为管理，0为不管理
    private String screenSize; // 屏幕尺寸
    private String pixel; // 像素
    private String network; // 网络
    private String memory; // 内存
    private String diyTextProperty1; // 自定义属性1（文本型）
    private String diyTextProperty2; // 自定义属性2（文本型）
    private String diyTextProperty3; // 自定义属性3（文本型）
    private String diyTextProperty4; // 自定义属性4（文本型）
    private String diyTextProperty5; // 自定义属性5（文本型）
    private BigDecimal diyNumberProperty1; // 自定义属性1（数值型）
    private BigDecimal diyNumberProperty2; // 自定义属性2（数值型）
    private BigDecimal diyNumberProperty3; // 自定义属性3（数值型）
    private BigDecimal diyNumberProperty4; // 自定义属性4（数值型）
    private BigDecimal diyNumberProperty5; // 自定义属性5（数值型）
    private Date diyTimeProperty1; // 自定义属性1（时间型）
    private Date diyTimeProperty2; // 自定义属性2（时间型）
    private Date diyTimeProperty3; // 自定义属性3（时间型）
    private Date diyTimeProperty4; // 自定义属性4（时间型）
    private Date diyTimeProperty5; // 自定义属性5（时间型）
    private String productDetail; // 商品详情
    private BigDecimal assessmentPrice; // 考核价
    private BigDecimal priceExcludingTax; // 不含税价
    private BigDecimal taxRate; // 税率
    private BigDecimal priceIncludingTax; // 含税价
    private BigDecimal buyingPrice; // 进价
    private BigDecimal retailPrice; // 零售价
    private BigDecimal memberPrice; // 会员价
    private BigDecimal presetPrice1; // 预设售价1
    private BigDecimal presetPrice2; // 预设售价2
    private String priceType; // 价格类型，1为定价，0为议价
    private Date beginCreateDate; // 开始 创建时间
    private Date endCreateDate; // 结束 创建时间
    private Date beginUpdateDate; // 开始 更新时间
    private Date endUpdateDate; // 结束 更新时间
    private List<ProductPhoto> productPhotoList;// 商品图片列表
    private String productImei;

    public String getProductImei() {
        return productImei;
    }

    public void setProductImei(String productImei) {
        this.productImei = productImei;
    }

    public String getId() {
        return id;
    }
    public List<ProductPhoto> getProductPhotoList() {
        return productPhotoList;
    }
    public void setProductPhotoList(List<ProductPhoto> productPhotoList) {
        this.productPhotoList = productPhotoList;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getDelFlag() {
        return delFlag;
    }
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    private ProductMultipleUnit productMultipleUnit;// 多单位
    private String batchManage;// 是否管理批次（1是,0否）
    private String unitType;// 单位类型（0为单单位，1为多单位）
    private String defaultUnit;// 多单位的默认子单位

    private String accountId;
    private String rfid;
    private String rfids;
    private List<String> rfidList;

    private String unitStr; // 产品副单位列表字段格式:ID#NAME#MAIN_UNIT_FLAG,ID#NAME#MAIN_UNIT_FLAG
    public static final String UNIT_TYPE_SINGLE_UNIT = "0";
    public static final String UNIT_TYPE_MULTIPLE_UNIT = "1";

    public ProductSubUnit productSubUnit;

    public ProductUnitPrice productUnitPrice;

//	private String topProCategoryId;
    /**
     * 搜索字段
     *
     * @author 胡婷
     * @version 2017-10-13
     */
    private String searchKey;

    /**
     * 增加库存分布关联字段
     *
     * @author 胡婷
     * @version 2017-11-25
     */
    private String ktypeid; // 入库仓库id
    private String kcnum; // 库存数量

    /**默认成本
     * @author 胡婷
     * @version 2018-05-30
     */
    private String defaultCost;

    private String imeiSelectFlag;//串号查询标识

    private String serialzNumberSelectFlag;//序列号查询标识

    private String loginFlag;//是否是 盘点机登录（0 是；1或者空 否）

    private int heDeFlag;//和德产品标识(若等于0，则不是；反之，则是)

    public String getDefaultCost() {
        return defaultCost;
    }

    public void setDefaultCost(String defaultCost) {
        this.defaultCost = defaultCost;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Product() {
        super();
    }


    public Product(String id, String companycode) {
        super();
        this.id = id;
        this.companycode = companycode;
    }

    public Product(ProductCategory productCategory) {
        super();
        this.productCategory = productCategory;
    }

    public Product(ProductCategory productCategory, String companycode) {
        super();
        this.productCategory = productCategory;
        this.companycode = companycode;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ProductColor getProductColor() {
        return productColor;
    }

    public void setProductColor(ProductColor productColor) {
        this.productColor = productColor;
    }

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    public ProductUnit getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(ProductUnit productUnit) {
        this.productUnit = productUnit;
    }

    public ProductModelNumber getProductModelNumber() {
        return productModelNumber;
    }

    public void setProductModelNumber(ProductModelNumber productModelNumber) {
        this.productModelNumber = productModelNumber;
    }

    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }

    @Length(min = 0, max = 64, message = "名称长度必须介于 0 和 64 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 0, max = 64, message = "助记码长度必须介于 0 和 64 之间")
    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    @Length(min = 0, max = 64, message = "商品首字母长度必须介于 0 和 64 之间")
    public String getCommodityInitials() {
        return commodityInitials;
    }

    public void setCommodityInitials(String commodityInitials) {
        this.commodityInitials = commodityInitials;
    }

    @Length(min = 0, max = 64, message = "条形码长度必须介于 0 和 64 之间")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Length(min = 0, max = 64, message = "尺码长度必须介于 0 和 64 之间")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Length(min = 0, max = 64, message = "保质期长度必须介于 0 和 64 之间")
    public String getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(String guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    @Length(min = 0, max = 64, message = "产地长度必须介于 0 和 64 之间")
    public String getPlaceOfProduction() {
        return placeOfProduction;
    }

    public void setPlaceOfProduction(String placeOfProduction) {
        this.placeOfProduction = placeOfProduction;
    }

    @Length(min = 0, max = 64, message = "批号长度必须介于 0 和 64 之间")
    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Length(min = 0, max = 64, message = "序列号长度必须介于 0 和 64 之间")
    public String getSerialzNumber() {
        return serialzNumber;
    }

    public void setSerialzNumber(String serialzNumber) {
        this.serialzNumber = serialzNumber;
    }

    @Length(min = 0, max = 64, message = "商品货号长度必须介于 0 和 64 之间")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Length(min = 0, max = 1, message = "是否管理串号，1为管理，0为不管理长度必须介于 0 和 1 之间")
    public String getImeiManage() {
        return imeiManage;
    }

    public void setImeiManage(String imeiManage) {
        this.imeiManage = imeiManage;
    }

    @Length(min = 0, max = 64, message = "屏幕尺寸长度必须介于 0 和 64 之间")
    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    @Length(min = 0, max = 64, message = "像素长度必须介于 0 和 64 之间")
    public String getPixel() {
        return pixel;
    }

    public void setPixel(String pixel) {
        this.pixel = pixel;
    }

    @Length(min = 0, max = 64, message = "网络长度必须介于 0 和 64 之间")
    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    @Length(min = 0, max = 64, message = "内存长度必须介于 0 和 64 之间")
    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Length(min = 0, max = 64, message = "自定义属性1（文本型）长度必须介于 0 和 64 之间")
    public String getDiyTextProperty1() {
        return diyTextProperty1;
    }

    public void setDiyTextProperty1(String diyTextProperty1) {
        this.diyTextProperty1 = diyTextProperty1;
    }

    @Length(min = 0, max = 64, message = "自定义属性2（文本型）长度必须介于 0 和 64 之间")
    public String getDiyTextProperty2() {
        return diyTextProperty2;
    }

    public void setDiyTextProperty2(String diyTextProperty2) {
        this.diyTextProperty2 = diyTextProperty2;
    }

    @Length(min = 0, max = 64, message = "自定义属性3（文本型）长度必须介于 0 和 64 之间")
    public String getDiyTextProperty3() {
        return diyTextProperty3;
    }

    public void setDiyTextProperty3(String diyTextProperty3) {
        this.diyTextProperty3 = diyTextProperty3;
    }

    @Length(min = 0, max = 64, message = "自定义属性4（文本型）长度必须介于 0 和 64 之间")
    public String getDiyTextProperty4() {
        return diyTextProperty4;
    }

    public void setDiyTextProperty4(String diyTextProperty4) {
        this.diyTextProperty4 = diyTextProperty4;
    }

    @Length(min = 0, max = 64, message = "自定义属性5（文本型）长度必须介于 0 和 64 之间")
    public String getDiyTextProperty5() {
        return diyTextProperty5;
    }

    public void setDiyTextProperty5(String diyTextProperty5) {
        this.diyTextProperty5 = diyTextProperty5;
    }

    @DecimalMin(value = "-99999999.99", message = "自定义属性1（数值型）不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "自定义属性1（数值型）不能大于99999999.99")
    public BigDecimal getDiyNumberProperty1() {
        return diyNumberProperty1;
    }

    public void setDiyNumberProperty1(BigDecimal diyNumberProperty1) {
        this.diyNumberProperty1 = diyNumberProperty1;
    }

    @DecimalMin(value = "-99999999.99", message = "自定义属性2（数值型）不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "自定义属性2（数值型）不能大于99999999.99")
    public BigDecimal getDiyNumberProperty2() {
        return diyNumberProperty2;
    }

    public void setDiyNumberProperty2(BigDecimal diyNumberProperty2) {
        this.diyNumberProperty2 = diyNumberProperty2;
    }

    @DecimalMin(value = "-99999999.99", message = "自定义属性3（数值型）不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "自定义属性3（数值型）不能大于99999999.99")
    public BigDecimal getDiyNumberProperty3() {
        return diyNumberProperty3;
    }

    public void setDiyNumberProperty3(BigDecimal diyNumberProperty3) {
        this.diyNumberProperty3 = diyNumberProperty3;
    }

    @DecimalMin(value = "-99999999.99", message = "自定义属性4（数值型）不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "自定义属性4（数值型）不能大于99999999.99")
    public BigDecimal getDiyNumberProperty4() {
        return diyNumberProperty4;
    }

    public void setDiyNumberProperty4(BigDecimal diyNumberProperty4) {
        this.diyNumberProperty4 = diyNumberProperty4;
    }

    @DecimalMin(value = "-99999999.99", message = "自定义属性5（数值型）不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "自定义属性5（数值型）不能大于99999999.99")
    public BigDecimal getDiyNumberProperty5() {
        return diyNumberProperty5;
    }

    public void setDiyNumberProperty5(BigDecimal diyNumberProperty5) {
        this.diyNumberProperty5 = diyNumberProperty5;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDiyTimeProperty1() {
        return diyTimeProperty1;
    }

    public void setDiyTimeProperty1(Date diyTimeProperty1) {
        this.diyTimeProperty1 = diyTimeProperty1;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDiyTimeProperty2() {
        return diyTimeProperty2;
    }

    public void setDiyTimeProperty2(Date diyTimeProperty2) {
        this.diyTimeProperty2 = diyTimeProperty2;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDiyTimeProperty3() {
        return diyTimeProperty3;
    }

    public void setDiyTimeProperty3(Date diyTimeProperty3) {
        this.diyTimeProperty3 = diyTimeProperty3;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDiyTimeProperty4() {
        return diyTimeProperty4;
    }

    public void setDiyTimeProperty4(Date diyTimeProperty4) {
        this.diyTimeProperty4 = diyTimeProperty4;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDiyTimeProperty5() {
        return diyTimeProperty5;
    }

    public void setDiyTimeProperty5(Date diyTimeProperty5) {
        this.diyTimeProperty5 = diyTimeProperty5;
    }

    @Length(min = 0, max = 5000, message = "商品详情长度必须介于 0 和5000 之间")
    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @DecimalMin(value = "-99999999.99", message = "考核价不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "考核价不能大于99999999.99")
    public BigDecimal getAssessmentPrice() {
        return assessmentPrice;
    }

    public void setAssessmentPrice(BigDecimal assessmentPrice) {
        this.assessmentPrice = assessmentPrice;
    }

    @DecimalMin(value = "-99999999.99", message = "不含税价不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "不含税价不能大于99999999.99")
    public BigDecimal getPriceExcludingTax() {
        return priceExcludingTax;
    }

    public void setPriceExcludingTax(BigDecimal priceExcludingTax) {
        this.priceExcludingTax = priceExcludingTax;
    }

    @DecimalMin(value = "-99999999.99", message = "税率不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "税率不能大于99999999.99")
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @DecimalMin(value = "-99999999.99", message = "含税价不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "含税价不能大于99999999.99")
    public BigDecimal getPriceIncludingTax() {
        return priceIncludingTax;
    }

    public void setPriceIncludingTax(BigDecimal priceIncludingTax) {
        this.priceIncludingTax = priceIncludingTax;
    }

    @DecimalMin(value = "-99999999.99", message = "进价不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "进价不能大于99999999.99")
    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @DecimalMin(value = "-99999999.99", message = "零售价不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "零售价不能大于99999999.99")
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    @DecimalMin(value = "-99999999.99", message = "会员价不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "会员价不能大于99999999.99")
    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    @DecimalMin(value = "-99999999.99", message = "预设售价1不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "预设售价1不能大于99999999.99")
    public BigDecimal getPresetPrice1() {
        return presetPrice1;
    }

    public void setPresetPrice1(BigDecimal presetPrice1) {
        this.presetPrice1 = presetPrice1;
    }

    @DecimalMin(value = "-99999999.99", message = "预设售价2不能小于-99999999.99")
    @DecimalMax(value = "99999999.99", message = "预设售价2不能大于99999999.99")
    public BigDecimal getPresetPrice2() {
        return presetPrice2;
    }

    public void setPresetPrice2(BigDecimal presetPrice2) {
        this.presetPrice2 = presetPrice2;
    }

    @Length(min = 0, max = 1, message = "价格类型，1为定价，0为议价长度必须介于 0 和 1 之间")
    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Date getBeginCreateDate() {
        return beginCreateDate;
    }

    public void setBeginCreateDate(Date beginCreateDate) {
        this.beginCreateDate = beginCreateDate;
    }

    public Date getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(Date endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    public Date getBeginUpdateDate() {
        return beginUpdateDate;
    }

    public void setBeginUpdateDate(Date beginUpdateDate) {
        this.beginUpdateDate = beginUpdateDate;
    }

    public Date getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(Date endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }

    public String getKtypeid() {
        return ktypeid;
    }

    public void setKtypeid(String ktypeid) {
        this.ktypeid = ktypeid;
    }

    public String getKcnum() {
        return kcnum;
    }

    public void setKcnum(String kcnum) {
        this.kcnum = kcnum;
    }

    public ProductMultipleUnit getProductMultipleUnit() {
        return productMultipleUnit;
    }

    public void setProductMultipleUnit(ProductMultipleUnit productMultipleUnit) {
        this.productMultipleUnit = productMultipleUnit;
    }

    public String getBatchManage() {
        return batchManage;
    }

    public void setBatchManage(String batchManage) {
        this.batchManage = batchManage;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitStr() {
        return unitStr;
    }

    public void setUnitStr(String unitStr) {
        this.unitStr = unitStr;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getRfids() {
        return rfids;
    }

    public void setRfids(String rfids) {
        this.rfids = rfids;
    }

    public List<String> getRfidList() {
        return rfidList;
    }

    public void setRfidList(List<String> rfidList) {
        this.rfidList = rfidList;
    }

    public String getImeiSelectFlag() {
        return imeiSelectFlag;
    }

    public void setImeiSelectFlag(String imeiSelectFlag) {
        this.imeiSelectFlag = imeiSelectFlag;
    }

    public String getSerialzNumberSelectFlag() {
        return serialzNumberSelectFlag;
    }

    public void setSerialzNumberSelectFlag(String serialzNumberSelectFlag) {
        this.serialzNumberSelectFlag = serialzNumberSelectFlag;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public int getHeDeFlag() {
        return heDeFlag;
    }

    public void setHeDeFlag(int heDeFlag) {
        this.heDeFlag = heDeFlag;
    }

    public static String getUnitTypeSingleUnit() {
        return UNIT_TYPE_SINGLE_UNIT;
    }

    public static String getUnitTypeMultipleUnit() {
        return UNIT_TYPE_MULTIPLE_UNIT;
    }

    public ProductSubUnit getProductSubUnit() {
        return productSubUnit;
    }

    public void setProductSubUnit(ProductSubUnit productSubUnit) {
        this.productSubUnit = productSubUnit;
    }

    public ProductUnitPrice getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(ProductUnitPrice productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

	/*public String getTopProCategoryId() {
		return topProCategoryId;
	}


	public void setTopProCategoryId(String topProCategoryId) {
		this.topProCategoryId = topProCategoryId;
	}*/
}
