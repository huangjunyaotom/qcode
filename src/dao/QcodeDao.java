package dao;

import java.util.List;

import org.hibernate.SessionFactory;


import entity.Qcode;

public interface QcodeDao {

public Qcode getByUuid(String uuid);
public void deleteByUuid(Qcode q);
public void updateFilePathByUuid(Qcode q);
public void save(Qcode q);
public List<Qcode> getUnPrinted();
public void update(Qcode q);
}
