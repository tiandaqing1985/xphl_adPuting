package com.ruoyi.web.controller.yiche;

import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.yiche.domain.Yiche;
import com.ruoyi.yiche.service.IYicheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@Controller
public class YiCheController {

    @Autowired
    private IYicheService yicheService;

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        FileWriter fileWriter = null;
        File file = null;
        try {
            file = new File("BaiduShanTou.xml");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            fileWriter.write("<urlset>\n");
            fileWriter.flush();

            List<Yiche> yiches = yicheService.selectYicheList(new Yiche());
            for (Yiche yiche : yiches) {

                fileWriter.write("" +
                        "  <url>\n" +
                        "    <loc><![CDATA[" + getVal(yiche.getLoc()) + "]]></loc>\n" +
                        "    <pcLoc><![CDATA[" + getVal(yiche.getPcloc()) + "]]></pcLoc>\n" +
                        "    <data>\n" +
                        "      <name><![CDATA[" + getVal(yiche.getName()) + "]]></name>\n" +
                        "      <outerID><![CDATA[" + getVal(yiche.getOuterid()) + "]]></outerID>\n" +
                        "      <bizCategory><![CDATA[" + getVal(yiche.getBizcategory()) + "]]></bizCategory>\n" +
                        "      <brand><![CDATA[" + getVal(yiche.getBrand()) + "]]></brand>\n" +
                        "      <manufacturer><![CDATA[" + getVal(yiche.getManufacturer()) + "]]></manufacturer>\n" +
                        "      <type><![CDATA[" + getVal(yiche.getType()) + "]]></type>\n" +
                        "      <grade><![CDATA[" + getVal(yiche.getGrade()) + "]]></grade>\n" +
                        "      <sellerName><![CDATA[" + getVal(yiche.getSellername()) + "]]></sellerName>\n" +
                        "      <nationality><![CDATA[" + getVal(yiche.getNationality()) + "]]></nationality>\n" +
                        "      <enBrand><![CDATA[" + getVal(yiche.getEnbrand()) + "]]></enBrand>\n" +
                        "      <modelYear><![CDATA[" + getVal(yiche.getModelyear()) + "]]></modelYear>\n" +
                        "      <priceRange>" + getVal(yiche.getPrice()) + "</priceRange>\n" +
                        "      <priceUnit>" + getVal(yiche.getPriceunit()) + "</priceUnit>\n" +
                        "      <unit><![CDATA[" + getVal(yiche.getUnit()) + "]]></unit>\n" +
                        "      <MSRP>" + getVal(yiche.getMsrp()) + "</MSRP>\n" +
                        "      <timeToMarket><![CDATA[" + getVal(yiche.getTimetomarket()) + "]]></timeToMarket>\n" +
                        "      <image><![CDATA[" + getVal(yiche.getImage()) + "]]></image>\n" +
                        "      <moreImages>\n" +
                        "        <img index=\"1\"><![CDATA[" + getVal(yiche.getMoreimages1()) + "]]></img>\n" +
                        "        <img index=\"2\"><![CDATA[" + getVal(yiche.getMoreimages2()) + "]]></img>\n" +
                        "        <img index=\"3\"><![CDATA[" + getVal(yiche.getMoreimages3()) + "]]></img>\n" +
                        "      </moreImages>\n" +
                        "      <volume>" + getVal(yiche.getVolume()) + "</volume>\n" +
                        "      <volumeUnit><![CDATA[" + getVal(yiche.getVolumeunit()) + "]]></volumeUnit>\n" +
                        "      <integratedFuelConsumption><![CDATA[" + getVal(yiche.getIntegratedfuelconsumption()) + "]]></integratedFuelConsumption>\n" +
                        "      <engine><![CDATA[" + getVal(yiche.getEngine()) + "]]></engine>\n" +
                        "      <gearbox><![CDATA[" + getVal(yiche.getGearbox()) + "]]></gearbox>\n" +
                        "      <speed><![CDATA[" + getVal(yiche.getSpeed()) + "]]></speed>\n" +
                        "      <structure><![CDATA[" + getVal(yiche.getStructure()) + "]]></structure>\n" +
                        "      <accelerationTime><![CDATA[" + getVal(yiche.getAccelerationtime()) + "]]></accelerationTime>\n" +
                        "      <seatCapacity><![CDATA[" + getVal(yiche.getSeatcapacity()) + "]]></seatCapacity>\n" +
                        "      <fuel><![CDATA[" + getVal(yiche.getFuel()) + "]]></fuel>\n" +
                        "      <environmentalStandard><![CDATA[" + getVal(yiche.getEnvironmentalstandard()) + "]]></environmentalStandard>\n" +
                        "      <exteriorColor><![CDATA[" + getVal(yiche.getExteriorcolor()) + "]]></exteriorColor>\n" +
                        "      <interiorColor><![CDATA[" + getVal(yiche.getInteriorcolor()) + "]]></interiorColor>\n" +
                        "      <qualityAssurance><![CDATA[" + getVal(yiche.getQualityassurance()) + "]]></qualityAssurance>\n" +
                        "      <category><![CDATA[" + getVal(yiche.getCategory()) + "]]></category>\n" +
                        "      <categoryUrl><![CDATA[" + getVal(yiche.getCategorypcurl()) + "]]></categoryUrl>\n" +
                        "      <categoryPcUrl><![CDATA[" + getVal(yiche.getCategorypcurl()) + "]]></categoryPcUrl>\n" +
                        "      <subCategory><![CDATA[" + getVal(yiche.getSubcategory()) + "]]></subCategory>\n" +
                        "      <subCategoryUrl><![CDATA[" + getVal(yiche.getSubcategoryurl()) + "]]></subCategoryUrl>\n" +
                        "      <subCategoryPcUrl><![CDATA[" + getVal(yiche.getSubcategorypcurl()) + "]]></subCategoryPcUrl>\n" +
                        "      <thirdCategory><![CDATA[" + getVal(yiche.getThirdcategory()) + "]]></thirdCategory>\n" +
                        "      <thirdCategoryUrl><![CDATA[" + getVal(yiche.getThirdcategoryurl()) + "]]></thirdCategoryUrl>\n" +
                        "      <thirdCategoryPcUrl><![CDATA[" + getVal(yiche.getThirdcategorypcurl()) + "]]></thirdCategoryPcUrl>\n" +
                        "      <choice>\n" +
                        "        <attribute>\n" +
                        "          <key><![CDATA[targetUrlH5]]></key>\n" +
                        "          <value><![CDATA[" + getVal(yiche.getValue1()) + "]]></value>\n" +
                        "        </attribute>\n" +
                        "        <attribute>\n" +
                        "          <key><![CDATA[mpUrl]]></key>\n" +
                        "          <value><![CDATA[" + getVal(yiche.getValue2()) + "]]></value>\n" +
                        "        </attribute>\n" +
                        "        <attribute>\n" +
                        "          <key><![CDATA[mtgurl]]></key>\n" +
                        "          <value><![CDATA[" + getVal(yiche.getValue3()) + "]]></value>\n" +
                        "        </attribute>\n" +
                        "      </choice>\n" +
                        "    </data>\n" +
                        "  </url>\n");

                fileWriter.flush();
            }
            fileWriter.write("</urlset>");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
        ServletOutputStream outputStream = null;
        try {

            // 下载名称
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" +
                    ".xml");
            outputStream = response.getOutputStream();
            FileUtils.writeBytes(file.getAbsolutePath(), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }

    private String getVal(String val) {
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }

}
