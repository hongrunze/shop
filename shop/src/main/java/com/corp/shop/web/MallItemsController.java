package com.corp.shop.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.sql.core.engine.PageQuery;
import org.jxls.common.Context;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReadMessage;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ibeetl.admin.console.web.dto.DictExcelImportData;
import com.ibeetl.admin.console.web.query.UserQuery;
import com.ibeetl.admin.core.annotation.Function;
import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.entity.CoreDict;
import com.ibeetl.admin.core.entity.CoreUser;
import com.ibeetl.admin.core.file.FileItem;
import com.ibeetl.admin.core.file.FileService;
import com.ibeetl.admin.core.web.JsonResult;
import com.ibeetl.admin.core.util.*;
import com.corp.shop.entity.*;
import com.corp.shop.service.*;
import com.corp.shop.web.query.*;

/**
 * MallItems 接口
 */
@Controller
public class MallItemsController{

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String MODEL = "/shop/mallItems";


    @Autowired private MallItemsService mallItemsService;
    
    @Autowired
    FileService fileService;
    /* 页面 */

    @GetMapping(MODEL + "/index.do")
    @Function("shop.mallItems.query")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/shop/mallItems/index.html") ;
        view.addObject("search", MallItemsQuery.class.getName());
        return view;
    }

    @GetMapping(MODEL + "/edit.do")
    @Function("shop.mallItems.edit")
    @ResponseBody
    public ModelAndView edit(Integer itemId) {
        ModelAndView view = new ModelAndView("/shop/mallItems/edit.html");
        MallItems mallItems = mallItemsService.queryById(itemId);
        view.addObject("mallItems", mallItems);
        return view;
    }

    @GetMapping(MODEL + "/add.do")
    @Function("shop.mallItems.add")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("/shop/mallItems/add.html");
        return view;
    }

    /* ajax json */

    @PostMapping(MODEL + "/list.json")
    @Function("shop.mallItems.query")
    @ResponseBody
    public JsonResult<PageQuery> list(MallItemsQuery condtion)
    {
        PageQuery page = condtion.getPageQuery();
        mallItemsService.queryByCondition(page);
        return JsonResult.success(page);
    }

    @PostMapping(MODEL + "/add.json")
    @Function("shop.mallItems.add")
    @ResponseBody
    public JsonResult add(@Validated(ValidateConfig.ADD.class)MallItems mallItems)
    {
        mallItemsService.save(mallItems);
        return new JsonResult().success();
    }

    @PostMapping(MODEL + "/edit.json")
    @Function("shop.mallItems.edit")
    @ResponseBody
    public JsonResult<String> update(@Validated(ValidateConfig.UPDATE.class)  MallItems mallItems) {
        boolean success = mallItemsService.update(mallItems);
        if (success) {
            return new JsonResult().success();
        } else {
            return JsonResult.failMessage("保存失败");
        }
    }


   
    @GetMapping(MODEL + "/view.json")
    @Function("shop.mallItems.query")
    @ResponseBody
    public JsonResult<MallItems>queryInfo(Integer itemId) {
        MallItems mallItems = mallItemsService.queryById( itemId);
        return  JsonResult.success(mallItems);
    }

    @PostMapping(MODEL + "/delete.json")
    @Function("shop.mallItems.delete")
    @ResponseBody
    public JsonResult delete(String ids) {
        if (ids.endsWith(",")) {
            ids = StringUtils.substringBeforeLast(ids, ",");
        }
        List<Long> idList = ConvertUtil.str2longs(ids);
        mallItemsService.batchDelMallItems(idList);
        return new JsonResult().success();
    }
    

}
