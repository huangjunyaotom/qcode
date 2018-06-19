package task;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.QcodeDao;
import entity.Qcode;
@Component
public class DailyTask{
	
	@Autowired
	private QcodeDao qcodeDao;
	
	
	public void setQcodeDao(QcodeDao qcodeDao) {
		this.qcodeDao = qcodeDao;
	}

	//事务,每天1点执行一次
	@Transactional
	@Scheduled(cron="0 0 1 * * *")
	public void execute()  {
		// TODO Auto-generated method stub
		/*
		 * 每天上午10点执行一次
		 * 
		 * 获取当前时间搓
		 * 计算8天前的时间点
		 * 选取use_time小鱼8天前时间点的所有记录
		 * 删除uploadfile里面对应的文件
		 * 删除mysql里面对应的记录
		 * 
		 */
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_YEAR, now.get(Calendar.DAY_OF_YEAR) - 8); 
		
		List<Qcode> qcodes	=qcodeDao.getBeforeTime(now.getTime());
		if (!qcodes.isEmpty()) {
			for (Qcode q : qcodes) {
				File f = new File(q.getFile_path());
				if (null != f) {
					f.delete();
				}
				
				qcodeDao.delete(q);
			} 
		}
		
	}

}
