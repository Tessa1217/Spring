package com.company.mvc.reply;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReplyVO {
	
	private String rno;
	private String bno;
	private String reply;
	private String replyer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	//@JsonIgnore (해당 필드 빠짐)
	private Date updateDate;

}
