package model.service;

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
}
