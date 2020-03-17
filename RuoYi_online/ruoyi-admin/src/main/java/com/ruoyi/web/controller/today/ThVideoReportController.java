package com.ruoyi.web.controller.today;

import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.today.domain.ThMatterManage;
import com.ruoyi.today.domain.ThMediaVideoCountVO;
import com.ruoyi.today.domain.ThVideoMatterReport;
import com.ruoyi.today.domain.ThVideoOrder;
import com.ruoyi.today.service.IThVideoMatterManageService;
import com.ruoyi.today.service.IThVideoMatterReportService;
import com.ruoyi.today.service.IThVideoMatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/today/videoReport")
public class ThVideoReportController {

    @Autowired
    private IThVideoMatterService thVideoMatterService;
    @Autowired
    private IThVideoMatterManageService thVideoMatterManageService;
    @Autowired
    private ISysDictDataService sysDictDataService;
    @Autowired
    private ISysPostService sysPostService;

    @PostMapping("/mediaVideoCount")
    @ResponseBody
    public List<ThMediaVideoCountVO> mediaVideoCount(ThMediaVideoCountVO thMediaVideoCountVO) {

        List<SysRole> roles = ShiroUtils.getSysUser().getRoles();
        //是否有视频组角色
        for (SysRole role : roles) {
            if (role.getRoleKey().equals("videogroup")) {
                //视频组看指定给本组的
                SysDictData sysDictData = sysDictDataService.selectDictDataByDictValue(ShiroUtils.getLoginName());
                thMediaVideoCountVO.setVideoGroup(sysDictData.getDictType());
                List<ThMediaVideoCountVO> list = thVideoMatterService.selectThVideoMatterGroupByMedia(thMediaVideoCountVO);
                return list;
            }
            if (role.getRoleKey().equals("admin") || role.getRoleKey().equals("yunyingmanage") || role.getRoleKey().equals("adminyu")) {
                //管理员
                List<ThMediaVideoCountVO> list = thVideoMatterService.selectThVideoMatterGroupByMedia(thMediaVideoCountVO);
                return list;
            }
            if (role.getRoleKey().equals("videomanage")) {
                List<SysPost> sysPosts = sysPostService.selectPostsByUserId(ShiroUtils.getUserId());
                for (SysPost post : sysPosts) {
                    if (post.isFlag()) {
                        thMediaVideoCountVO.setVideoDept(post.getPostCode());
                        break;
                    }
                }
                //视频管理员
                List<ThMediaVideoCountVO> list = thVideoMatterService.selectThVideoMatterGroupByMedia(thMediaVideoCountVO);
                return list;
            }
        }


        return new ArrayList<>();

    }

    @PostMapping("/topCost")
    @ResponseBody
    public List<ThMatterManage> topCost() {
        ThMatterManage thMatterManage = new ThMatterManage();
        thMatterManage.setSql(" order by d.reportCost desc limit 0,3");
        List<ThMatterManage> list = thVideoMatterManageService.selectMatter(thMatterManage);
        return list;

    }

}
