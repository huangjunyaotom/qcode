package dao;

import java.util.Date;
import java.util.List;

import entity.Qcode;

public interface QcodeDao {



//更新,插入方法
public void saveOrUpdate(Qcode q);
//删除方法
public void delete(Qcode q);
//取值方法,不唯一
public List<Qcode> getUnPrinted();
public Qcode getByUuid(String code_no);
public List<Qcode> getBeforeTime(Date date);
}
