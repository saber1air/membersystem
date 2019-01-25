package com.deliver.service;

import com.deliver.dao.AdvertDao;
import com.deliver.dao.HumanInfoDao;
import com.deliver.dao.NoticeDao;
import com.deliver.dao.NoticeRecordDao;
import com.deliver.entity.Advert;
import com.deliver.entity.HumanInfo;
import com.deliver.entity.Notice;
import com.deliver.entity.NoticeRecord;
import com.deliver.util.AppPushUtils;
import com.deliver.util.ResultInfo;
import com.gexin.rp.sdk.base.IPushResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pdl on 2018/9/13.
 */

@Service
public class NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private NoticeRecordDao noticeRecordDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HumanInfoDao humanInfoDao;

    private static String appId = "jPX0kbnuCc8Og0gmSBnu3";
    private static String appKey = "Og6qT7rLNN9fixE8O7ppR4";
    private static String masterSecret = "x28EanpNuRA1fMjoDS1Tv9";

    public List<Notice> findBySchoolIDAndDeleteFlag(int id, int deleteFlag) {
        return noticeDao.findBySchoolIDAndDeleteFlag(id,deleteFlag);
    }

    public List<Notice> findBySchoolIDAndUpdateTimeAfter(int id,Date date){
        return noticeDao.findBySchoolIDAndUpdateTimeAfter(id, date);
    }


    public Notice save(Notice notice) {
        notice.setCreateTime(new Date());
        notice.setUpdateTime(new Date());
        return noticeDao.save(notice);
    }



    public Notice update(Notice notice) {
        notice.setUpdateTime(new Date());
        return noticeDao.save(notice);
    }

    public Notice delAdvert(Notice notice) {
        notice.setUpdateTime(new Date());
        notice.setDeleteFlag(1);
        return noticeDao.save(notice);
    }

    public int delete(int id) {
        return noticeDao.deleteByNoticeID(id);
    }

    public List<NoticeRecord> getNoticeRecord(int humanID){
        List<NoticeRecord> noticeRecordList = noticeRecordDao.findByHumanIDAndDeleteFlagOrderByCreateTimeDesc(humanID,0);
        if(noticeRecordList!=null && noticeRecordList.size()>10){
            for(int i=10;i<noticeRecordList.size();i++){
                noticeRecordList.remove(noticeRecordList.get(i));
            }
        }
        return noticeRecordList;
    }

    public ResultInfo noticeGeTui(Notice notice) {//系统通知推送
        List<HumanInfo> humanlist = humanInfoDao.findBySchoolIDAndCheckFlagAndHumanTypeAndDeleteFlag(notice.getSchoolID(),1,0,0);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        ResultInfo resultInfo = new ResultInfo(false);
        AppPushUtils pushUtils = new AppPushUtils(appId, appKey, masterSecret);
        if (humanlist != null && humanlist.size() > 0 && notice.getNoticeType()==1) {
            for (HumanInfo human : humanlist) {


                String ssql = "select b.human_name,b.humanid,b.tel,b.clientid from tc_parent_student_rel a,tc_human_info b where a.humanid=" + human.getHumanID() +
                        " and a.homeid=b.humanid and b.delete_flag=0 and a.delete_flag=0 and a.check_flag=1 and b.check_flag=1";

                List<Map<String, Object>> parentList = jdbcTemplate.queryForList(ssql);
                Map<String, String> msg = new HashMap<String, String>();
                msg.put("title", "系统通知消息！");
                msg.put("titleText", notice.getNoticeContent());
                msg.put("transText", "");

                if (parentList != null && parentList.size() > 0) {
                    for (Map map : parentList) {
                        System.out.println("正在发送消息...");
                        if (map.get("clientid") != null) {
                            IPushResult ret = pushUtils.pushMsgToSingle(map.get("clientid").toString(), msg);
                            NoticeRecord noticeRecord = new NoticeRecord();
                            noticeRecord.setAccessoryPath(notice.getAccessoryPath());
                            noticeRecord.setCreateTime(new Date());
                            noticeRecord.setDeleteFlag(0);
                            noticeRecord.setHumanID((Integer) map.get("humanid"));
                            noticeRecord.setNoticeContent(notice.getNoticeContent());
                            noticeRecord.setNoticeType(notice.getNoticeType());
                            noticeRecord.setRemarks(notice.getRemarks());
                            noticeRecord.setSchoolID(notice.getSchoolID());
                            noticeRecord.setUpdateTime(new Date());
                            noticeRecordDao.save(noticeRecord);

                        }
                    }
                }


            }
        }else if(notice.getNoticeType()==2){
            List<HumanInfo> teacherlist = humanInfoDao.findBySchoolIDAndCheckFlagAndHumanTypeAndDeleteFlag(notice.getSchoolID(),1,2,0);

            Map<String, String> msg = new HashMap<String, String>();
            msg.put("title", "系统通知消息！");
            msg.put("titleText", notice.getNoticeContent());
            msg.put("transText", "");

            if(teacherlist!=null && teacherlist.size()>0){
                for (HumanInfo teacher : teacherlist) {
                    System.out.println("正在发送消息...");
                    if (teacher.getClientID() != null) {
                        IPushResult ret = pushUtils.pushMsgToSingle(teacher.getClientID(), msg);
                        NoticeRecord noticeRecord = new NoticeRecord();
                        noticeRecord.setAccessoryPath(notice.getAccessoryPath());
                        noticeRecord.setCreateTime(new Date());
                        noticeRecord.setDeleteFlag(0);
                        noticeRecord.setHumanID(teacher.getHumanID());
                        noticeRecord.setNoticeContent(notice.getNoticeContent());
                        noticeRecord.setNoticeType(notice.getNoticeType());
                        noticeRecord.setRemarks(notice.getRemarks());
                        noticeRecord.setSchoolID(notice.getSchoolID());
                        noticeRecord.setUpdateTime(new Date());
                        noticeRecordDao.save(noticeRecord);
                    }
                }
            }
        }else if(notice.getNoticeType()==3){
           List<HumanInfo> managerlist = humanInfoDao.findBySchoolIDAndCheckFlagAndHumanTypeAndDeleteFlag(notice.getSchoolID(),1,3,0);

            Map<String, String> msg = new HashMap<String, String>();
            msg.put("title", "系统通知消息！");
            msg.put("titleText", notice.getNoticeContent());
            msg.put("transText", "");

            if(managerlist!=null && managerlist.size()>0){
                for (HumanInfo manager : managerlist) {
                    System.out.println("正在发送消息...");
                    if (manager.getClientID() != null) {
                        IPushResult ret = pushUtils.pushMsgToSingle(manager.getClientID(), msg);

                        NoticeRecord noticeRecord = new NoticeRecord();
                        noticeRecord.setAccessoryPath(notice.getAccessoryPath());
                        noticeRecord.setCreateTime(new Date());
                        noticeRecord.setDeleteFlag(0);
                        noticeRecord.setHumanID(manager.getHumanID());
                        noticeRecord.setNoticeContent(notice.getNoticeContent());
                        noticeRecord.setNoticeType(notice.getNoticeType());
                        noticeRecord.setRemarks(notice.getRemarks());
                        noticeRecord.setSchoolID(notice.getSchoolID());
                        noticeRecord.setUpdateTime(new Date());
                        noticeRecordDao.save(noticeRecord);
                    }
                }
            }
        }
        resultInfo.setCode(200);
        resultInfo.setSuccess(true);
        resultInfo.setMessage("系统通知发送成功！");

        return resultInfo;
    }
}
