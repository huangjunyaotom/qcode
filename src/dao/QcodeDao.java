package dao;

import org.hibernate.Session;

import entity.Qcode;

public interface QcodeDao {
public Session getSession();
public Qcode getByUuid(String uuid);
public void deleteByUuid(Qcode q);
public void updateFilePathByUuid(Qcode q);
public void save(Qcode q);
}
