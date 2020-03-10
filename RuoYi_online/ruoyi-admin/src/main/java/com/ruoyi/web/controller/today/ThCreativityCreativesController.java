package com.ruoyi.web.controller.today;

import java.util.List;

import com.ruoyi.today.domain.*;
import com.ruoyi.today.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 创意Controller
 *
 * @author ruoyi
 * @date 2019-09-09
 */
@Controller
@RequestMapping("/today/creatives")
public class ThCreativityCreativesController extends BaseController {
    private String prefix = "today/creatives";

    @Autowired
    private IThCreativityCreativesService thCreativityCreativesService;
    @Autowired
    private IThAdMateriaService materiaService;

    @RequiresPermissions("today:creatives:view")
    @GetMapping("/{id}")
    public String creatives(@PathVariable("id") String id, ModelMap mmap) {
        mmap.put("id", id);
        return prefix + "/creatives";
    }

    @Autowired
    private IThAdvertiserService thAdvertiserService;
    @Autowired
    private IThAdService thAdService;

    /**
     * 查询创意列表
     */
    @PostMapping("/listInfo")
    @ResponseBody
    public TableDataInfo listInfo(ThCreativityCreatives thCreativityCreatives) {
//        startPage();
        List<ThCreativityCreatives> list = thCreativityCreativesService.selectThCreativityCreativesList(thCreativityCreatives);
        return getDataTable(list);
    }

    /**
     * 同步广告组
     *
     * @return
     */
    @PostMapping("/syncCreativities")
    @ResponseBody
    public AjaxResult syncCreativities(String advertiserId, String adId) {

        StringBuilder msg = new StringBuilder();
        //若广告主或广告计划id没有，则同步广告主下或广告计划下的所有创意
        ThAdvertiser thAdvertiser = new ThAdvertiser();
        ThAd thAd = new ThAd();
        ThCreativityCreatives creatives = new ThCreativityCreatives();
        if (advertiserId != null && !advertiserId.equals("")) {
            thAdvertiser.setId(Long.valueOf(advertiserId));
        }
        List<ThAdvertiser> thAdvertisers = thAdvertiserService.selectThAdvertiserList(thAdvertiser);
        for (ThAdvertiser advertiser : thAdvertisers) {
            try {
                if (adId != null && !adId.equals("")) {
                    thAd.setAdId(Long.valueOf(adId));
                }
                List<ThAd> thAds = thAdService.selectThAdList(thAd);
                for (ThAd ad : thAds) {
                    creatives.setAdvertiserId(advertiser.getId().toString());
                    creatives.setAdId(ad.getAdId().toString());
                    thCreativityCreativesService.syncCreativities(creatives);
                }
            } catch (Exception e) {
                logger.error("出现错误：", e);
                msg.append(e.getMessage());
            }
        }
        if (msg.length() == 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error(msg.toString());
        }
    }

    /**
     * 查询创意列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThCreativityCreatives thCreativityCreatives) {
        startPage();
        List<ThCreativityCreatives> list = thCreativityCreativesService.selectThCreativityCreativesList(thCreativityCreatives);
        StringBuffer filesUrl = null;
        //处理素材url，使其在前端显示
        for (ThCreativityCreatives creatives : list) {
            filesUrl = new StringBuffer();
            if (creatives.getImageMode().contains("VIDEO")) {
                if (creatives.getImageId() != null) {
                    ThAdMateria materia = materiaService.selectThAdMateriaByMediaMateria(creatives.getImageId());
                    if (materia != null) {
                        filesUrl.append("video,");
                        filesUrl.append(materia.getLocalPath().split("//")[1] + ",");
                    }
                }
                if (creatives.getVideoId() != null) {
                    ThAdMateria materia = materiaService.selectThAdMateriaByMediaMateria(creatives.getVideoId());
                    if (materia != null) {
                        filesUrl.append(materia.getLocalPath().split("//")[1]);
                    }
                }
            } else {
                if (creatives.getImageIds() != null) {
                    filesUrl.append("image,");
                    String[] imageIdArray = creatives.getImageIds().split(",");
                    for (String imageid : imageIdArray) {
                        ThAdMateria materia = materiaService.selectThAdMateriaByMediaMateria(imageid);
                        if (materia != null) {
                            filesUrl.append(materia.getLocalPath().split("//")[1] + ",");
                        }
                    }
                }
                if (filesUrl.length() != 0) {
                    filesUrl = new StringBuffer(filesUrl.substring(0, filesUrl.length() - 1));
                }
            }
            if (filesUrl.length() != 0) {
                creatives.setFilesUrl(filesUrl.toString());
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出创意列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThCreativityCreatives thCreativityCreatives) {
        List<ThCreativityCreatives> list = thCreativityCreativesService.selectThCreativityCreativesList(thCreativityCreatives);
        ExcelUtil<ThCreativityCreatives> util = new ExcelUtil<ThCreativityCreatives>(ThCreativityCreatives.class);
        return util.exportExcel(list, "creatives");
    }

    /**
     * 新增创意
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存创意
     */
    @RequiresPermissions("system:creatives:add")
    @Log(title = "创意", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ThCreativityCreatives thCreativityCreatives) {
        return toAjax(thCreativityCreativesService.insertThCreativityCreatives(thCreativityCreatives));
    }

    /**
     * 修改创意
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ThCreativityCreatives thCreativityCreatives = thCreativityCreativesService.selectThCreativityCreativesById(id);
        mmap.put("thCreativityCreatives", thCreativityCreatives);
        return prefix + "/edit";
    }

    /**
     * 修改保存创意
     */
    @Log(title = "创意", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThCreativityCreatives thCreativityCreatives) {
        return toAjax(thCreativityCreativesService.updateThCreativityCreatives(thCreativityCreatives));
    }

    /**
     * 删除创意
     */
    @Log(title = "创意", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(thCreativityCreativesService.deleteThCreativityCreativesByIds(ids));
    }
}
