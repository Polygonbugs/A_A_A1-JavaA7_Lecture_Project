package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.VisitDAO;
import model.dto.VisitDTO;

public class VisitService {

	public boolean add(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		int result = dao.insert(dto);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public List<VisitDTO> getList() {
		VisitDAO dao = new VisitDAO();
		List<VisitDTO> dataList = dao.select();
		return dataList;
	}

    public List<VisitDTO> getPage(int pNum) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", (pNum - 1) * 10 + 1);
		page.put("end", pNum * 10);

		VisitDAO dao = new VisitDAO();
		List<VisitDTO> dataList = dao.selectPage(page);
		dao.close();
		return dataList;
    }

	public List<Integer> getPageList() {
		VisitDAO dao = new VisitDAO();
		int totalRowCount = dao.selectTotalRowCount();
		int mod = totalRowCount % 10 == 0? 0 : 1;
		int pageCount = (totalRowCount / 10) + mod;

		List<Integer> pageList = new ArrayList<Integer>();
		for(int i = 1; i <= pageCount; i++) {
			pageList.add(i);
		}
		return pageList;
	}
}
