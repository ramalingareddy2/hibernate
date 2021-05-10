package com.sar.test;

import com.sar.dao.JobDao;
import com.sar.entities.Job;

public class SARTest {
	public static void main(String[] args) {
		JobDao dao = new JobDao();
		Job job = dao.getJob(2);
		System.out.println(job);
	}
}
