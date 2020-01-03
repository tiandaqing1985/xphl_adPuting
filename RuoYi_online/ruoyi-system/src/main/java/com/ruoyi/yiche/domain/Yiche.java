package com.ruoyi.yiche.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 yiche
 * 
 * @author ruoyi
 * @date 2019-11-21
 */
public class Yiche extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String loc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pcloc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String outerid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String bizcategory;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String brand;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String manufacturer;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String grade;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sellername;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nationality;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String enbrand;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String modelyear;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String price;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String priceunit;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String unit;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String msrp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String timetomarket;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String image;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String moreimages1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String moreimages2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String moreimages3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String volume;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String volumeunit;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String integratedfuelconsumption;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String engine;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gearbox;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String speed;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String structure;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String accelerationtime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String seatcapacity;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String fuel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String environmentalstandard;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String exteriorcolor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String interiorcolor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String qualityassurance;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String category;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String categoryurl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String categorypcurl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String subcategory;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String subcategoryurl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String subcategorypcurl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String thirdcategory;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String thirdcategoryurl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String thirdcategorypcurl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String key1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String key2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String key3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String value1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String value2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String value3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLoc(String loc) 
    {
        this.loc = loc;
    }

    public String getLoc() 
    {
        return loc;
    }
    public void setPcloc(String pcloc) 
    {
        this.pcloc = pcloc;
    }

    public String getPcloc() 
    {
        return pcloc;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setOuterid(String outerid) 
    {
        this.outerid = outerid;
    }

    public String getOuterid() 
    {
        return outerid;
    }
    public void setBizcategory(String bizcategory) 
    {
        this.bizcategory = bizcategory;
    }

    public String getBizcategory() 
    {
        return bizcategory;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setSellername(String sellername) 
    {
        this.sellername = sellername;
    }

    public String getSellername() 
    {
        return sellername;
    }
    public void setNationality(String nationality) 
    {
        this.nationality = nationality;
    }

    public String getNationality() 
    {
        return nationality;
    }
    public void setEnbrand(String enbrand) 
    {
        this.enbrand = enbrand;
    }

    public String getEnbrand() 
    {
        return enbrand;
    }
    public void setModelyear(String modelyear) 
    {
        this.modelyear = modelyear;
    }

    public String getModelyear() 
    {
        return modelyear;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }
    public void setPriceunit(String priceunit) 
    {
        this.priceunit = priceunit;
    }

    public String getPriceunit() 
    {
        return priceunit;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setMsrp(String msrp) 
    {
        this.msrp = msrp;
    }

    public String getMsrp() 
    {
        return msrp;
    }
    public void setTimetomarket(String timetomarket) 
    {
        this.timetomarket = timetomarket;
    }

    public String getTimetomarket() 
    {
        return timetomarket;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setMoreimages1(String moreimages1) 
    {
        this.moreimages1 = moreimages1;
    }

    public String getMoreimages1() 
    {
        return moreimages1;
    }
    public void setMoreimages2(String moreimages2) 
    {
        this.moreimages2 = moreimages2;
    }

    public String getMoreimages2() 
    {
        return moreimages2;
    }
    public void setMoreimages3(String moreimages3) 
    {
        this.moreimages3 = moreimages3;
    }

    public String getMoreimages3() 
    {
        return moreimages3;
    }
    public void setVolume(String volume) 
    {
        this.volume = volume;
    }

    public String getVolume() 
    {
        return volume;
    }
    public void setVolumeunit(String volumeunit) 
    {
        this.volumeunit = volumeunit;
    }

    public String getVolumeunit() 
    {
        return volumeunit;
    }
    public void setIntegratedfuelconsumption(String integratedfuelconsumption) 
    {
        this.integratedfuelconsumption = integratedfuelconsumption;
    }

    public String getIntegratedfuelconsumption() 
    {
        return integratedfuelconsumption;
    }
    public void setEngine(String engine) 
    {
        this.engine = engine;
    }

    public String getEngine() 
    {
        return engine;
    }
    public void setGearbox(String gearbox) 
    {
        this.gearbox = gearbox;
    }

    public String getGearbox() 
    {
        return gearbox;
    }
    public void setSpeed(String speed) 
    {
        this.speed = speed;
    }

    public String getSpeed() 
    {
        return speed;
    }
    public void setStructure(String structure) 
    {
        this.structure = structure;
    }

    public String getStructure() 
    {
        return structure;
    }
    public void setAccelerationtime(String accelerationtime) 
    {
        this.accelerationtime = accelerationtime;
    }

    public String getAccelerationtime() 
    {
        return accelerationtime;
    }
    public void setSeatcapacity(String seatcapacity) 
    {
        this.seatcapacity = seatcapacity;
    }

    public String getSeatcapacity() 
    {
        return seatcapacity;
    }
    public void setFuel(String fuel) 
    {
        this.fuel = fuel;
    }

    public String getFuel() 
    {
        return fuel;
    }
    public void setEnvironmentalstandard(String environmentalstandard) 
    {
        this.environmentalstandard = environmentalstandard;
    }

    public String getEnvironmentalstandard() 
    {
        return environmentalstandard;
    }
    public void setExteriorcolor(String exteriorcolor) 
    {
        this.exteriorcolor = exteriorcolor;
    }

    public String getExteriorcolor() 
    {
        return exteriorcolor;
    }
    public void setInteriorcolor(String interiorcolor) 
    {
        this.interiorcolor = interiorcolor;
    }

    public String getInteriorcolor() 
    {
        return interiorcolor;
    }
    public void setQualityassurance(String qualityassurance) 
    {
        this.qualityassurance = qualityassurance;
    }

    public String getQualityassurance() 
    {
        return qualityassurance;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setCategoryurl(String categoryurl) 
    {
        this.categoryurl = categoryurl;
    }

    public String getCategoryurl() 
    {
        return categoryurl;
    }
    public void setCategorypcurl(String categorypcurl) 
    {
        this.categorypcurl = categorypcurl;
    }

    public String getCategorypcurl() 
    {
        return categorypcurl;
    }
    public void setSubcategory(String subcategory) 
    {
        this.subcategory = subcategory;
    }

    public String getSubcategory() 
    {
        return subcategory;
    }
    public void setSubcategoryurl(String subcategoryurl) 
    {
        this.subcategoryurl = subcategoryurl;
    }

    public String getSubcategoryurl() 
    {
        return subcategoryurl;
    }
    public void setSubcategorypcurl(String subcategorypcurl) 
    {
        this.subcategorypcurl = subcategorypcurl;
    }

    public String getSubcategorypcurl() 
    {
        return subcategorypcurl;
    }
    public void setThirdcategory(String thirdcategory) 
    {
        this.thirdcategory = thirdcategory;
    }

    public String getThirdcategory() 
    {
        return thirdcategory;
    }
    public void setThirdcategoryurl(String thirdcategoryurl) 
    {
        this.thirdcategoryurl = thirdcategoryurl;
    }

    public String getThirdcategoryurl() 
    {
        return thirdcategoryurl;
    }
    public void setThirdcategorypcurl(String thirdcategorypcurl) 
    {
        this.thirdcategorypcurl = thirdcategorypcurl;
    }

    public String getThirdcategorypcurl() 
    {
        return thirdcategorypcurl;
    }
    public void setKey1(String key1) 
    {
        this.key1 = key1;
    }

    public String getKey1() 
    {
        return key1;
    }
    public void setKey2(String key2) 
    {
        this.key2 = key2;
    }

    public String getKey2() 
    {
        return key2;
    }
    public void setKey3(String key3) 
    {
        this.key3 = key3;
    }

    public String getKey3() 
    {
        return key3;
    }
    public void setValue1(String value1) 
    {
        this.value1 = value1;
    }

    public String getValue1() 
    {
        return value1;
    }
    public void setValue2(String value2) 
    {
        this.value2 = value2;
    }

    public String getValue2() 
    {
        return value2;
    }
    public void setValue3(String value3) 
    {
        this.value3 = value3;
    }

    public String getValue3() 
    {
        return value3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("loc", getLoc())
            .append("pcloc", getPcloc())
            .append("name", getName())
            .append("outerid", getOuterid())
            .append("bizcategory", getBizcategory())
            .append("brand", getBrand())
            .append("manufacturer", getManufacturer())
            .append("type", getType())
            .append("grade", getGrade())
            .append("sellername", getSellername())
            .append("nationality", getNationality())
            .append("enbrand", getEnbrand())
            .append("modelyear", getModelyear())
            .append("price", getPrice())
            .append("priceunit", getPriceunit())
            .append("unit", getUnit())
            .append("msrp", getMsrp())
            .append("timetomarket", getTimetomarket())
            .append("image", getImage())
            .append("moreimages1", getMoreimages1())
            .append("moreimages2", getMoreimages2())
            .append("moreimages3", getMoreimages3())
            .append("volume", getVolume())
            .append("volumeunit", getVolumeunit())
            .append("integratedfuelconsumption", getIntegratedfuelconsumption())
            .append("engine", getEngine())
            .append("gearbox", getGearbox())
            .append("speed", getSpeed())
            .append("structure", getStructure())
            .append("accelerationtime", getAccelerationtime())
            .append("seatcapacity", getSeatcapacity())
            .append("fuel", getFuel())
            .append("environmentalstandard", getEnvironmentalstandard())
            .append("exteriorcolor", getExteriorcolor())
            .append("interiorcolor", getInteriorcolor())
            .append("qualityassurance", getQualityassurance())
            .append("category", getCategory())
            .append("categoryurl", getCategoryurl())
            .append("categorypcurl", getCategorypcurl())
            .append("subcategory", getSubcategory())
            .append("subcategoryurl", getSubcategoryurl())
            .append("subcategorypcurl", getSubcategorypcurl())
            .append("thirdcategory", getThirdcategory())
            .append("thirdcategoryurl", getThirdcategoryurl())
            .append("thirdcategorypcurl", getThirdcategorypcurl())
            .append("key1", getKey1())
            .append("key2", getKey2())
            .append("key3", getKey3())
            .append("value1", getValue1())
            .append("value2", getValue2())
            .append("value3", getValue3())
            .toString();
    }
}
