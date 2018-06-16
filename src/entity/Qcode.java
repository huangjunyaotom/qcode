package entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="table_code_id")
public class Qcode {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String code_no;
	
	
	private Integer is_printed;
	private String file_path;
	
	
	private Timestamp use_time;
	public Qcode() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode_no() {
		return code_no;
	}
	public void setCode_no(String code_no) {
		this.code_no = code_no;
	}
	
	
	public Integer getIs_printed() {
		return is_printed;
	}
	public void setIs_printed(Integer is_printed) {
		this.is_printed = is_printed;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	public Timestamp getUse_time() {
		return use_time;
	}
	public void setUse_time(Timestamp use_time) {
		this.use_time = use_time;
	}
	
	
}
