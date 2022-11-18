package kr.co.view;

import java.util.ArrayList;

import kr.co.db.vo.JobVO;

public class JobView {

	public void print(ArrayList<JobVO> datas) {
		for(JobVO job: datas) {
			System.out.println(job);
		}
	}

}
