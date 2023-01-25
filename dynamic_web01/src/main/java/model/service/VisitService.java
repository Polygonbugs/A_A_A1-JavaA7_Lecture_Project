package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.VisitDAO;
import model.dto.VisitDTO;
import page.Paging;

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
		dao.close();
		return dataList;
	}

	public Paging getPage(int pNum, int cnt) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", (pNum - 1) * cnt + 1);
		page.put("end", pNum * cnt);

		VisitDAO dao = new VisitDAO();
		List<VisitDTO> dataList = dao.selectPage(page);

		int totalRowCount = dao.selectTotalRowCount();
		int mod = totalRowCount % cnt == 0 ? 0 : 1;
		int pageCount = (totalRowCount / cnt) + mod;

		Paging paging = new Paging(dataList, pNum, pageCount, cnt, 5);
		dao.close();
		return paging;
	}

}
