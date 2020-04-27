package com.ruoyi.web.controller.today;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.today.domain.*;
import com.ruoyi.today.domain.enums.VideoOrderStatusEnum;
import com.ruoyi.today.domain.request.CreativitiesVideoRequest;
import com.ruoyi.today.service.*;
import com.ruoyi.today.tools.PmsUploadUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.TableHeaderUI;

/**
 * 视频订单Controller
 *
 * @author ruoyi
 * @date 2020-03-02
 */
@Controller
@RequestMapping("/today/video")
public class ThVideoOrderController extends BaseController {
    private String prefix = "today/video";

    @Autowired
    private IThVideoOrderService thVideoOrderService;
    @Autowired
    private ISysDictDataService dictDataService;
    @Autowired
    private IThVideoMatterService thVideoMatterService;
    @Autowired
    private IThCreativityService thCreativityService;
    @Autowired
    private IThVideoMatterManageService thVideoMatterManageService;
    @Autowired
    private ISysPostService sysPostService;
    @Autowired
    private IThVideoMatterReportService thVideoMatterReportService;
//    @Autowired
//    private IThVideoMatterTodayService thVideoMatterTodayService;

    @RequiresPermissions("today:materia:view")
    @GetMapping("/materia")
    public String materia(ModelMap modelMap) {
        ThMatterManage thMatterManage = new ThMatterManage();
        List<ThMatterManage> list = thVideoMatterManageService.selectMatter(thMatterManage);
        modelMap.put("videoOrders", list);
        return prefix + "/materia";
    }

    @PostMapping("/materia")
    @ResponseBody
    public List<ThMatterManage> materia(ThMatterManage thMatterManage) {
        if (thMatterManage.getSql() == null) {
            thMatterManage.setSql("");
        }
        thMatterManage.setSql(thMatterManage.getSql() + " limit " + ((thMatterManage.getPage() - 1) * 6) + ",6");
        List<ThMatterManage> list = thVideoMatterManageService.selectMatter(thMatterManage);
        return list;
    }

    @PostMapping("/materiaCostSum")
    @ResponseBody
    public String materiaCostSum(ThMatterManage thMatterManage) {
        String sum = thVideoMatterManageService.selectMatterCostSum(thMatterManage);
        return sum;
    }

    @PostMapping("/materiaCount")
    @ResponseBody
    public int materiaCount(ThMatterManage thMatterManage) {
        int i = thVideoMatterManageService.selectMatterCount(thMatterManage);
        return i;
    }

    @GetMapping("/materiaImage")
    public String materiaImage(ModelMap modelMap) {
        return prefix + "/materiaImage";
    }

    @PostMapping("/materiaImage")
    @ResponseBody
    public List<ThMatterManage> materiaImage(ThMatterManage thMatterManage) {
        if (thMatterManage.getSql() == null) {
            thMatterManage.setSql("order by a.id desc");
        }
        thMatterManage.setSql(thMatterManage.getSql() + " limit " + ((thMatterManage.getPage() - 1) * 6) + ",6");
        List<ThMatterManage> list = thVideoMatterManageService.selectImageMatter(thMatterManage);
        return list;
    }

    @PostMapping("/materiaImageCostSum")
    @ResponseBody
    public String materiaImageCostSum(ThMatterManage thMatterManage) {
        String sum = thVideoMatterManageService.selectImageMatterCostSum(thMatterManage);
        return sum;
    }

    @PostMapping("/materiaImageCount")
    @ResponseBody
    public int materiaImageCount(ThMatterManage thMatterManage) {
        int i = thVideoMatterManageService.selectImageMatterCount(thMatterManage);
        return i;
    }

    @RequiresPermissions("today:order:view")
    @GetMapping()
    public String order(ModelMap modelMap) {

        modelMap.put("userId", ShiroUtils.getUserId());

        return prefix + "/order";
    }

    @GetMapping("/reportOrderView/{id}")
    public String reportOrderView(@PathVariable("id") String id, ModelMap modelMap) {

        modelMap.put("id", id);

        return prefix + "/reportOrderView";
    }

    @PostMapping("/reportOrderView")
    @ResponseBody
    public List<MatterReportVO> reportOrderView(MatterReportVO matterReportVO) {

        if (matterReportVO.getRangeTime() == null || matterReportVO.getRangeTime().equals("")) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -1);
            Date etime = calendar.getTime();
            calendar.add(Calendar.DATE, -7);
            Date stime = calendar.getTime();
            matterReportVO.setRangeTime(DateUtils.parseDateToStr("yyyy-MM-dd", stime) + " - " + DateUtils.parseDateToStr("yyyy-MM-dd", etime));
        }

        List<MatterReportVO> list = thVideoMatterReportService.selectGroupByTimeList(matterReportVO);
        List<MatterReportVO> datas = new ArrayList<>();
        String[] dates = matterReportVO.getRangeTime().split(" - ");
        String sDate = dates[0];
        String eDate = dates[1];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.dateTime("yyyy-MM-dd", sDate));
        int j = 0;
        for (int i = 1; !DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime()).equals(eDate); i++) {
            if (list.size() == j) {
                datas.add(new MatterReportVO(DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime())));
            } else if (DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime()).equals(list.get(j).getReportTime())) {
                datas.add(list.get(j));
                j++;
            } else {
                datas.add(new MatterReportVO(DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime())));
            }
            calendar.add(Calendar.DATE, 1);
        }
        if (list.size() == j) {
            datas.add(new MatterReportVO(DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime())));
        } else if (DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime()).equals(list.get(j).getReportTime())) {
            datas.add(list.get(j));
        } else {
            datas.add(new MatterReportVO(DateUtils.parseDateToStr("yyyy-MM-dd", calendar.getTime())));
        }

        return datas;
    }

    @GetMapping("/matterList/{id}")
    public String matterList(@PathVariable("id") Long id, ModelMap modelMap) {

        modelMap.put("id", id);

        return prefix + "/matterList";
    }

    @PostMapping("/updateCreativitiesVideo")
    @ResponseBody
    public AjaxResult updateCreativitiesVideo(CreativitiesVideoRequest request) {

        //查出该计划创意部分的所有内容
        ThCreativity thCreativity = new ThCreativity();
        thCreativity.setAdvertiserId(request.getAdvertiserId().toString());
        thCreativity.setAdId(request.getAdId().toString());
        List<ThCreativity> thCreativities = thCreativityService.selectThCreativityList(thCreativity);
        thCreativity = thCreativities.get(0);
        //查询要投放的素材对应的头条的id
//        ThVideoMatterToday todayVO = new ThVideoMatterToday();
//        todayVO.setMatterId(Long.valueOf(request.getMatterIds()));
//        todayVO.setAdvertiserId(request.getAdvertiserId().toString());
//        List<ThVideoMatterToday> thVideoMatterTodays = thVideoMatterTodayService.selectThVideoMatterTodayList(todayVO);
//        if (thVideoMatterTodays.size() == 0) {
//            try {
//                thVideoMatterTodayService.insertThVideoMatterToday(todayVO);
//                return AjaxResult.success("更新成功");
//            } catch (Exception e) {
//                logger.error("出现错误：", e);
//                return AjaxResult.error(e.getMessage());
//            }
//        }
        //替换选中的创意的素材
        for (ThCreativityCreatives thCreativityCreatives : thCreativity.getCreatives()) {
            if (thCreativityCreatives.getId().intValue() == request.getId().intValue()) {
//                thCreativityCreatives.setVideoId(todayVO.getTodayMatterIdId());
                //将一些字符串转为数组，以便发送头条
                thCreativityCreatives.setCreative_word_ids(thCreativityCreatives.getCreativeWordIds().split(","));
                break;
            }
        }
        //将一些字符串转为数组，以便发送头条
        thCreativity.setInventory_type(thCreativity.getInventoryType().split(","));
        thCreativity.setAd_keywords(thCreativity.getAdKeywords().split(","));
        //发送头条，更改定单状态
        try {
            thVideoOrderService.putInMatter(thCreativity);
            return AjaxResult.success("更新成功");
        } catch (Exception e) {
            logger.error("出现错误：", e);
            return AjaxResult.error(e.getMessage());
        }

    }

    @PostMapping("/matterList")
    @ResponseBody
    public TableDataInfo matterList(ThVideoMatter matter) {

        List<ThVideoMatter> thVideoMatters = thVideoMatterService.selectThVideoMatterList(matter);

        return getDataTable(thVideoMatters);
    }


    /**
     * 查询视频订单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ThVideoOrder thVideoOrder) {
        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        if (thVideoOrder.getSql() == null || thVideoOrder.getSql().equals("")) {
            thVideoOrder.setSql("order by a.id desc");
        }
        //是否有视频组角色
        for (SysRole role : roles) {
            if (role.getRoleKey().equals("videogroup")) {
                //视频组看指定给本组的
                SysDictData sysDictData = dictDataService.selectDictDataByDictValue(ShiroUtils.getLoginName());
                thVideoOrder.getNeed().setGroup(sysDictData.getDictType());
                startPage();
//                List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
                List<ThVideoOrder> list = thVideoOrderService.selectVideoOrderList(thVideoOrder);
                return getDataTable(list);
            }
            if (role.getRoleKey().equals("admin") || role.getRoleKey().equals("yunyingmanage")) {
                //管理员
                startPage();
//                List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
                List<ThVideoOrder> list = thVideoOrderService.selectVideoOrderList(thVideoOrder);
                return getDataTable(list);
            }
            if (role.getRoleKey().equals("videomanage")) {
                List<SysPost> sysPosts = sysPostService.selectPostsByUserId(ShiroUtils.getUserId());
                for (SysPost post : sysPosts) {
                    if (post.isFlag()) {
                        thVideoOrder.getNeed().setVideoDept(post.getPostCode());
                        break;
                    }
                }
                //视频管理员
                startPage();
//                List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
                List<ThVideoOrder> list = thVideoOrderService.selectVideoOrderList(thVideoOrder);
                return getDataTable(list);
            }
            if (role.getRoleKey().equals("yunying")) {
                //运营
                thVideoOrder.setCreateDept(ShiroUtils.getSysUser().getDept().getDeptId());
                thVideoOrder.setCreateBy(ShiroUtils.getLoginName());
                startPage();
//                List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
                List<ThVideoOrder> list = thVideoOrderService.selectVideoOrderList(thVideoOrder);
                return getDataTable(list);
            }
        }
        return getDataTable(new ArrayList<ThVideoOrder>());
    }

    /**
     * 查询视频订单列表
     */
    @PostMapping("/dictGetType")
    @ResponseBody
    public List<SysDictData> dictGetType(String type) {
        List<SysDictData> list = dictDataService.selectDictDataByType(type);
        return list;
    }

    /**
     * 导出视频订单列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ThVideoOrder thVideoOrder) {
        List<ThVideoOrder> list = thVideoOrderService.selectThVideoOrderList(thVideoOrder);
        ExcelUtil<ThVideoOrder> util = new ExcelUtil<ThVideoOrder>(ThVideoOrder.class);
        return util.exportExcel(list, "order");
    }

    @PostMapping("/updateStatus")
    @ResponseBody
    public AjaxResult updateStatus(@RequestParam("statusName") String statusName, ThVideoOrder thVideoOrder) {
        int i = 0;
        try {
            i = thVideoOrderService.updateOrderStatus(thVideoOrder, statusName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toAjax(i);
    }

    /**
     * 新增视频订单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 交付视频素材
     */
    @Log(title = "视频订单", businessType = BusinessType.INSERT)
    @PostMapping("/delivery")
    @ResponseBody
    public AjaxResult delivery(MultipartFile file_data, ThVideoOrder thVideoOrder) {
        if (file_data == null) {
            return toAjax(0);
        }
        thVideoOrder.setScript(file_data);
        try {
            thVideoOrderService.orderDelivery(thVideoOrder);
        } catch (Exception e) {
            return toAjax(0);
        }
        return toAjax(1);
    }

    /**
     * 补交付视频素材
     */
    @Log(title = "视频订单", businessType = BusinessType.INSERT)
    @PostMapping("/deliveryAgain")
    @ResponseBody
    public AjaxResult deliveryAgain(MultipartFile file_data, ThVideoOrder thVideoOrder) {
        if (file_data == null) {
            return toAjax(0);
        }
        thVideoOrder.setScript(file_data);
        try {
            thVideoOrderService.orderDeliveryAgain(thVideoOrder);
        } catch (Exception e) {
            return toAjax(0);
        }
        return toAjax(1);
    }

    /**
     * 新增保存视频订单
     */
    @Log(title = "视频订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("logoFile") MultipartFile logoUrl, @RequestParam("videoScriptFile") MultipartFile videoScript, ThVideoOrder thVideoOrder) {
        thVideoOrder.setLogo(logoUrl);
        thVideoOrder.setScript(videoScript);
        thVideoOrder.setCreateBy(ShiroUtils.getLoginName());
        thVideoOrder.setCreateDept(ShiroUtils.getSysUser().getDept().getDeptId());
        try {
            thVideoOrder.setStatus(VideoOrderStatusEnum.ORDER.getValue());
            thVideoOrderService.insertThVideoOrder(thVideoOrder);
        } catch (Exception e) {
            return toAjax(0);
        }
        return toAjax(1);
    }

    /**
     * 查看视频订单
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/detail";
    }

    /**
     * 交付视频订单
     */
    @GetMapping("/delivery/{id}")
    public String delivery(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/delivery";
    }

    /**
     * 补交付视频订单
     */
    @GetMapping("/deliveryAgain/{id}")
    public String deliveryAgain(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/deliveryAgain";
    }

    /**
     * 投放视频
     */
    @GetMapping("/putIn/{id}")
    public String putIn(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/putIn";
    }

    /**
     * 修改视频订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(id);
        mmap.put("thVideoOrder", thVideoOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存视频订单
     */
    @Log(title = "视频订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam("videoScriptFile") MultipartFile videoScript, ThVideoOrder thVideoOrder) {
        thVideoOrder.setScript(videoScript);

        try {
            thVideoOrderService.updateThVideoOrder(thVideoOrder);
        } catch (Exception e) {
            return toAjax(0);
        }
        return toAjax(1);

    }

    /**
     * 删除视频订单
     */
    @Log(title = "视频订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long ids) {
        return toAjax(thVideoOrderService.deleteThVideoOrderById(ids));
    }


    @GetMapping("/downloadFile/{id}")
    public void downloadFile(@PathVariable("id") Long id, HttpServletResponse response) {

        ThVideoMatter thVideoMatter = thVideoMatterService.selectThVideoMatterById(id);
        ThVideoOrder thVideoOrder = thVideoOrderService.selectThVideoOrderById(thVideoMatter.getOrderId());
        File file = null;
        try {
            String s = PmsUploadUtil.downLoadFile(thVideoMatter.getMatter(), thVideoMatter.getFileName());
            file = new File(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        ServletOutputStream outputStream = null;
        try {
            // 下载名称
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            if (thVideoMatter.getVideoCover() == null) {
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("xphlsc" + DateUtils.parseDateToStr("yyyyMMdd", new Date()) + "-" + thVideoMatter.getFileName(), "utf-8"));
            } else {
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("xphlsc" + DateUtils.parseDateToStr("yyyyMMdd", thVideoOrder.getNeed().getEndTime()) + thVideoMatter.getId() + "-" + thVideoMatter.getFileName(), "utf-8"));
            }
            outputStream = response.getOutputStream();
            FileUtils.writeBytes(file.getAbsolutePath(), outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            file.delete();
        }


    }

//    /**
//     * 删除视频订单
//     */
//    @Log(title = "视频订单", businessType = BusinessType.DELETE)
//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids) {
//        return toAjax(thVideoOrderService.deleteThVideoOrderByIds(ids));
//    }
}